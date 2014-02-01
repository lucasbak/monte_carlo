/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Random;

/**
 *
 * @author Bakalian
 */
public class MonteCarloSimulation {
	public double MonteCarloStandarOption(String CallPutFlag,double S,double X,double T,double r,double b,double v,int nSteps,int nSimulations){
		double dt,St,Sum,Drift,vSqrdt;
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
		
		Sum=0;
		for(int i=1;i<nSimulations;i++){
			St=S;
			for(int j=1;j<nSteps;j++){
				St=St*Math.exp(Drift + (vSqrdt*(new Random().nextGaussian())));
			}
			Sum=Sum+Math.max(z*(St-X), 0);
		}

		resultat=Math.exp(-r * T)*(Sum/nSimulations);
		return resultat;
	}
}