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

     	 ArrayList <ClinicHistory> clinicH = new ArrayList <ClinicHistory>();
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


