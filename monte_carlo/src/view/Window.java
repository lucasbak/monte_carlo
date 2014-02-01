/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.StartListener;
import model.ArgumentSetList;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *cette classe represente la fenêtre
 * on y créer chaque élement la composant ( set d'argument et boutton)
 * @author Bakalian
 */
public class Window  extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String[] labels={"Single Threaded Version","Multi Thread Version"};
	
	private final ArgumentSetList argumentSetList;
	private final JPanel mainBackground;
	private final JPanel textFieldBackground;
	private final JButton LaunchButton;
	private final JLabel Result;
	private JComboBox<String> threadingChoice;
	private ArgumentSetViewer ArgumentViewer; 

	public Window (ArgumentSetList asl){
		super();
		this.setTitle("Monte-Carlo Calculator");

		argumentSetList=asl;
		threadingChoice=new JComboBox<String>(labels);
		mainBackground=new JPanel();// le panel principal avec un gridbaglayout pour une disposition précise
		textFieldBackground=new JPanel();// un JPanel qui contiendra tous les Jtextfields
		LaunchButton=new JButton("Start Simulation");// le boutton pour démarrer
		Result=new JLabel("");// le jlabel pour afficher le résultat
		mainBackground.setLayout(new GridBagLayout());
		textFieldBackground.setLayout(new GridLayout());
		GridBagConstraints c= new GridBagConstraints();

		c.ipadx=5;
		c.ipady=5;
		c.gridwidth=GridBagConstraints.REMAINDER;

		c.gridx=1;
		c.gridy=1;
		mainBackground.add(threadingChoice,c);
		
		c.gridy=2;
		ArgumentViewer=new ArgumentSetViewer(argumentSetList,this);
		textFieldBackground.add(ArgumentViewer.getBackground());
		mainBackground.add(textFieldBackground,c);

		c.gridy=3;
		LaunchButton.addActionListener(new StartListener(ArgumentViewer,this));
		mainBackground.add(LaunchButton,c); 

		c.gridy=4;
		mainBackground.add(this.Result,c);

		this.setContentPane(mainBackground);
		this.setSize(1000, 600);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2 - getWidth()/2, dim.height/2 - getHeight()/2);
		this.setVisible(true);
		this.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);      
	}

	public JComboBox<String> getThreadingChoice() {
		return threadingChoice;
	}


	public JLabel getResult() {
		return Result;
	}

}
