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

    * <b>post:</b> A new client was added to clients list of the veterinary <br>

    * @param nuevo Is the new client, nuevo != null <br>
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

    * @param nuevo Is the new service, nuevo != null<br>
    */
    
     public void addService (Service nuevo){
            services.add(nuevo);
     }


    /**
    * This method hospitalize a pet that is already register <br>

    * <b>pre:</b> clients is initialized, clients != null <br>

    * <b>post:</b> A pet is hospitalized <br>

    * @param petForHospitalization Is the name of the pet we are looking for. petForHospitalization != null, petForHospitalization != " " <br>

    * @param registerClientId Is the id of the client that we are looking for. registerClientId != null <br>

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

     
    /**
    * This method check if a room is avaiable and add a pet  <br>

    * <b>pre:</b> miniRoom[] is initialized, miniRoom != null <br>

    * <b>post:</b> A pet is added to a room <br>

    * @param current Is the pet which we are looking to add to an avaiable room, current != null <br>

    * @return String If one of the rooms is avaiable the method shows a message with the information of the room, if not the method shows a message with the reason the pet cann't be added<br>
    */

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



    /**
    * This method find the owner of register pet  <br>

    * <b>pre:</b> clients is initialized, clients != null <br>

    * <b>post:</b> The owner of the pet is found <br>

    * @param registerClientId1 is the id of the client that the method needs to search, registerClientId1 != null <br>

    * @return Client The method return the client if the id match<br>
    */

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
 
    /**
    * This method shows the information of the clients that are register  <br>

    * <b>pre:</b> clients is initialized, clients != null <br>

    * <b>post:</b> Clients information is displayed <br>

    * @return String The method return a message with the information of the clients that are register in the veterinary<br>
    */

    public String showInformationOfTheClients(){

        String msg = "";

        for (int i = 0; i<clients.size(); i++){

            msg += ("El nombre del cliente es " + clients.get(i).getName() + "\n" + "El id del cliente es " + clients.get(i).getId() + "\n" + "La direccion del cliente es " + clients.get(i).getDirection() + "\n" + "El numero de telefono del cliente es " + clients.get(i).getPhoneNumber() + "\n" + "El cliente tiene la(s) siguiente(s) mascota(s) " + clients.get(i).showInformationPets() + "\n" + "\n");
        }
        return msg;

    }


    /**
    * This method shows the clients register in the veterinary that are avaiable  <br>

    * <b>pre:</b> clients is initialized, clients != null <br>

    * <b>post:</b> Clients information is displayed <br>

    * @return String The method return a message with the name and the id of the clients that are register in the veterinary<br>
    */

    public String showClientsAvaiable(){

        String msg = "";

        for (int i = 0; i<clients.size(); i++){

            msg += ("El nombre del cliente es " + clients.get(i).getName() + "\n" + "El id del cliente es " + clients.get(i).getId() + "\n" + "\n");
        }
        return msg;

    }

     /**
    * This method shows the pets register in the veterinary that are avaiable  <br>

    * <b>pre:</b> clients is initialized, clients != null <br>

    * <b>post:</b> Pets information is displayed <br>

    * @return String The method return a message with the information that showPetsAvaiable give<br>
    */

     public String showPetsThatAreAvaiable (){

         String msg = "";
         int indice = 1;
         for (int i = 0; i < clients.size(); i++){

         msg += (clients.get(i).showPetsAvaiable());
         }

         return msg;

    }


    /**
    * This method shows the pets that a specific client have <br>

    * <b>pre:</b> clients is initialized, clients != null <br>

    * <b>post:</b> The pet if found and the method show information about it <br>

    * @param registerClientId Is the id of the client, registerclientId != null <br> 

    * @return String The method return a message with the information that showInformationPets give <br>
    */

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


    /**
    * This method search a specific pet between the list of pets of the client <br>

    * <b>pre:</b> clients is initialized, clients != null <br>

    * <b>post:</b> The pet is found and the method show information about it <br>

    * @param selectionPetsAvaiable Is the name of the pet we are looking for. selectionPetsAvaiable != null, selectionPetsAvaiable != " " <br>

    * @return String The method return a message with the information that the method showWhatUserSelected give <br>
    */

     public String showInformationOfTheClinicR (String selectionPetsAvaiable){

         boolean found = false;
         String msg = "";

         for (int i = 0; i < clients.size(); i++){

                msg += (clients.get(i).showWhatUserSelected(selectionPetsAvaiable) + "\n");
        }

    return msg;

            
    } 


    /**
    * This method shows what pet the user select to hospitalize  <br>

    * <b>pre:</b> clients is initialized, clients != null <br>

    * <b>post:</b> The pet if found <br>

    * @param petForHospitalization Is the name of the pet, petForHospitalization != null, petForHospitalization != " " <br>

    * @param registerClientId Is the id of the client, registerClientId != null <br>

    * @return Pet The method return a pet if pet name match <br>
    */   


     public Pet showInformationWhatUserSelectedHospitalization (String petForHospitalization, int registerClientId){

        Pet pet = null;

        for (int i = 0; i < clients.size(); i++){

              if (clients.get(i).getId() == registerClientId){

                  pet = clients.get(i).showWhatUserSelectedForHospitalization(petForHospitalization);
              }
         }

         return pet;
     }


    /**
    * This method shows the information of the rooms <br>

    * <b>pre:</b> miniRoom[] is initialize, miniRoom[] != null <br>

    * <b>post:</b> miniRoom information is disployed <br>

    * @return String The method return a message with the information of the rooms<br>
    */

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



    /**
    * This method shos the information of the rooms that have a pet  <br>

    * <b>pre:</b> miniRoom[] is initialize, miniRoom[] != null <br>

    * <b>post:</b> miniRoom information is disployed <br>

    * @return String The method return a message with information of the rooms<br>
    */


     public String showInformationPetsHospitalization (){

         String msg = "";

        for (int i = 0; i < miniRoom.length; i++){

            if (miniRoom[i].getAvaiable() == false){

                 msg += ("La habitacion numero " + miniRoom[i].getNumberOfTheRoom() + " se encuentra " + miniRoom[i].getPetClient().getName() + "\n" + "\n");
             }
        }

         return msg;

    }


    
    /**
    * This method shows how many clinic histories a specific pet has  <br>

    * <b>pre:</b> clients is initialized, clients != null <br>

    * <b>post:</b> The number of clinic histories is disployed <br>

    * @param registerClientId Is the id of the client. registerClientId != null <br>

    * @param petForHospitalization Is the name of the pet. registerClientId != null, registerClientId != " "

    * @return String The method return a message with the number of clinic histories the pet has <br>
    */

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


    /**
    * This method assings the off date in the clinic history of a pet  <br>

    * <b>pre:</b> miniRoom[] is initialized, miniRoom[] != null <br>

    * <b>post:</b> off date is assigned <br>

    * @param petForDischarge Is the name of the pet. petForDischarge != null, petForDischarge != " " <br>

    * @param actualDate Is the actual date. actualDate != null <br>
    */

     public void setOffDatePet (String petForDischarge, Time actualDate){

        boolean found = false;

         for (int i = 0; i < miniRoom.length && !found; i++){

             if (miniRoom[i].getPetClient().getName().equals(petForDischarge)){

                 found = true;
                 miniRoom[i].getClinicHistoryOfThePet().setOffDate(actualDate);

             }
         }
     }


    /**
    * This method discharge a pet  <br>

    * <b>pre:</b> miniRoom[] is initialized, miniRoom[] != null <br>

    * <b>post:</b> Pet is discharged <br>

    * @param petForDischarge Is the name of the pet. petForDischarge != null, petForDischarge != " " <br>

    * @param actualDate Is the actual date. actualDate != null <br>

    * @return String The method return a message with the information of hospitalization <br>
    */

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


    /**
    * This method find the pet that user select to discharge  <br>

    * <b>pre:</b> miniRoom[] is initialized, miniRoom[] != null <br>

    * <b>post:</b> Pet for discharge is found  <br>

    * @param petForDischarge Is the name of the pet, petForDischarge != null, petForDischarge != " " <br>

    * @return Pet The method return the pet that match with the information <br>
    */

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

 
     /**
    * This method find the owner information by the pet name  <br>

    * <b>pre:</b> clients is initialized, clients != null <br>

    * <b>post:</b> The information of the owner of the pet is displayed <br>

    * @param petNameContact is the name of the pet. petNameContact != null, petNameContact != " " <br>

    * @return String The method return a message with the contact information of the owner of the pet <br>
    */
 

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


     /**
    * This method return the information of the owner by name  <br>

    * <b>pre:</b> clients is initilized, clients != null <br>

    * <b>post:</b> Onwer information is displayed <br>

    * @param clientNameContact Is the name of the client. clientNameContact != null, clientNameContact != " " <br>

    * @return Stribg The method return the information of the owner of the pet <br>
    */

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


     /**
    * This method shows room information <br>

    * <b>pre:</b> miniRoom[] is initialized, miniRoom[] != null <br>

    * <b>post:</b> miniRoom information is displayed  <br>

    * @return String The method return the information of the room <br>
    */

     public String showInformationPetsHospitalizationNow (){

         String msg = "";

        for (int i = 0; i < miniRoom.length; i++){

            if (miniRoom[i].getAvaiable() == false){

                 msg += ("La habitacion numero " + miniRoom[i].getNumberOfTheRoom() + " se encuentra " + miniRoom[i].getPetClient().getName() + " y tiene la siguiente historia clinica " + "\n" + miniRoom[i].getClinicHistoryOfThePet().showInformationHistory() + "\n" + "\n");
             }
        }

         return msg;

    }


    /**
    * This method changes the direction and phone number of client  <br>

    * <b>pre:</b> clients is initialized, clients != null <br>

    * <b>post:</b> Client information is changed <br>

    * @param newNumber Is the new number of the client, newNumber != null <br>

    * @param newDirection Is the new directio of the client, newDirection!= null <br>

    * @param nameClient Is the name of the client, nameClient != null, nameClient != " " <br>

    * @param idClient Is the id of the client, idClient != null <br>

    * @return String The method return a message if the information is changed and if the information can't be change it returns the reason <br>
    */

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


     /**
    * This method add a new medication to the clinic history of a hospitalize pet <br>

    * <b>pre:</b> miniRoom[] is initialized, miniRoom[] != null <br>

    * <b>post:</b> Medication is added to clinic history <br>

    * @param namePetMedicine Is the name of the pet. namePetMedicine != null, namePetMedicine != " " <br>

    * @param petNewMedication Is the medicine to add. petNewMedication != null <br>

    * @return String The method return a message if the medication was added and if can't be added returns the reason <br>
    */    

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


    /**
    * This method add notes to clinic history <br>

    * <b>pre:</b> miniRoom[] is initialized, miniRoom[] != null <br>

    * <b>post:</b> Notes is added to clinic history <br>

    * @param nameNotes Is the name of the pet. nameNotes != null, nameNotes != " " <br>

    * @param notesClinicHistory Is the notes to add. nameNotes != null, nameNotes != " "<br>

    * @return String The method returns a message if notes was added, and return the reason if notes can't be  <br>
    */         

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


     /**
    * This method shows the id of the clients <br>

    * <b>pre:</b> clients is initialized, clients != null <br>

    * <b>post:</b> Id client was displayed <br>

    * @return String The method returns a message if notes was added, and return the reason if notes can't be  <br>
    */         

     public String showIdCLients(){

        String msg = "";

        for (int i = 0; i < clients.size(); i++){

            msg += (clients.get(i).getName() + " y su numero de identidad es " + clients.get(i).getId());
        }

        return msg;
     }


     /**
    * This method shows service income  <br>

    * <b>pre:</b> services is initialized, services != null <br>

    * <b>post:</b> Income service is displayed <br>

    * @return double The method return the income <br>
    */

     public double serviceIncome(){

        for (int i = 0; i < services.size(); i++)

         incomeServices += services.get(i).getCost();

         return incomeServices;
     }


     /**
    * This method shows all the income of veterinary  <br>

    * <b>pre:</b> incomeServices is initilized, incomeServices could be 0 <br>

    * <b>pre:</b> incomeHospitalizations is initilized, incomeHospitalizations could be 0 <br>

    * <b>post:</b> Total income is displayed <br>

    * @return double The method returns the income <br>
    */

     public double totalIncomeVeterinary(){

        double totalIncome = 0;

        totalIncome = incomeServices + incomeHospitalizations;

        return totalIncome;
     }


    /**
    * This method shows the average of the services  <br>

    * <b>pre:</b> services is initilized, services != null <br>

    * <b>post:</b> Service average is displayed <br>

    * @return String The method return a message with the average information <br>
    */

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


    /**
    * This method calculate if the user select more than a week  <br>

    * <b>post:</b> Days user select was calculated <br>

    * @param averageTimeFrom Is the time from that user selected, averageTimeFrom != null <br>

    * @param averageTimeUntil Is the time until that user selected, averageTimeUntil != null <br>

    * @return boolean The method return true if the user select a week and false if the user select more than a week <br>
    */

     public boolean daysUserSelect(Time averageTimeFrom, Time averageTimeUntil){

        int daysFrom = 0;
        int daysFromYear = 0;
        int daysUntil = 0;
        int daysUntilYear = 0;

        boolean correct = false;

        daysFrom = ((averageTimeFrom.getMonth()-1)*30 + averageTimeFrom.getDay());
        daysFromYear = ((averageTimeFrom.getYear()-2001)*360);
        daysFrom = daysFrom + daysFromYear;

        daysUntil = ((averageTimeUntil.getMonth()-1)*30 + averageTimeUntil.getDay());
        daysUntilYear = ((averageTimeUntil.getYear()-2001)*360);
        daysUntil = daysFrom + daysFromYear;

        if (daysUntil - daysFrom == 7){

            correct = true;
        }

        return correct;

     }


      /**
    * This method convert date user select to only days  <br>

    * <b>post:</b> Date user select was converted to only days <br>

    * @param x, is the date user selected, x != null <br>

    * @return int The method return the days <br>
    */
     
     public int dateSelectToDays (Time x){
        int daysFrom = 0;
        int daysFromYear = 0;
        int daysUntil = 0;
        int daysUntilYear = 0;

        boolean correct = false;

        daysFrom = ((x.getMonth()-1)*30 + x.getDay());
        daysFromYear = ((x.getYear()-2001)*360);
        daysFrom = daysFrom + daysFromYear;

        return daysFrom;
    }


     /**
    * This method shows average information in a week <br>

    * <b>pre:</b> services is initilized, services != null <br>

    * <b>pre:</b> clients is initilized, clients != null <br>

    * <b>post:</b> Average information is displayed <br>

    * @param averageTimeFrom Is the time from that user selected, averageTimeFrom != null <br>

    * @param averageTimeUntil Is the time until that user selected, averageTimeUntil != null <br>

    * @return String The method returns the information of the average <br>
    */

     public String averageServicesAndHospitalization(Time averageTimeFrom, Time averageTimeUntil){

        String msg = "";

        double incomeH = 0;

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

        for (int i = 0; i < services.size(); i++){

            if (services.get(i).serviceDate() >= dateSelectToDays(averageTimeFrom) && services.get(i).serviceDate() <= dateSelectToDays(averageTimeUntil)){

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
        }

        for (int j = 0; j < clients.size(); j++){

           incomeH += clients.get(j).searchCLinicHClosed();
        }

        

         msg += ("El promedio del servicio de baño de mascotas en la veterinaria es " + averageBathPetsV + "\n" + "\n");
         msg += ("El promedio del servicio de baño de mascotas en casa es " + averageBathPetsH + "\n" + "\n");
         msg += ("El promedio del servicio de corte de uñas es " + averageCourtNails + "\n" + "\n");
         msg += ("El promedio del servicio de profilaxis es " + averageProphilaxys + "\n" + "\n");
         msg += ("El promedio del servicio de aplicacion de vacunas " + averageAplicationV + "\n" + "\n");
         msg += ("El promedio de las hospitalizaciones es " + incomeH + "\n" + "\n");

        return msg;
     }



     /**
    * This method shows average information in a week <br>

    * <b>pre:</b> miniRoom[] is initilized, miniRoom != null <br>

    * <b>post:</b> Sympton was added <br>

    * @param name Is the name of the pet. name != null, name != " " <br>

    * @param sym Is the symptom to add. sym != null, sym != " " <br>

    * @return String The method return a message with information about adding the symptom <br>
    */

     public String addSymptom (String name, String sym){

        String msg = "";
        Pet petNotes = null;

        for (int i = 0; i < miniRoom.length; i++){

            if(miniRoom[i].getPetClient() != null){

             if (miniRoom[i].getPetClient().getName().equals(name)){

                miniRoom[i].getClinicHistoryOfThePet().addSymptoms(sym);
                msg = "Se añadieron correctamente los sintomas a la historia clinica de la mascota";
             }
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
