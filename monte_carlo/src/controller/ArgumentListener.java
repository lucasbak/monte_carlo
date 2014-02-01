/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.ArgumentSetList;
import view.ArgumentSetViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener pour charger un argument dans les champs d'entrée
 * @author Bakalian
 */
public class ArgumentListener implements ActionListener {
    
private final ArgumentSetList listofArgument;
private final ArgumentSetViewer myRootViewer;
private int set;

    public ArgumentListener(int i,ArgumentSetList listofArgument, ArgumentSetViewer myRootViewer) {
        this.set=i;
        this.listofArgument = listofArgument;
        this.myRootViewer = myRootViewer;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
      
                myRootViewer.getFlag().setText(String.valueOf(listofArgument.getListofArgumentSet().get(set).getFlag()));
                myRootViewer.getMyS().setText(String.valueOf(listofArgument.getListofArgumentSet().get(set).getS()));
                myRootViewer.getMyX().setText(String.valueOf(listofArgument.getListofArgumentSet().get(set).getX()));
                myRootViewer.getMyT().setText(String.valueOf(listofArgument.getListofArgumentSet().get(set).getT()));
                myRootViewer.getMyR().setText(String.valueOf(listofArgument.getListofArgumentSet().get(set).getR()));
                myRootViewer.getMyB().setText(String.valueOf(listofArgument.getListofArgumentSet().get(set).getB()));
                myRootViewer.getMyV().setText(String.valueOf(listofArgument.getListofArgumentSet().get(set).getV()));
                myRootViewer.getnSteps().setText(String.valueOf(listofArgument.getListofArgumentSet().get(set).getnSteps()));
                myRootViewer.getnSimulations().setText(String.valueOf(listofArgument.getListofArgumentSet().get(set).getnSimulations()));
            
        }
        
    }
    
    

    

