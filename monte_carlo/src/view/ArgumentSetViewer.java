/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;
import controller.ArgumentListener;
import controller.ChoiceListener;
import controller.DeleteFieldListener;
import model.ArgumentSetList;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Bakalian
 */
public class ArgumentSetViewer {

	private final JComboBox<String> flagchoice;
	private final JComboBox<String> currentPriceChoice; // s
	private final JComboBox<String> strikePriceChoice; //X
	private final JComboBox<String> timechoice;//
	private final JComboBox<String> interestPriceChoice;// r
	private final JComboBox<String> fraisChoice; // b
	private final JComboBox<String> volatilityChoice;//v
	private final JComboBox<String> nStepsChoice;
	private final JComboBox<String> nSimulationsChoice;
	private final JPanel background;

	private JTextField flag;
	private JTextField myS;
	private JTextField myX;
	private JTextField myT;
	private JTextField myR;
	private JTextField myB;
	private JTextField myV;
	private JTextField nSteps;
	private JTextField nSimulations;


	private final JLabel flagLabel;
	private final JLabel sLabel;
	private final JLabel xLabel;
	private final JLabel tLabel;
	private final JLabel rLabel;
	private final JLabel bLabel;
	private final JLabel vLabel;
	private final JLabel nStepsLabel;
	private final  JLabel nSimulationLabel;



