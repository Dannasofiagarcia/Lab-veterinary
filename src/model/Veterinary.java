package model;

import java.util.*;

public class Veterinary{


     //Constantes

	public final static int QUANTITY_ROOMS = 8;


     //Atributos

     private String name;


     //Relaciones

     private Client clients;
     private Pet [] miniRoom;
     


     //Metodo constructor

     public Veterinary (String name, Client clients){

         this.name = name;
         miniRoom = new Pet [QUANTITY_ROOMS];
     }

     
     //Metodo para añadir mascota a la habitacion

     public String addPetToTheRoom (Pet petRegister){

         boolean addMascota = false;
         String msj = "";

         for (int i = 0; i < miniRoom.length && !addMascota; i++){

             if (miniRoom[i] != null){

                miniRoom [i] = petRegister;
                msj = ("La mascota se registro con exito y fue agregada a la habitacion numero " + i + "\n");
                addMascota = true;
            }

             else {
                 msj = "La mascota no pudo ser registrada porque no hay habitaciones disponibles";
            }
        }
        
        return msj;  
         
     }

     //Get and set

     public String getName() {
		 return name;
	}

    public void setName (String name) {
	     this.name = name;
	}

    public Client getClients() {
		 return clients;
	}

    public void setClients (Client clients) {
	     this.clients = clients;
	}

	public Pet[] getMiniRoom() {
		 return miniRoom;
	}

    public void setMiniRoom (Pet[] miniRoom) {
	     this.miniRoom = miniRoom;
	}

}
