/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelMultiThread;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Bakalian
 */
public class MonteCarloSimulation {
	public double MonteCarloStandarOption(String CallPutFlag,final double S,double X,double T,double r,double b,double v,final int nSteps,int nSimulations) throws InterruptedException, ExecutionException{
		final double blockingCoefficient = 0.9;
		final int poolSize = (int)(Runtime.getRuntime().availableProcessors() / (1 - blockingCoefficient));
		final List<Callable<Double>> pool = new ArrayList<Callable<Double>>();

		double dt,St,Sum = 0;
		final double Drift;
		final double vSqrdt;
		int z = 1;
		double resultat;

		dt= T / nSteps;
		Drift=(b-v*v/2)*dt;
		vSqrdt=v*(Math.sqrt(dt));

		if(CallPutFlag.equalsIgnoreCase("c")){
			z=1;
		}
		else if(CallPutFlag.equals("p")){
			z=-1;
		}


		for(int i=1;i<nSimulations;i++){
			pool.add(new Callable<Double>(){

				@Override
				public Double call() throws Exception {
					Double St= S ;
					for(int j=1;j<nSteps;j++){
						St=St*Math.exp(Drift + (vSqrdt*(new Random().nextGaussian())));
					}
					return St;
				}

			});

			final ExecutorService executorPool = Executors.newFixedThreadPool(poolSize);    
			final List<Future<Double>> valueOfSimulations = executorPool.invokeAll(pool, 10000, TimeUnit.SECONDS);
			
			//wait all
			executorPool.shutdown();
			
			for(Future<Double> valueOfASimulation : valueOfSimulations){
				Sum=Sum+Math.max(z*(valueOfASimulation.get()-X), 0);
			}
		}

		resultat=Math.exp(-r * T)*(Sum/nSimulations);
		return resultat;
	}
}