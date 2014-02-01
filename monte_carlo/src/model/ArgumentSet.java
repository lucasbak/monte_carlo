/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *Cette classe représente un set d'argument
 * @author Bakalian
 */
public class ArgumentSet {
    private String name;
    private String Flag;
    private double S;
    private double X;
    private double T;
    private double r;
    private double b;
    private double v;
    private int nSteps;
    private int nSimulations;
/**
 * 
 * @param name nom du Set
 * @param Flag le flag du set
 * @param S Le prix actuel du sous-jacent;
 * @param X Le prix d'exercice (strike price) de l'option;
 * @param T Le temps restant jusqu'à échéance (maturity) de l'option (en nombre d'années) ;
 * @param r  Le taux d'intérêt sans risque;
 * @param b Le taux des frais de détention de l'option (intérêts, rendements de l'action pendant l'encours, etc.);
 * @param v La volatilité du prix du sous-jacent (la déviation standard de son prix observé par le passé);
 * @param nSteps Le nombre de points intermédiaires à calculer sur le chemin du prix du sous-jacent. Le plus grand le nombre de ces points, le plus précis la simulation;
 * @param nSimulations Le nombre de simulations à exécuter (le nombre de chemins à explorer).
 */
    public ArgumentSet(String name, String Flag, double S, double X, double T, double r, double b, double v, int nSteps, int nSimulations) {
        this.name = name;
        this.Flag = Flag;
        this.S = S;
        this.X = X;
        this.T = T;
        this.r = r;
        this.b = b;
        this.v = v;
        this.nSteps = nSteps;
        this.nSimulations = nSimulations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String Flag) {
        this.Flag = Flag;
    }

    public double getS() {
        return S;
    }

    public void setS(double S) {
        this.S = S;
    }

    public double getX() {
        return X;
    }

    public void setX(double X) {
        this.X = X;
    }

    public double getT() {
        return T;
    }

    public void setT(double T) {
        this.T = T;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }

    public int getnSteps() {
        return nSteps;
    }

    public void setnSteps(int nSteps) {
        this.nSteps = nSteps;
    }

    public int getnSimulations() {
        return nSimulations;
    }

    public void setnSimulations(int nSimulations) {
        this.nSimulations = nSimulations;
    }
    
}
