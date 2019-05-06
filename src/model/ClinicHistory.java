package model;

import java.util.*;

public class ClinicHistory{


	 //Constantes
 
     public final static String OPEN = "abierto";
     public final static String CLOSED = "cerrado";

     //Atributos

	 //private double weight

	 private String status;
	 private String symptom;
	 private String diagnosis;
     private String notes;
	 ArrayList <Medication> prescriptionMedications;

     //Relaciones

     private Time admisionDate;
     private Time offDate;


     //Metodo constructor

     public ClinicHistory (String status, String symptom, String diagnosis, Time admisionDate, Time offDate, String notes){

         this.status = status;
         this. symptom = symptom;
         this.diagnosis = diagnosis;
         this.admisionDate = admisionDate;
         this.offDate = offDate;
         this.notes = notes;
         prescriptionMedications = new ArrayList <Medication>();
     }



    /**
    * This method shows clinic history information <br>

    * <b>post:</b> Clinic history information is displayed <br>

    * @return String The method return a message with the information of clinic history <br>
    */
      
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



    
    /**
    * This method shows prescription medication <br>

    * <b>post:</b> Clinic history information is displayed <br>

    * @param nuevo Is the medicine to add, nuevo != null <br>
    */

     public void addMedicine (Medication nuevo){
     	prescriptionMedications.add(nuevo);
     }
     

     /**
    * This method shows clinic history information <br>

    * <b>pre:</b> prescriptionMedications is initilized, prescriptionMedications != null <br>

    * <b>post:</b> Prescription medication information is displayed <br>

    * @return String The method return a message with the information of medication <br>
    */

     public String showInformationAboutMedicine(){

     	String msg = "";

     	 for (int i = 0; i < prescriptionMedications.size(); i++){

     	 	 msg += ("MEDICAMENTO RECETADO" + "\n" + "El nombre del medicamento es " + prescriptionMedications.get(i).getName() + "\n" + "La dosis del medicamento es " + prescriptionMedications.get(i).getDose() + "\n" + "El costo por dosis del medicamento es " + prescriptionMedications.get(i).getDoseCost() + "\n" + "La frecuencia del medicamento es " + prescriptionMedications.get(i).getAdministrationFrecuency() + "\n" + "\n");
     	 }
         return msg;
     }



    /**
    * This method convert a date in only days <br>

    * <b>pre:</b> admisionDate != null <br>

    * <b>post:</b> admision date was converted to onlyd ays <br>

    * @return int The method return the conversion of days <br>
    */

     public int admisionDateInOnlyDays (){

         int admisionDays = 0;
         int offDays = 0;
         int totalDays = 0;

         admisionDays = (((admisionDate.getMonth()-1)*30) + admisionDate.getDay());

         offDays = (((offDate.getMonth()-1)*30) + offDate.getDay());

         totalDays = offDays-admisionDays;

         return totalDays;
     }
     


    /**
    * This method shows off date information <br>

    * <b>pre:</b> offDate != null <br>

    * <b>post:</b> Off date information was displayed <br>

    * @return String The method return a message with off date information <br>
    */

     public String showOffDate (){

        String msg = "";

        if (offDate == null){

            msg = "sin fecha de salida, la mascota aun no se le ha dado de alta";
        }

        else if (offDate != null){

            msg = ("el dia en el que la mascota salio fue " + getOffDate().getDay() + "\n" + " del mes " + getOffDate().getMonth() + " en el año " + getOffDate().getYear());
        }

        return msg;
     }


    /**
    * This method shows admision date <br>

    * <b>pre:</b> admisionDate != null <br>

    * <b>post:</b> Admision date information was displayed <br>

    * @return String The method return a message with admision date information <br>
    */


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


      /**
    * This method calculate medication cost <br>

    * <b>pre:</b> prescriptionMedications is initilized, prescriptionMedications != null <br>

    * <b>post:</b> Prescription medication cost is displayed <br>

    * @return double The method return a message with the cost of medication <br>
    */

     public double medicationCost (){

        double cost = 0;

        for (int i = 0; i< prescriptionMedications.size(); i++){

             cost += prescriptionMedications.get(i).getDoseCost() * prescriptionMedications.get(i).getDose();
        }

        return cost;
     }


    /**
    * This method add notes <br>

    * <b>post:</b> Notes were added <br>

    * @param nuevo Is the notes to add. nuevo != null, nuevo != " " <br>
    */

     public void addNotes (String nuevo){
         notes = nuevo;
     }


     /**
    * This method add symptom <br>

    * <b>post:</b> Symptom were added <br>

    * @param nuevo Is the symptom to add. nuevo != null, nuevo != " " <br>
    */

     public void addSymptoms (String nuevo){

        symptom += ("Sintoma nuevo: " + nuevo);
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

     public String getNotes(){
          return notes;
     }

     public void setNotes(String notes){
          this.notes = notes;
     }

     public ArrayList getPrescriptionMedication(){
          return prescriptionMedications;
     }

     public void setPrescriptionMedication(ArrayList<Medication> prescriptionMedications){
          this.prescriptionMedications = prescriptionMedications;
     }
}