	public ArgumentSetViewer(ArgumentSetList listofargument,Window w) {
		background=new JPanel();
		background.setLayout(new GridBagLayout());
		// we add thefirst line of this Panel
		GridBagConstraints c=new GridBagConstraints();
		//------------------------------------------------------------------------------
		flagLabel=new JLabel("Flag :");
		sLabel=new JLabel("Current Price :");
		xLabel=new JLabel("Strike Price : ");
		tLabel=new JLabel("Maturity :");
		rLabel=new JLabel("No risk rate : ");
		bLabel=new JLabel("Global interest : ");
		vLabel=new JLabel("Volatility : ");
		nStepsLabel=new JLabel(" Step number : ");
		nSimulationLabel=new JLabel(" Simulation number : ");

		//creation all the text fields
		//------------------------------------------------------------------------------

		flag=new JTextField();
		myS=new JTextField();
		myX=new JTextField();
		myT=new JTextField();
		myR=new JTextField();
		myB=new JTextField();
		myV=new JTextField();
		nSteps=new JTextField();
		nSimulations=new JTextField();

		// Creating all the JcomboBox
		//------------------------------------------------------------------------------
		flagchoice=new JComboBox<String>();

		flagchoice.addItem("Retrieve");
		flagchoice.addItem("Call");
		flagchoice.addActionListener(new ChoiceListener(flagchoice,flag));

		currentPriceChoice=new JComboBox<String>();
		for(int i=0;i<listofargument.getListofArgumentSet().size();i++){
			currentPriceChoice.addItem(String.valueOf(listofargument.getListofArgumentSet().get(i).getS()));
		}
		currentPriceChoice.addActionListener(new ChoiceListener(currentPriceChoice,myS));



		strikePriceChoice=new JComboBox<String>();
		for(int i=0;i<listofargument.getListofArgumentSet().size();i++){
			strikePriceChoice.addItem(String.valueOf(listofargument.getListofArgumentSet().get(i).getX()));
		}
		strikePriceChoice.addActionListener(new ChoiceListener(strikePriceChoice,myX));


		timechoice=new JComboBox<String>();
		for(int i=0;i<listofargument.getListofArgumentSet().size();i++){
			timechoice.addItem(String.valueOf(listofargument.getListofArgumentSet().get(i).getT()));
		}
		timechoice.addActionListener(new ChoiceListener(timechoice,myT));

		interestPriceChoice=new JComboBox<String>();
		for(int i=0;i<listofargument.getListofArgumentSet().size();i++){
			interestPriceChoice.addItem(String.valueOf(listofargument.getListofArgumentSet().get(i).getR()));
		}
		interestPriceChoice.addActionListener(new ChoiceListener(interestPriceChoice,myR));

		fraisChoice=new JComboBox<String>();
		for(int i=0;i<listofargument.getListofArgumentSet().size();i++){
			fraisChoice.addItem(String.valueOf(listofargument.getListofArgumentSet().get(i).getB()));
		}
		fraisChoice.addActionListener(new ChoiceListener(fraisChoice,myB));

		volatilityChoice=new JComboBox<String>();
		for(int i=0;i<listofargument.getListofArgumentSet().size();i++){
			volatilityChoice.addItem(String.valueOf(listofargument.getListofArgumentSet().get(i).getV()));
		}
		volatilityChoice.addActionListener(new ChoiceListener(volatilityChoice,myV));

		nStepsChoice=new JComboBox<String>();
		for(int i=0;i<listofargument.getListofArgumentSet().size();i++){
			nStepsChoice.addItem(String.valueOf(listofargument.getListofArgumentSet().get(i).getnSteps()));
		}
		nStepsChoice.addActionListener(new ChoiceListener(nStepsChoice,nSteps));

		nSimulationsChoice=new JComboBox<String>();
		for(int i=0;i<listofargument.getListofArgumentSet().size();i++){
			nSimulationsChoice.addItem(String.valueOf(listofargument.getListofArgumentSet().get(i).getnSimulations()));
		}
		nSimulationsChoice.addActionListener(new ChoiceListener(nSimulationsChoice,nSimulations));


		JButton set1button=new JButton("Set 1");
		set1button.addActionListener(new ArgumentListener(0,listofargument,this));


		JButton set2button=new JButton("Set 2");
		set2button.addActionListener(new ArgumentListener(1,listofargument,this));

		JButton set3button=new JButton("Set 3");
		set3button.addActionListener(new ArgumentListener(2,listofargument,this));

		JButton set4button=new JButton("Set 4");
		set4button.addActionListener(new ArgumentListener(3,listofargument,this));

		JButton set5button=new JButton("Set 5");
		set5button.addActionListener(new ArgumentListener(4,listofargument,this));

		JButton set6button=new JButton("Set 6");
		set6button.addActionListener(new ArgumentListener(5,listofargument,this));

		JButton set7button=new JButton("Set 7");
		set7button.addActionListener(new ArgumentListener(6,listofargument,this));

		JButton set8button=new JButton("Set 8");
		set8button.addActionListener(new ArgumentListener(7,listofargument,this));

		JButton set9button=new JButton("Set 9");
		set9button.addActionListener(new ArgumentListener(8,listofargument,this));
		// première ligne
		//---------------------------------------------------
		c.gridx=1;
		c.gridy=1;
		c.gridwidth=2;
		background.add(set1button,c);

		c.gridx=3;
		background.add(flagLabel,c);

		c.gridx=5;
		background.add(flagchoice,c);

		c.gridx=7;
		flag.setText("your choice");
		flag.addMouseListener(new DeleteFieldListener(flag));
		background.add(flag,c);

		//deuxième ligne
		//---------------------------------------------------
		c.gridy=2;
		c.gridx=1;
		background.add(set2button,c);

		c.gridx=3;
		background.add(sLabel,c);

		c.gridx=5;
		background.add(currentPriceChoice,c);

		c.gridx=7;
		myS.setText("your choice");
		myS.addMouseListener(new DeleteFieldListener(myS));
		background.add(myS,c);


		//3eme ligne
		//---------------------------------------------------

		c.gridy=3;
		c.gridx=1;
		background.add(set3button,c);

		c.gridx=3;
		background.add(xLabel,c);

		c.gridx=5;
		background.add(strikePriceChoice,c);

		c.gridx=7;
		myX.setText("your choice");
		myX.addMouseListener(new DeleteFieldListener(myX));
		background.add(myX,c);


		//4eme ligne
		//---------------------------------------------------
		c.gridy=4;
		c.gridx=1;
		background.add(set4button,c);

		c.gridx=3;
		background.add(tLabel,c);

		c.gridx=5;
		background.add(timechoice,c);

		c.gridx=7;
		myT.setText("your choice");
		myT.addMouseListener(new DeleteFieldListener(myT));
		background.add(myT,c);

		//---------------------------------------------------
		c.gridy=5;
		c.gridx=1;
		background.add(set5button,c);

		c.gridx=3;
		background.add(rLabel,c);

		c.gridx=5;
		background.add(this.interestPriceChoice,c);

		c.gridx=7;
		myR.setText("your choice");
		myR.addMouseListener(new DeleteFieldListener(myR));
		background.add(myR,c);

		//---------------------------------------------------
		c.gridy=6;
		c.gridx=1;
		background.add(set6button,c);

		c.gridx=3;
		background.add(bLabel,c);

		c.gridx=5;
		background.add(this.fraisChoice,c);

		c.gridx=7;
		myB.setText("your choice");
		myB.addMouseListener(new DeleteFieldListener(myB));
		background.add(myB,c);
		//---------------------------------------------------
		c.gridy=7;
		c.gridx=1;
		background.add(set7button,c);

		c.gridx=3;
		background.add(vLabel,c);

		c.gridx=5;
		background.add(this.volatilityChoice,c);

		c.gridx=7;
		myV.setText("your choice");
		myV.addMouseListener(new DeleteFieldListener(myV));
		background.add(myV,c);
		//---------------------------------------------------
		c.gridy=8;
		c.gridx=1;
		background.add(set8button,c);

		c.gridx=3;
		background.add(nStepsLabel,c);

		c.gridx=5;
		background.add(this.nStepsChoice,c);

		c.gridx=7;
		nSteps.setText("your choice");
		nSteps.addMouseListener(new DeleteFieldListener(nSteps));
		background.add(nSteps,c);

		//---------------------------------------------------
		c.gridy=9;
		c.gridx=1;
		background.add(set9button,c);

		c.gridx=3;
		background.add(nSimulationLabel,c);

		c.gridx=5;
		background.add(this.nSimulationsChoice,c);

		c.gridx=7;
		nSimulations.setText("your choice");
		nSimulations.addMouseListener(new DeleteFieldListener(nSimulations));
		background.add(nSimulations,c);

	}
	/**
	 * return the panel 
	 * @return 
	 */
	public JPanel getBackground() {
		return background;
	}

	public JTextField getFlag() {
		return flag;
	}

	public JTextField getMyS() {
		return myS;
	}

	public JTextField getMyX() {
		return myX;
	}

	public JTextField getMyT() {
		return myT;
	}

	public JTextField getMyR() {
		return myR;
	}

	public JTextField getMyB() {
		return myB;
	}

	public JTextField getMyV() {
		return myV;
	}

	public JTextField getnSteps() {
		return nSteps;
	}

	public JTextField getnSimulations() {
		return nSimulations;
	}
}
