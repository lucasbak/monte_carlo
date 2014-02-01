/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Bakalian
 */
public class ChoiceListener implements ActionListener {

    private final JComboBox<String> boxtoListen;
    private JTextField      fieldtoChange;

    public ChoiceListener(JComboBox<String> boxtoListener,JTextField jf) {
        this.boxtoListen = boxtoListener;
        this.fieldtoChange=jf;
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(boxtoListen.getSelectedItem().toString().equals("Call")){
            
            fieldtoChange.setText("c");
            
        }
        else if(boxtoListen.getSelectedItem().toString().equals("Retrieve")){
            fieldtoChange.setText("p");
            
        }
        else {
            fieldtoChange.setText(boxtoListen.getSelectedItem().toString());
        }
    }
    
}
