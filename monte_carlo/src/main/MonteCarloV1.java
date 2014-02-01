/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.util.concurrent.ExecutionException;

import view.viewTemp;
import modelSingleThread.MonteCarloSimulation;
//import modelMultiThread.MonteCarloSimulation;

/**
 *
 * @author Bakalian
 */
public class MonteCarloV1 {

    /**
     * @param args the command line arguments
     * @throws ExecutionException 
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        MonteCarloSimulation simulationOneThread=new MonteCarloSimulation();
        String Flag="c";
        double S=40;
        double X=50;
        double T=0.06;
        double r=0.5;
        double b=0.10;
        double v=0.45;
        int nSteps=168;
        int nSimulations=100000;
        
        //MonteCarloSimulation model = new MonteCarloSimulation();
        //viewTemp view = new viewTemp(model);
        
        long before = System.currentTimeMillis();
		System.out.println("le resultat est :"+ simulationOneThread.MonteCarloStandarOption(Flag,S,X,r,T,b,v,nSteps,nSimulations));
		long after = System.currentTimeMillis();
		System.out.println("It take "+(after-before)+" millisecondes");
    }
    
}
