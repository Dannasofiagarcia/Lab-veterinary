package model;

import java.util.*;

public class ClinicRecord{

     //Atributos

     private String clientName;
     private int idOwner;
     private String petName;
     private ArrayList <ClinicHistory> clinicR;


     //Relaciones


     //Metodo constructor

     public ClinicRecord (String clientName, int idOwner, String petName){

     	this.clientName = clientName;
     	this.idOwner = idOwner;
     	this.petName = petName;
     	ArrayList <ClinicHistory> clinicR = new ArrayList <ClinicHistory>();
     }


     //Get and set

     public String getClientName(){
          return clientName;
     }

     public void setClientName(String clientName){
          this.clientName = clientName;
     }

     public int getIdOwner(){
          return idOwner;
     }

     public void setIdOwner(int idOwner){
          this.idOwner = idOwner;
     }

     public String getPetName(){
          return petName;
     }

     public void setPetName(String petName){
          this.petName = petName;
     }

     public ArrayList getClinicR(){
          return clinicR;
     }

     public void setClinicR(ArrayList<ClinicHistory> clinicR){
          this.clinicR = clinicR;
     }
}


