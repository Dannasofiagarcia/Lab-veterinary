package model;

import java.util.*;

public class Veterinary{


     //Constantes

	public final static int QUANTITY_ROOMS = 8;


     //Atributos

     private String name;


     //Relaciones

     private Client clients;
     private Room [] miniRoom;
     


     //Metodo constructor

     public Veterinary (String name, Client clients){

         this.name = name;
         miniRoom = new Room [QUANTITY_ROOMS];
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

	public Room[] getMiniRoom() {
		 return miniRoom;
	}

    public void setMiniRoom (Room[] miniRoom) {
	     this.miniRoom = miniRoom;
	}

}
