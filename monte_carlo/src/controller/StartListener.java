/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import view.ArgumentSetViewer;
import view.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelMultiThread.MonteCarloSimulationMultiThread;
import modelSingleThread.MonteCarloSimulationSingleThread;

/**
 *déclenche la simulation en lisant les champs d'entrées
 * @author Bakalian
 */
public class StartListener implements ActionListener{

	private static final int IS_SINGLE_THREAD_CHOICE = 0;
	private final ArgumentSetViewer myRootViewer;
	private final Window myRootWindow;

	public StartListener(ArgumentSetViewer myRootPane,Window w) {
		this.myRootViewer = myRootPane;
		myRootWindow=w;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double resultat=0;
		String flag=myRootViewer.getFlag().getText();
		double S=Double.parseDouble(myRootViewer.getMyS().getText());
		double X=Double.parseDouble(myRootViewer.getMyX().getText());
		double T=Double.parseDouble(myRootViewer.getMyT().getText());
		double r=Double.parseDouble(myRootViewer.getMyR().getText());
		double b=Double.parseDouble(myRootViewer.getMyB().getText());
		double v=Double.parseDouble(myRootViewer.getMyV().getText());
		int nSteps=Integer.parseInt(myRootViewer.getnSteps().getText());
		int nSimulations=Integer.parseInt(myRootViewer.getnSimulations().getText());

		if(myRootWindow.getThreadingChoice().getSelectedIndex()== IS_SINGLE_THREAD_CHOICE){

			MonteCarloSimulationSingleThread mcs=new MonteCarloSimulationSingleThread();
			resultat = mcs.MonteCarloStandarOption(flag, S, X, T, r, b, v, nSteps, nSimulations);
		}
		else{
			try {
				MonteCarloSimulationMultiThread mcs=new MonteCarloSimulationMultiThread();
				resultat=mcs.MonteCarloStandarOption(flag, S, X, T, r, b, v, nSteps, nSimulations);
			} catch (InterruptedException ex) {
				Logger.getLogger(StartListener.class.getName()).log(Level.SEVERE, null, ex);
			} catch (ExecutionException ex) {
				Logger.getLogger(StartListener.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		myRootWindow.getResult().setText(String.valueOf(resultat));

	}
}
