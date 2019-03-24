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

     	 	 msg = ("\n" + "HISTORIA CLINICA" + "\n" + "La fecha de ingreso es " + clinicH.get(i).getAdmisionDate() + "\n" + "El status es " + clinicH.get(i).getStatus() + "\n" + "Los sintomas de la mascota son " + clinicH.get(i).getSymptom() + "\n" + "El diagnostico de la mascota es " + clinicH.get(i).getDiagnosis() + "\n" + "\n" + clinicH.get(i).showInformationAboutMedicine());

             }

             else {

             	msg = "La mascota no tiene historia clinica";
             }
     	}

     	return msg;
     }


     //Metodo para agregar las historias clinicas

     public void addHistory (ClinicHistory nuevo){
     	clinicH.add(nuevo);
     }

     //Get and set 

     public ArrayList getClinicH(){
          return clinicH;
     }

     public void setClinicH(ArrayList<ClinicHistory> clinicR){
          this.clinicH = clinicH;
     }
}


