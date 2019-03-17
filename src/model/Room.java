package model;

import java.util.*;

public class Room{

     //Atributos

     private boolean mascota;

     //Relaciones

     private Pet petClient;


     //Metodo constructor
   
     public Room (boolean mascota, Pet petClient){

         this.mascota = mascota;
         this.petClient = petClient;
    }
 
     //Get and set

     public boolean getMascota(){
     	return mascota;
     }

     public void setMascota (boolean mascota){
         this.mascota = mascota;
     }

     public Pet getPetClient(){
     	return petClient;
     }

     public void setPetClient (Pet petClient){
         this.petClient = petClient;
     }
}



