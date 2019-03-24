package model;

import java.util.*;

public class Pet{


	  //Constantes

     public final static String DOG = "Dog";
     public final static String CAT = "Cat";
     public final static String BIRD = "Bird";
     public final static String OTHER = "Other";

     //Atributos

     private String name;
     private double weight;
     private String kind;


     //Relaciones

     private ClinicRecord clinicR;
     private Time bornTime;
     private Client owner;


     //Metodo constructor

     public Pet (String name, double weight, String kind, Time bornTime){

     	this.name = name;
     	this.weight = weight;
     	this.kind = kind;
     }



     //Get and set

      public String getName(){
          return name;
     }

     public void setName(String name){
          this.name = name;
     }

     public Client getOwner(){
          return owner;
     }

     public void setOwner(Client owner){
          this.owner = owner;
     }


     public double getWeight(){
          return weight;
     }

     public void setWeight(double weight){
          this.weight = weight;
     }


     public String getKind(){
          return kind;
     }

     public void setKind (String kind){
          this.kind = kind;
     }

     public Time getBornTime(){
          return bornTime;
     }

     public void setBornTime (Time bornTime){
          this.bornTime = bornTime;
     }

      public ClinicRecord getClinicR(){
          return clinicR;
     }

     public void setClinicR (ClinicRecord clinicR){
          this.clinicR = clinicR;
     }
}



