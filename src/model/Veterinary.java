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
         miniRoom [0] = new Room ("uno", true);
         miniRoom [1] = new Room ("dos", true);
         miniRoom [2] = new Room ("tres", true);
         miniRoom [3] = new Room ("cuatro", true);
         miniRoom [4] = new Room ("cinco", true);
         miniRoom [5] = new Room ("seis", true);
         miniRoom [6] = new Room ("siete", true);
         miniRoom [7] = new Room ("ocho", true);
         clinicRecordAllVeterinary = new ArrayList <ClinicRecord>();
         clients = new ArrayList <Client>();
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

     //Metodo para hospitalizar una mascota ya registrada

     public String hospitalizationRegisterPet (String petForHospitalization, int registerClientId){

         String msg = "";
         Pet p = null;

         for (int i = 0; i < clients.size() && p == null; i++){

             if (clients.get(i).getId() == (registerClientId)){
                     p = clients.get(i).showWhatUserSelectedForHospitalization(petForHospitalization);

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
                    miniRoom[i].setClinicHistoryOfThePet(current.getClinicR().showClinicHistory());
                    msg = ("Se ha agregado " + current.getName() + " a la habitacion " + miniRoom[i].getNumberOfTheRoom() + " correctamente");
                 }

                 else {
                    msg = "No hay habitaciones disponibles, no se ha podido agregar a la mascota a la habitacion";
                 }
             }

             return msg;
         }



     //Metodo para buscar el dueño de una mascota registrada

     public Client findTheOwnerOfThePet (int registerClientId1){

        boolean findOwner = false;
        Client ownerOfThePet = null;

        for (int i = 0; i < clients.size() && !findOwner; i++){

             if (clients.get(i).getId() == registerClientId1){

                 ownerOfThePet = clients.get(i);
                 findOwner = true;
            }
             
         }
         return ownerOfThePet;
    }


     //Metodo para ver los clientes registrados en la veterinaria

    public String showInformationOfTheClients(){

        String msg = "";

        for (int i = 0; i<clients.size(); i++){

            msg += ("El nombre del cliente es " + clients.get(i).getName() + "\n" + "El id del cliente es " + clients.get(i).getId() + "\n" + "La direccion del cliente es " + clients.get(i).getDirection() + "\n" + "El numero de telefono del cliente es " + clients.get(i).getPhoneNumber() + "\n" + "El cliente tiene la(s) siguiente(s) mascota(s) " + clients.get(i).showInformationPets() + "\n" + "\n");
        }
        return msg;

    }

    //Metodo para mostrar los clientes registrados disponibles en la veterinaria 

    public String showClientsAvaiable(){

        String msg = "";

        for (int i = 0; i<clients.size(); i++){

            msg += ("El nombre del cliente es " + clients.get(i).getName() + "\n" + "El id del cliente es " + clients.get(i).getId() + "\n" + "\n");
        }
        return msg;

    }


     //Metodo para buscar las mascotas de todos los clientes

     public String showPetsThatAreAvaiable (){

         String msg = "";
         int indice = 1;
         for (int i = 0; i < clients.size(); i++){

         msg += (clients.get(i).showPetsAvaiable() + "\n");
         }

         return msg;

    }


    //Metodo para mostrar las mascotas de un cliente especifico

    public String showPetsOfClient (int registerClientId){

        Client clientLookingFor = null;
        boolean found = false;
        String msg = "";

        for (int i = 0; i <clients.size() && !found; i++){

              if (clients.get(i).getId() == registerClientId){

                  clientLookingFor = clients.get(i);
                  found = true;
                  msg = (clientLookingFor.showInformationPets());
              }

        }

        return msg;

    }




     //Metodo para buscar la mascota que el usuario desea ver entre las mascotas de todos los clientes

     public String showInformationOfTheClinicR (String selectionPetsAvaiable){

         boolean found = false;
         String msg = "";

         for (int i = 0; i < clients.size(); i++){

                msg += (clients.get(i).showWhatUserSelected(selectionPetsAvaiable) + "\n");
        }

    return msg;

            
    }    


     //Metodo para saber que mascota se eligio para hospitalizar

     public Pet showInformationWhatUserSelectedHospitalization (String petForHospitalization, int registerClientId){

        Pet pet = null;

        for (int i = 0; i < clients.size(); i++){

              if (clients.get(i).getId() == registerClientId){

                  pet = clients.get(i).showWhatUserSelectedForHospitalization(petForHospitalization);
              }
         }

         return pet;
     }
    
    //Metodo para mostrar la informacion de las habitaciones


     public String showRoomsInformation (){

         String msg = "";

        for (int i = 0; i < miniRoom.length; i++){

            if (miniRoom[i].getAvaiable() == false){

                 msg += ("La habitacion numero " + miniRoom[i].getNumberOfTheRoom() + " esta ocupada y se encuentra la mascota " + miniRoom[i].getPetClient().getName() + "\n" + "\n");
             }

             else {

                 msg += ("La habitacion numero " + miniRoom[i].getNumberOfTheRoom() + " esta disponible, no se encuentra ninguna mascota" + "\n" + "\n");
             }
             
         }

         return msg;

    }


    //Ingresos por hospitalizacion de toda la veterinaria

    public double incomeHospitalizations (){

        int cost = 0;

        for (int i = 0; i < clients.size(); i++){

             cost += clients.get(i).costHospitalizationOfThePet();
        }

        return cost;
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
