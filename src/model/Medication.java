package model;

import java.util.*;

public class Medication{

     //Atributos

	private String name;
	private double dose;
	private double doseCost;
	private String administrationFrecuency;

     //Metodo constructor

     public Medication (String name, double dose, double doseCost, String administrationFrecuency){

     	this.name = name;
     	this.dose = dose;
     	this.doseCost = doseCost;
     	this.administrationFrecuency = administrationFrecuency;
     }
 
     //Get and set

    public String getName() {
		return name;
	}

    public void setName (String name){
	    this.name = name;
	}

    public double getDose() {
		return dose;
	}

    public void setDose (double dose){
	    this.dose = dose;
	}
	
	public double getDoseCost() {
		return doseCost;
	}

    public void setDoseCost (double doseCost){
	    this.doseCost = doseCost;
	}

	public String getAdministrationFrecuency() {
		return administrationFrecuency;
	}

    public void setAdministrationFrecuency (String administrationFrecuency){
	    this.administrationFrecuency = administrationFrecuency;
	}
	

}







