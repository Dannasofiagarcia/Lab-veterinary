package model;

import java.util.*;

public class ClinicRecord{

     //Atributos

     //private String clientName;
     //private int idOwner;
     //private String petName;
     private ArrayList <ClinicHistory> clinicH;


     //Relaciones


     //Metodo constructor

     public ClinicRecord (){

     	 clinicH = new ArrayList <ClinicHistory>();
     }

     //Metodo para mostrar la informacion de las historias clinicas


     public String showInformationClinicHistory (){

     	 String msg = "";

     	 for (int i = 0; i < clinicH.size(); i++){

     	 	 if (clinicH != null){

     	 	 msg += ("\n" + "HISTORIA CLINICA" + "\n" + "La fecha de ingreso es " + clinicH.get(i).getAdmisionDate() + "\n" 
     	 	 	+ "El status es " + clinicH.get(i).getStatus() + "\n" 
     	 	 	+ "Los sintomas de la mascota son " + clinicH.get(i).getSymptom() + "\n" 
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

      //Metodo para calcular los dias de hospitalizacion de una mascota
    
     public int hospitalizationDays (){

     	int days = 0;

     	for (int i = 0; i < clinicH.size(); i++){

     		 	 days = clinicH.get(i).admisionDateInOnlyDays();
     	}

     	return days;
     }

     //Metodo para asignar

     public ClinicHistory showClinicHistory (){

     	ClinicHistory historyC = null;

     	for (int i = 0; i < clinicH.size(); i++){

     		if (clinicH.get(i).getStatus().equals("OPEN")){
               
              historyC = clinicH.get(i);

     	    }
     	 }

     	return historyC;

    }

    //Metodo para ver todas las historias clinicas de una mascota

    public int howManyClinicH (){

    	 String msg = "";

    	 int contador = 0;

    	 for (int i = 0; i < clinicH.size(); i++){

    	 	 contador++;
    	}
    	 return contador;
    }


     //Metodo para agregar las historias clinicas

     public void addHistory (ClinicHistory nuevo){
     	clinicH.add(nuevo);
     }

     //Metodo para añadir las notas a la historia clinica

     //public void addNotesCH (String notesClinicHistory){

        // clinicH.addNotes(notesClinicHistory);
     //}

     //Get and set 

     public ArrayList getClinicH(){
          return clinicH;
     }

     public void setClinicH(ArrayList<ClinicHistory> clinicR){
          this.clinicH = clinicH;
     }


 } //Cierra la clase


