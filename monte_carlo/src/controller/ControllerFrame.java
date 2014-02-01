package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.viewTemp;
import modelSingleThread.MonteCarloSimulation;
//import modelMultiThread.MonteCarloSimulation;


public class ControllerFrame implements ActionListener {

	private MonteCarloSimulation model;
	private viewTemp view;
	public ControllerFrame(MonteCarloSimulation model, viewTemp viewTemp) {
		this.model = model;
		view = viewTemp;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
