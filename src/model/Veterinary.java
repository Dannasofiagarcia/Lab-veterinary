package model;

import java.util.*;

public class Veterinary{


     //Constantes

	public final static int QUANTITY_ROOMS = 8;


     //Atributos

     private String name;
     private double incomeHospitalizations;


     //Relaciones

     private ArrayList <Client> clients;
     private Room [] miniRoom;
     

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


     //Metodo para mostrar la informacion de las habitaciones


     public String showInformationPetsHospitalization (){

         String msg = "";

        for (int i = 0; i < miniRoom.length; i++){

            if (miniRoom[i].getAvaiable() == false){

                 msg += ("La habitacion numero " + miniRoom[i].getNumberOfTheRoom() + " se encuentra " + miniRoom[i].getPetClient().getName() + "\n" + "\n");
             }
        }

         return msg;

    }

    

     //Metodo para ver cuantas historias clinicas tiene una mascota

     public String showHowManyClinicH (int registerClientId, String petForHospitalization){

        boolean findClient = false;
        String msj = "";
        Pet pet = null;

        for (int i = 0; i < clients.size() && !findClient; i++){

             if (clients.get(i) != null){

                 if (clients.get(i).getId() == (registerClientId)){
 
                  findClient = true; 
                  msj = clients.get(i).howManyClinicHThePetHave(petForHospitalization);
                 }
             }
         }   
         return msj;
     }
     

     //Metodo para asignarle la fecha de salida a una mascota

     public void setOffDatePet (String petForDischarge, Time actualDate){

        boolean found = false;

         for (int i = 0; i < miniRoom.length && !found; i++){

             if (miniRoom[i].getPetClient().getName().equals(petForDischarge)){

                 found = true;
                 miniRoom[i].getClinicHistoryOfThePet().setOffDate(actualDate);

             }
         }
     }

     
     //Metodo para dar de alta a una mascota

     public String dischargeAPet(String petForDischarge, Time actualDate){

        Pet pet = null;
        double costMedication = 0;
        double costHospitalization = 0;
        double totalCost = 0;
        boolean found = false;
        String msg = "";

        for (int i = 0; i < miniRoom.length && !found; i++){

             if (miniRoom[i].getPetClient().getName().equals(petForDischarge)){

                 found = true;
                 miniRoom[i].setAvaiable(true);
                 costHospitalization = miniRoom[i].getPetClient().costHospitalization();
                 costMedication = miniRoom[i].getClinicHistoryOfThePet().medicationCost();
                 totalCost = costMedication + costHospitalization;
                 incomeHospitalizations += costHospitalization;


                 msg = ("La historia clinica de la mascota mientras estuvo hospitalizada es la siguiente " + miniRoom[i].getClinicHistoryOfThePet().showInformationHistory() + "\n" + "\n" 
                    + "Los costos de la hospitalizacion por " + miniRoom[i].getClinicHistoryOfThePet().admisionDateInOnlyDays() + " dias es de " + costHospitalization +"\n" 
                    + "El costo de los medicamentos recetados es " + costMedication + "\n" + "\n" 
                    + "El costo total a pagar es " + totalCost + "\n");

             }

             miniRoom[i].setPetClient(null);
        }

        return msg;
     }


      //Metodo para saber que mascota se para dar de alta

     public Pet showWhatUserSelectedForDischarge (String petForDischarge){

        Pet pet = null;
        boolean found = false;

        for (int i = 0; i < miniRoom.length && !found; i++){

             if (miniRoom[i].getPetClient().getName().equals(petForDischarge)){

                 found = true;
                  pet = miniRoom[i].getPetClient();
              }
         }

         return pet;
     }
 

     //Metodo para buscar el contacto

     public String contactInformationByPetName (String petNameContact){

         String msg = "";
         boolean found = false;
         Pet pet = null;

         for (int i = 0; i < clients.size() && !found; i++){

             if (clients.get(i).showInformationPets().equals(petNameContact)){

                 found = true;
                 msg = "El numero de telefono de " + clients.get(i).getName() + " dueño de " + clients.get(i).showInformationPets() + " es " + clients.get(i).getPhoneNumber() 
                       + " y su direccion es " + clients.get(i).getDirection(); 
             }
         }

         return msg;
     }


     //Metodo para buscar el contacto

     public String contactInformationByClientName (String clientNameContact){

         String msg = "";
         boolean found = false;
         Pet pet = null;

         for (int i = 0; i < clients.size() && !found; i++){

             if (clients.get(i).getName().equals(clientNameContact)){

                 found = true;
                 msg = ("El numero de telefono de " + clients.get(i).getName() + " dueño de " + clients.get(i).showInformationPets() + " es " + clients.get(i).getPhoneNumber() 
                       + " y su direccion es " + clients.get(i).getDirection()); 
             }
         }

         return msg;
     }


     //Metodo para mostrar la informacion de las habitaciones


     public String showInformationPetsHospitalizationNow (){

         String msg = "";

        for (int i = 0; i < miniRoom.length; i++){

            if (miniRoom[i].getAvaiable() == false){

                 msg += ("La habitacion numero " + miniRoom[i].getNumberOfTheRoom() + " se encuentra " + miniRoom[i].getPetClient().getName() + " y tiene la siguiente historia clinica " + "\n" + miniRoom[i].getClinicHistoryOfThePet().showInformationHistory() + "\n" + "\n");
             }
        }

         return msg;

    }

    //Metodo para cambiar el numero de telefono y direccion del cliente

    public String changeClientData(int newNumber, String newDirection, String nameClient){

        String msg = "";

        for (int i = 0; i < clients.size(); i++){

            if (clients.get(i).getName().equals(nameClient)){

                 clients.get(i).setDirection(newDirection);
                 clients.get(i).setPhoneNumber(newNumber);
                 msg = "Se ha cambiado con exito el numero de telefono y la direccion del cliente";  

            }

            else {

                msg = "No se ha podido cambiar el numero de telefono del cliente";
            }
        }
        
         return msg;
    }
    

    //Metodo para agregar medicamento a una mascota hospitalizada

     public String addMedicinePetHospitalization(String namePetMedicine, Medication petNewMedication){

         String msg = "";
         Pet petMedicine = null;

         for (int i = 0; i < miniRoom.length; i++){

             if (miniRoom[i].getPetClient().getName().equals(namePetMedicine)){

                 miniRoom[i].getClinicHistoryOfThePet().addMedicine(petNewMedication);
                 msg = "Se agrego exitosamente el medicamento a la historia clinica de la mascota";
             }

             else {
                 msg = "La mascota no se encuentra hospitalizada, no se le pudieron agregar los medicamentos";
             }
         }

         return msg;
     } 


     //Metodo para añadir notas en la historia clinica de la mascota

     public String addNotesToClinicH(String nameNotes, String notesClinicHistory){

        String msg = "";
        Pet petNotes = null;

        for (int i = 0; i < miniRoom.length; i++){

             if (miniRoom[i].getPetClient().getName().equals(nameNotes)){

                miniRoom[i].getClinicHistoryOfThePet().addNotes(notesClinicHistory);
                msg = "Se añadieron correctamente las notas a la historia clinica de la mascota";
             }

             else {

                msg = "No se pudieron agregar las notas a la historia clinica de la mascota";
             }
        }

        return msg;
     }
     

     //Get and set

     public String getName(){
		 return name;
	}

    public void setName (String name) {
	     this.name = name;
	}

     public double getIncomeHospitalizations() {
         return incomeHospitalizations;
    }

    public void setIncomeHospitalizations (double incomeHospitalizations) {
         this.incomeHospitalizations = incomeHospitalizations;
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
