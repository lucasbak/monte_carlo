/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.StartListener;
import model.ArgumentSetList;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *cette classe represente la fenêtre
 * on y créer chaque élement la composant ( set d'argument et boutton)
 * @author Bakalian
 */
public class Window  extends JFrame{
    
    private final ArgumentSetList argumentSetList;
    private final JPanel mainBackground;
    private final JLabel jlabelWelcome;
    private JTextField name;
    private JTextField flag;
    private JTextField myS;
    private JTextField myX;
    private JTextField myT;
    private JTextField myR;
    private JTextField myB;
    private JTextField myV;
    private JTextField nSteps;
    private JTextField nSimulations;
    private final JPanel textFieldBackground;
    private final JButton LaunchButton;
    private final JLabel Result;
    private JComboBox threadingChoice;
    private ArgumentSetViewer ArgumentViewer;
    
    
    
    public Window (ArgumentSetList asl){
        this.setTitle("MonteCarlo Calculator");
        
        argumentSetList=asl;
        jlabelWelcome=new JLabel("please select a set of Argument or enter yours  Choose the Version :\n\n");// message de bienvenue
        String[] labels={"Single Threaded Version","Multi Thread Version"};
        threadingChoice=new JComboBox(labels);
        mainBackground=new JPanel();// le panel principal avec un gridbaglayout pour une disposition précise
        textFieldBackground=new JPanel();// un JPanel qui contiendra tous les Jtextfields
        LaunchButton=new JButton("Launch");// le boutton pour démarrer
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
        
        
        
        
        /*c.gridwidth=GridBagConstraints.CENTER;
        c.gridx=0;
        for(int i=0;i<argumentSetList.getListofArgumentSet().size();i++){
        
        c.gridy=i+1;
        mainBackground.add(new ArgumentSetView(argumentSetList.getListofArgumentSet().get(i),this).getSetInLabel(),c);
        
        
        }
        
        c.gridy=6;
        c.gridx=0;
        mainBackground.add(textFieldBackground,c);
        
        
        
        
        name=new JTextField();
        name.setSize(70, 10);
        
        name.setMinimumSize(new Dimension(70,10));
        name.setName("name");
        name.setText("name");
        name.setSize(name.getPreferredSize());
        name.addMouseListener(new DeleteFieldListener(name));
        textFieldBackground.add(name, c);
        
        
        
        
        flag=new JTextField();
        flag.setName("flag");
        flag.setText("flag");
        flag.setSize(flag.getPreferredSize());
        flag.addMouseListener(new DeleteFieldListener(flag));
        //flag.setMinimumSize(new Dimension(10,10));
        textFieldBackground.add(flag);
        
        
        myS=new JTextField();
        myS.setName("myS");
        myS.setText("CurrentPrice");
        myS.addMouseListener(new DeleteFieldListener(myS));
        
        textFieldBackground.add(myS);
        
        
        myX=new JTextField();
        myX.setName("myX");
        myX.setText("strike price");
        myX.addMouseListener(new DeleteFieldListener(myX));
        textFieldBackground.add(myX);
        
        
        myT=new JTextField();
        myT.setName("myT");
        myT.setText("maturity");
        myT.addMouseListener(new DeleteFieldListener(myT));
        
        textFieldBackground.add(myT);
        
        
        myR=new JTextField();
        myR.setName("myR");
        myR.setText("interest rate");
        myR.addMouseListener(new DeleteFieldListener(myR));
        
        textFieldBackground.add(myR);
        
        
        myB=new JTextField();
        myB.setName("myB");
        myB.setText("global rates");
        myB.addMouseListener(new DeleteFieldListener(myB));
        
        textFieldBackground.add(myB);
        
        
        myV=new JTextField();
        myV.setName("myV");
        myV.setText("Volatility");
        myV.addMouseListener(new DeleteFieldListener(myV));
        textFieldBackground.add(myV);
        
        
        nSteps=new JTextField();
        nSteps.setName("nsteps");
        nSteps.setText("nSteps");
        nSteps.addMouseListener(new DeleteFieldListener(nSteps));
        textFieldBackground.add(nSteps);
        
        
        nSimulations=new JTextField();
        nSimulations.setName("nSimulations");
        nSimulations.setText("nSimulations");
        nSimulations.addMouseListener(new DeleteFieldListener(nSimulations));
        textFieldBackground.add(nSimulations);*/
       
        
        c.gridy=3;
        LaunchButton.addActionListener(new StartListener(ArgumentViewer,this));
        mainBackground.add(LaunchButton,c); 
        
        c.gridy=4;
        mainBackground.add(this.Result,c);
        
        
        
        this.setContentPane(mainBackground);
        this.setSize(1000, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
        
        
        
        
        
        
        
        
        
    }

    public JComboBox getThreadingChoice() {
        return threadingChoice;
    }

   
    public JLabel getResult() {
        return Result;
    }
    
}
