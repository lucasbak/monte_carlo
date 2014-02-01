package model;

import java.util.concurrent.ExecutionException;

public interface MonteCarloSimulation {
	public double MonteCarloStandarOption(
			String CallPutFlag,
			double S,
			double X,
			double T,
			double r,
			double b,
			double v,
			int nSteps,
			int nSimulations) throws InterruptedException, ExecutionException;
}
