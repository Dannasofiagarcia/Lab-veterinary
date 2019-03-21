package model;

import java.util.*;

public class Room{

     //Atributos

     private boolean avaiable;
     private String numberOfTheRoom;

     //Relaciones

     private Pet petClient;


     //Metodo constructor
   
     public Room (String numberOfTheRoom, boolean avaiable){

         this.numberOfTheRoom = numberOfTheRoom;
         this.avaiable = avaiable;
         this.petClient = petClient;
    }

 
     //Get and set

     public boolean getAvaiable(){
     	return avaiable;
     }

     public void setAvaiable (boolean avaiable){
         this.avaiable = avaiable;
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



