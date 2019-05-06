package model;

import java.util.*;

public class Room{

     //Atributos

     private boolean avaiable;
     private String numberOfTheRoom;

     //Relaciones

     private Pet petClient;
     private ClinicHistory clinicHistoryOfThePet;


     //Metodo constructor
   
     public Room (String numberOfTheRoom, boolean avaiable){

         this.numberOfTheRoom = numberOfTheRoom;
         this.avaiable = avaiable;
         this.petClient = petClient;
         this.clinicHistoryOfThePet = clinicHistoryOfThePet;
    }


    /**
    * This method calculate hospitalization cost <br>

    * <b>post:</b> Cost hospitalization was calculated <br>

    * @return double The method returns the cost of hospitalization<br>
    */

      public double costHospitalizationRoom (){

          double cost = 0;

            cost = petClient.costHospitalization();

           return cost;
     }
 
     //Get and set

     public boolean getAvaiable(){
     	return avaiable;
     }

     public void setAvaiable (boolean avaiable){
         this.avaiable = avaiable;
     }

     public ClinicHistory getClinicHistoryOfThePet (){
         return clinicHistoryOfThePet;
     }

     public void setClinicHistoryOfThePet (ClinicHistory clinicHistoryOfThePet){
         this.clinicHistoryOfThePet = clinicHistoryOfThePet;
     }

     public Pet getPetClient(){
     	return petClient;
     }

     public void setPetClient (Pet petClient){
         this.petClient = petClient;
     }

     public String getNumberOfTheRoom(){
        return numberOfTheRoom;
     }

     public void setNumberOfTheRoom (String numberOfTheRoom){
         this.numberOfTheRoom = numberOfTheRoom;
     }
}



