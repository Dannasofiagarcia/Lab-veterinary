package model;

import java.util.*;

public class Veterinary{


     //Constantes

	public final static int QUANTITY_ROOMS = 8;


     //Atributos

     private String name;
     private double incomeHospitalizations;
     private double incomeServices;


     //Relaciones

     private ArrayList <Client> clients;
     private Room [] miniRoom;
     private ArrayList <Service> services;
     

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
         services = new ArrayList <Service>();
     }

    /**
    * This method check if the client exists <br>

    * <b>pre:</b> clients is initialized, clients != null <br>

    * <b>post:</b> It has been verified if the client is registered in the veterinary <br>

    * @param registerClientId Is the number identification of the client, registerClientId != null <br>

    * @return boolean True if the client exists and false if the client doesn't exist <br>
    */

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
    

    /**
    * This method add a new client <br>

    * <b>pre:</b> clients is initialized, clients != null <br>

    * <b>post:</b> A new client is added to clients list of the veterinary <br>

    * @param nuevo is the new client to add to the veterinary<br>
    */

     public void addClient (Client nuevo){
         if (nuevo != null){
            clients.add(nuevo);
         }
     }  


    /**
    * This method add a new service <br>

    * <b>pre:</b> services is initialized, services != null <br>

    * <b>post:</b> A new service is added to the services list of the veterinary <br>

    * @param nuevo is the new service to add to the veterinary <br>
    */
    
     public void addService (Service nuevo){
            services.add(nuevo);
     }


      /**
    * This method hospitalize a pet that is already register <br>

    * <b>pre:</b> clients is initialized, clients != null <br>

    * <b>post:</b> A pet is hospitalized <br>

    * @param nuevo is the new service to add to the veterinary <br>

    * @return String If the pet was hospitalized the method show a message with the information of the room, if the pet wasn't hospitalized the method show a message with the reason <br>
    */

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

         msg += (clients.get(i).showPetsAvaiable());
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

                if(miniRoom[i].getPetClient() != null){

                    msg += ("La habitacion numero " + miniRoom[i].getNumberOfTheRoom() + " esta ocupada y se encuentra la mascota " + miniRoom[i].getPetClient().getName() + "\n" + "\n");
                }
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

                 miniRoom[i].setPetClient(null);

             }

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

             if (clients.get(i).dogInformationUserSelected(petNameContact).getName().equals(petNameContact)){

                 found = true;
                 msg += "El numero de telefono de " + clients.get(i).getName() + " dueño de " + clients.get(i).showInformationPets() + " es " + clients.get(i).getPhoneNumber() 
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

    public String changeClientData(int newNumber, String newDirection, String nameClient, int idClient){

        String msg = "";

        for (int i = 0; i < clients.size(); i++){

            if (clients.get(i).getId() == idClient){

                 clients.get(i).setDirection(newDirection);
                 clients.get(i).setPhoneNumber(newNumber);
                 msg = "Se ha cambiado con exito el numero de telefono y la direccion del cliente";  

            }

            else {

                msg = "No se ha podido cambiar el numero de telefono ni la direccion del cliente";
            }
        }
        
         return msg;
    }
    

    //Metodo para agregar medicamento a una mascota hospitalizada

     public String addMedicinePetHospitalization(String namePetMedicine, Medication petNewMedication){

         String msg = "";

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

            if(miniRoom[i].getPetClient() != null){

             if (miniRoom[i].getPetClient().getName().equals(nameNotes)){

                miniRoom[i].getClinicHistoryOfThePet().addNotes(notesClinicHistory);
                msg = "Se añadieron correctamente las notas a la historia clinica de la mascota";
             }
         }
     }

        return msg;
     }

     //Metodo para ver el numero de identidad de los clientes actualmente registrados

     public String showIdCLients(){

        String msg = "";

        for (int i = 0; i < clients.size(); i++){

            msg += (clients.get(i).getName() + " y su numero de identidad es " + clients.get(i).getId());
        }

        return msg;
     }

     //Metodo para mostrar los ingresos por concepto de servicios

     public double serviceIncome(){

        for (int i = 0; i < services.size(); i++)

         incomeServices += services.get(i).getCost();

         return incomeServices;
     }

     //Metodo para calcular los ingresos totales de la veterinaria

     public double totalIncomeVeterinary(){

        double totalIncome = 0;

        totalIncome = incomeServices + incomeHospitalizations;

        return totalIncome;
     }

     //Metodo para calcular el promedio de los servicios

     public String averageServices(){

        int counterBathPetsV = 0;
        int counterBathPetsH = 0;
        int counterCourtNails = 0;
        int counterProphilaxys = 0;
        int counterAplicationV = 0;

        double incomeBathPetsH = 0;
        double incomeBathPetsV = 0;
        double incomeCourtNails = 0;
        double incomeProphilaxys = 0;
        double incomeAplicationV = 0;

        double averageBathPetsH = 0;
        double averageBathPetsV = 0;
        double averageCourtNails = 0;
        double averageProphilaxys = 0;
        double averageAplicationV = 0;

        String msg = "";

        for (int i = 0; i < services.size(); i++){

            if (services.get(i).getType().equals(Service.BATH_PETS_VETERINARY)){

                 counterBathPetsH++;
                 incomeBathPetsH += services.get(i).getCost();
                 averageBathPetsH = incomeBathPetsH/counterBathPetsH;
            }

            if (services.get(i).getType().equals(Service.BATH_PETS_HOME)){

                counterBathPetsV++;
                incomeBathPetsV += services.get(i).getCost();
                averageBathPetsV = incomeBathPetsV/counterBathPetsV;
            }

            if (services.get(i).getType().equals(Service.COURT_NAILS)){

                counterCourtNails++;
                incomeCourtNails += services.get(i).getCost();
                averageCourtNails = incomeCourtNails/counterCourtNails;
            }

            if (services.get(i).getType().equals(Service.PROPHYLAXIS)){

                counterProphilaxys++;
                incomeProphilaxys += services.get(i).getCost();
                averageProphilaxys = incomeProphilaxys/counterProphilaxys;
            }

            if (services.get(i).getType().equals(Service.APPLICATION_VACCINES)){

                counterAplicationV++;
                incomeAplicationV += services.get(i).getCost();
                averageAplicationV = incomeAplicationV/counterAplicationV;
            }
        }

         msg += ("El promedio del servicio de baño de mascotas en la veterinaria es " + averageBathPetsV + "\n" + "\n");
         msg += ("El promedio del servicio de baño de mascotas en casa es " + averageBathPetsH + "\n" + "\n");
         msg += ("El promedio del servicio de corte de uñas es " + averageCourtNails + "\n" + "\n");
         msg += ("El promedio del servicio de profilaxis es " + averageProphilaxys + "\n" + "\n");
         msg += ("El promedio del servicio de aplicacion de vacunas " + averageAplicationV + "\n" + "\n");

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

     public ArrayList getServices(){
        return services;
     }

     public void setServices(ArrayList<Service> services){
        this.services = services;
     }

	public Room[] getMiniRoom() {
		 return miniRoom;
	}

    public void setMiniRoom (Room[] miniRoom) {
	     this.miniRoom = miniRoom;
	}

}
