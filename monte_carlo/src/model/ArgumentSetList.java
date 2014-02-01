/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Cette classe va lire dans le fichier CSV tous le set enregistré,
 *puis les enregistrer dans une liste d'arguments
 * @author Bakalian
 */
public class ArgumentSetList {

	private List<ArgumentSet> listofArgumentSet;

	public  ArgumentSetList(){
		FileReader fr=null;
		BufferedReader bf=null;
		try {
			listofArgumentSet=new ArrayList<>();
			fr = new FileReader("arguments.csv");
			bf = new BufferedReader(fr);
			String Line;
			while((Line=bf.readLine())!=null){

				String [] tmp=Line.split(";");
				ArgumentSet agr=new ArgumentSet(tmp[0],tmp[1],Double.parseDouble(tmp[2]),Double.parseDouble(tmp[3]),
						Double.parseDouble(tmp[4]),Double.parseDouble(tmp[5]),Double.parseDouble(tmp[6]),Double.parseDouble(tmp[7]),
						Integer.parseInt(tmp[8]),Integer.parseInt(tmp[9]));
				listofArgumentSet.add(agr);

			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(ArgumentSetList.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(ArgumentSetList.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				bf.close();
				fr.close();
			} catch (IOException ex) {
				Logger.getLogger(ArgumentSetList.class.getName()).log(Level.SEVERE, null, ex);
			}
		}


	}


	public void addArgumentSet(ArgumentSet ags){

		listofArgumentSet.add(ags);
	}

	public List<ArgumentSet> getListofArgumentSet() {
		return listofArgumentSet;
	}

	public void setListofArgumentSet(List<ArgumentSet> listofArgumentSet) {
		this.listofArgumentSet = listofArgumentSet;
	}



}
