package model;

import java.util.*;

public class ClinicHistory{


	 //Constantes
 
     public final static String OPEN = "Open";
     public final static String CLOSED = "Closed";

     //Atributos

	 //private double weight

	 private String status;
	 private String symptom;
	 private String diagnosis;
	 ArrayList <Medication> prescriptionMedications;

     //Relaciones

     private Time admisionDate;
     private Time offDate;


     //Metodo constructor

     public ClinicHistory (String status, String symptom, String diagnosis, Time admisionDate, Time offDate){

         this.status = status;
         this. symptom = symptom;
         this.diagnosis = diagnosis;
         this.admisionDate = admisionDate;
         this.offDate = offDate;
         prescriptionMedications = new ArrayList <Medication>();
     }


      //Metodo para mostrar la informacion de las historias clinicas


     public String showInformationHistory (){

         String msg = "";

             msg += ("\n" + "HISTORIA CLINICA" + "\n" + "La fecha de ingreso es " + showAdmisionDate() + "\n" 
                + "El status es " + status + "\n" 
                + "Los sintomas de la mascota son " + symptom + "\n" 
                + "El diagnostico de la mascota es " + diagnosis + "\n" + "\n" 
                + showInformationAboutMedicine() + "\n" + "\n" 
                + "La fecha de salida de la mascota es " + showOffDate());


        return msg;
     }



     //Metodo para agregar los medicamentos

     public void addMedicine (Medication nuevo){
     	prescriptionMedications.add(nuevo);
     }
     

     //Metodo para ver los medicamentos recetados

     public String showInformationAboutMedicine(){

     	String msg = "";

     	 for (int i = 0; i < prescriptionMedications.size(); i++){

     	 	 msg += ("MEDICAMENTO RECETADO" + "\n" + "El nombre del medicamento es " + prescriptionMedications.get(i).getName() + "\n" + "La dosis del medicamento es " + prescriptionMedications.get(i).getDose() + "\n" + "El costo por dosis del medicamento es " + prescriptionMedications.get(i).getDoseCost() + "\n" + "La frecuencia del medicamento es " + prescriptionMedications.get(i).getAdministrationFrecuency() + "\n" + "\n");
     	 }
         return msg;
     }


     //Metodo para convertir la fecha de ingreso solo a dias

     public int admisionDateInOnlyDays (){

         int admisionDays = 0;
         int offDays = 0;
         int totalDays = 0;

         admisionDays = (((admisionDate.getMonth()-1)*30) + admisionDate.getDay());

         offDays = (((offDate.getMonth()-1)*30) + offDate.getDay());

         totalDays = offDays-admisionDays;

         return totalDays;
     }
     

    //Metodo para mostrar la fecha de salida

     public String showOffDate (){

        String msg = "";

        if (offDate == null){

            msg = "La mascota no tiene fecha de salida, aun no se ha dado de alta";
        }

        else if (offDate != null){

            msg = ("El dia en el que la mascota salio fue " + getOffDate().getDay() + "\n" + " del mes " + getOffDate().getMonth() + " en el año " + getOffDate().getYear());
        }

        return msg;
     }


     //Metodo para mostrar la fecha de entrada 

     public String showAdmisionDate (){

        String msg = "";

        if (offDate == null){

            msg = "La mascota no tiene fecha de salida, aun no se ha dado de alta";
        }

        else if (offDate != null){

            msg = ("El dia en el que la mascota salio fue " + getOffDate().getDay() + "\n" + " del mes " + getOffDate().getMonth() + " en el año " + getOffDate().getYear());
        }

        return msg;
     }


     //Metodo para obtener el precio de los medicamentos

     public double medicationCost (){

        double cost = 0;

        for (int i = 0; i< prescriptionMedications.size(); i++){

             cost += prescriptionMedications.get(i).getDoseCost() * prescriptionMedications.get(i).getDose();
        }

        return cost;
     }



     //Get and set

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

     public ArrayList getPrescriptionMedication(){
          return prescriptionMedications;
     }

     public void setPrescriptionMedication(ArrayList<Medication> prescriptionMedications){
          this.prescriptionMedications = prescriptionMedications;
     }
}

