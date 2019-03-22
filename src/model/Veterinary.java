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
     private ArrayList <ClinicRecord> clinicRecordAllVeterinary;
     

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
         ArrayList <ClinicRecord> clinicRecordAllVeterinary = new ArrayList <ClinicRecord>();
     }


     //Metodo para verificar si el cliente esta registrado

     public boolean checkIfClientExist (int registerClientId){

        boolean findClient = false;
        String msj = "";

        for (int i = 0; i < clients.size() && !findClient; i++){

             if (clients.get(i) != null){

                 if (clients.get(i).getId() == (registerClientId)){
 
                  findClient = true;
                 }
             }
         }   
         return findClient;
     }
     
     //Metodo para agregar los clientes a la veterinaria

     public void addClient (Client nuevo){
         if (nuevo != null){
         clients.add(nuevo);
         }
     }  
    

     //Metodo para hospitalizar una mascota

     public String hospitalization (int registerClientId, String registerPetName){

         String msg = "";
         Pet p = null;

         for (int i = 0; i < clients.size() && p == null; i++){

             if (clients.get(i).getId() == (registerClientId)){
                     p = clients.get(i).findPet(registerPetName);

                 if (p == null){
                     msg = "El cliente no tiene una mascota con ese nombre";
                 }
             }
         }
         if (p!=null){
             msg = addPetToAvaiableRoom(p);
         }
         return msg;
    }


     //Metodo para ver si una habitacion esta disponible

         public String addPetToAvaiableRoom(Pet current){

             boolean found = false;
             String msg = "";

             for (int i = 0; i < miniRoom.length && !found; i++){
                 if (miniRoom[i].getAvaiable() == true){

                    miniRoom[i].setPetClient(current);
                    found = true;
                    miniRoom[i].setAvaiable(false);
                    msg = ("Se ha agregado " + current.getName() + " a la habitacion " + miniRoom[i].getNumberOfTheRoom() + "correctamente");
                 }

                 else {
                    msg = "No hay habitaciones disponibles, no se ha podido agregar a la mascota a la habitacion";
                 }
             }

             return msg;
         }


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
