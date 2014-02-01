/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import model.ArgumentSetList;
import view.Window;

/**
 *
 * @author Bakalian
 */
public class MonteCarloV1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArgumentSetList myListofArgument=new ArgumentSetList();
        @SuppressWarnings("unused")
		Window myWindow=new Window(myListofArgument);
    }
}
