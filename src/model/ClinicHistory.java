package model;

import java.util.*;

public class ClinicHistory{


	 //Constantes
 
     public final static String OPEN = "Open";
     public final static String CLOSED = "Closed";

     //Atributos

	 private double weight;
	 private String type;
	 private String status;
	 private String symptom;
	 private String diagnosis;
	 ArrayList <Medication> prescriptionMedications;

     //Relaciones

     private Time admisionDate;
     private Time offDate;


     //Metodo constructor

     public ClinicHistory (double weight, String type, String status, String symptom, String diagnosis, Time admisionDate, Time offDate){

         this.weight = weight;
         this.type = type;
         this.status = status;
         this. symptom = symptom;
         this.diagnosis = diagnosis;
         ArrayList <Medication> prescriptionMedications = new ArrayList <Medication>();
     }

 
     //Get and set

     public double getWeight(){
          return weight;
     }

     public void setWeight(double weight){
          this.weight = weight;
     }

     public String getType(){
          return type;
     }

     public void setType(String type){
          this.type = type;
     }

     public String getStatus(){
          return status;
     }

     public void setStatus(String status){
          this.status = status;
     }

     public String getSymptom(){
          return symptom;
     }

     public void setSymptom(String symptom){
          this.symptom = symptom;
     }

     public String getDiagnosis(){
          return diagnosis;
     }

     public void setDiagnosis(String diagnosis){
          this.diagnosis = diagnosis;
     }

     public Time getAdmisionDate(){
          return admisionDate;
     }

     public void setAdmisionDate(Time admisionDate){
          this.admisionDate = admisionDate;
     }

     public Time getOffDate(){
          return offDate;
     }

     public void setOffDate(Time offDate){
          this.offDate = offDate;
     }
}

