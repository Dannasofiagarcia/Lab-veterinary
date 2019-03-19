package model;

import java.util.*;

public class Veterinary{


     //Constantes

	public final static int QUANTITY_ROOMS = 8;


     //Atributos

     private String name;


     //Relaciones

     private ArrayList <Client> clients;
     private Room [] miniRoom;
     private ArrayList <ClinicRecord> ClinicRecordAllVeterinary;
     

     //Metodo constructor

     public Veterinary (String name){

         this.name = name;
         miniRoom = new Room [QUANTITY_ROOMS];
         miniRoom [0] = new Room ("One", true);
         miniRoom [1] = new Room ("Two", true);
         miniRoom [2] = new Room ("Three", true);
         miniRoom [3] = new Room ("Four", true);
         miniRoom [4] = new Room ("Five", true);
         miniRoom [5] = new Room ("Six", true);
         miniRoom [6] = new Room ("Seven", true);
         miniRoom [7] = new Room ("Eight", true);
     }


     //Metodo para verificar si el cliente esta registrado

     public boolean checkIfClientExist (int registerClientId){

        boolean findClient = false;
        String msj = "";

        for (int i = 0; i < clients.size() && !findClient; i++){

             if (clients.get(i).getId() == (registerClientId)){

               findClient = true;
            }
        }
         return findClient;
     }
     
     //Metodo para añadir un cliente

     //public String addClientToVeterinary

     //Get and set

     public String getName() {
		 return name;
	}

    public void setName (String name) {
	     this.name = name;
	}

    public ArrayList getClients(){
          return clients;
     }

     public void setClients(ArrayList<Client> clients){
          this.clients = clients;
     }

	public Room[] getMiniRoom() {
		 return miniRoom;
	}

    public void setMiniRoom (Room[] miniRoom) {
	     this.miniRoom = miniRoom;
	}

}
