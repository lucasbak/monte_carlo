package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ControllerFrame;
import modelSingleThread.MonteCarloSimulation;

public class viewTemp extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton clic;
	public JLabel label;
	public viewTemp(MonteCarloSimulation model){
		clic = new JButton("clic");
		label = new JLabel();
		ControllerFrame controlFrame = new ControllerFrame(model, this);
		clic.addActionListener(controlFrame);
		
		setSize(new Dimension(250,250));
		add(clic, BorderLayout.NORTH);
		
		setVisible(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		label.setText("The result is ");
	}
}
