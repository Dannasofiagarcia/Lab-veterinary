package model;

import java.util.*;

public class ClinicRecord{

     //Relaciones

    private ArrayList <ClinicHistory> clinicH;

     //Metodo constructor

     public ClinicRecord (){

     	 clinicH = new ArrayList <ClinicHistory>();
     }


     /**
    * This method show clinic history information <br>

    * <b>pre:</b> clinicH is initilized, clinicH != null <br>

    * <b>post:</b> Clinic history information is displayed <br>

    * @return String The method return a message with the information of clinic history, if the pet doesn't have a clinic history return a different message <br>
    */

     public String showInformationClinicHistory (){

     	 String msg = "";

     	 for (int i = 0; i < clinicH.size(); i++){

     	 	 if (clinicH != null){

     	 	 msg += ("\n" + "HISTORIA CLINICA" + "\n" + "La fecha de ingreso es " + clinicH.get(i).getAdmisionDate() + "\n" 
     	 	 	+ "El status es " + clinicH.get(i).getStatus() + "\n" 
     	 	 	+ "Los sintomas de la mascota son " + clinicH.get(i).getSymptom() + "\n" 
                + "Las notas de la historia clinica son " + clinicH.get(i).getNotes() + "\n"
     	 	 	+ "El diagnostico de la mascota es " + clinicH.get(i).getDiagnosis() + "\n" + "\n" 
     	 	 	+ clinicH.get(i).showInformationAboutMedicine() + "\n" + "\n" 
     	 	 	+ "La fecha de salida de la mascota es " + clinicH.get(i).showOffDate());

             }

             else {

             	msg = "La mascota no tiene historia clinica";
             }
     	}

     	return msg;
     }


    /**
    * This method calculate the days a pet was hospitalized <br>

    * <b>pre:</b> clinicH is initilized, clinicH != null <br>

    * <b>post:</b> Hospitalization days is calculate <br>

    * @return int The method return the days a pet was hospitalized <br>
    */

     public int hospitalizationDays (){

     	int days = 0;

     	for (int i = 0; i < clinicH.size(); i++){

     		 	 days = clinicH.get(i).admisionDateInOnlyDays();
     	}

     	return days;
     }


    /**
    * This method assigned the status CLOSED to the clinic history of discharged pet <br>

    * <b>pre:</b> clinicH is initilized, clinicH != null <br>

    * <b>post:</b> Clinic history status was changed <br>

    * @return ClinicHistory The method return the clinic history that was changed <br>
    */

     public ClinicHistory showClinicHistory (){

     	ClinicHistory historyC = null;

     	for (int i = 0; i < clinicH.size(); i++){

     		if (clinicH.get(i).getStatus().equals("OPEN")){
               
              historyC = clinicH.get(i);

     	    }
     	 }

     	return historyC;

    }



    /**
    * This method count how many clinic histories <br>

    * <b>pre:</b> clinicH is initilized, clinicH != null <br>

    * <b>post:</b> Quantity of clinic histories was displayed <br>

    * @return int The method return quantity of clinic histories <br>
    */

    public int howManyClinicH (){

    	 String msg = "";

    	 int contador = 0;

    	 for (int i = 0; i < clinicH.size(); i++){

    	 	 contador++;
    	}
    	 return contador;
    }


    /**
    * This method add a new clinic history <br>

    * <b>pre:</b> clinicH is initilized, clinicH != null <br>

    * <b>post:</b> Clinic history was added <br>

    * @param nuevo Is the clinic history to add, nuevo != null <br>
    */

     public void addHistory (ClinicHistory nuevo){
     	clinicH.add(nuevo);
     }


      /**
    * This method select CLOSED clinic histories <br>

    * <b>pre:</b> clinicH is initilized, clinicH != null <br>

    * <b>post:</b> Clinic histories is displayed <br>

    * @return ClinicHistory The method return the clinic history CLOSED <br>
    */

     public ClinicHistory incomePublicOpenClinicH(){

        int income = 0;
        ClinicHistory clinicHC = null;
        boolean found = false;

        for (int i = 0; i < clinicH.size() && !found; i++){

            if (clinicH.get(i).getStatus().equals(ClinicHistory.CLOSED)){

                clinicHC = clinicH.get(i);
                found = true;
                
            }
        }

        return clinicHC;
     }

     //Get and set 

     public ArrayList getClinicH(){
          return clinicH;
     }

     public void setClinicH(ArrayList<ClinicHistory> clinicR){
          this.clinicH = clinicH;
     }


 } //Cierra la clase


