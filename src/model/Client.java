package model;

import java.util.*;

public class Client{


  //Atributos
   
  private String name;
  private int id;
  private String direction;
  private int phoneNumber;

  //Relaciones

  private ArrayList <Pet> pets;

  //Metodo constructor

  public Client (String name, int id, String direction, int phoneNumber){

    this.name = name;
    this.id = id;
   	this.direction = direction;
   	this.phoneNumber = phoneNumber;
    pets = new ArrayList <Pet>();
  }


  /**
  * This method add a new pet to a client  <br>

  * <b>pre:</b> pets is initialized, pets != null <br>

  * <b>post:</b> Pet was added <br>

  * @param nuevo is a pet, pet != null <br>
  */

  public void addPet (Pet nuevo){
    pets.add(nuevo);
  }


  /**
  * This method search a pet by name <br>

  * <b>pre:</b> pets is initialized, pets != null <br>

  * <b>post:</b> Pet is found <br>

  * @param registerPetName Is the pet name. registerPetName != null, registerPetName != " " <br>

  * @return Pet The method return the pet that match with the name <br>
  */

  public Pet findPet (String registerPetName){

    Pet petThatImFinding = null;
    boolean found = false;

    for (int i= 0; i < pets.size() && !found; i++){

      if (pets.get(i).getName().equals(registerPetName)){
        petThatImFinding = pets.get(i);
        found = true;

      }
    }

    return petThatImFinding; 
  }


  /**
  * This method display the name of the pets  <br>

  * <b>pre:</b> pets is initialized, pets != null <br>

  * <b>post:</b> Pets name is displayed <br>

  * @return String The method returns a message with the name of the pets <br>
  */

  public String showInformationPets (){

    String msg = "";

    for (int i = 0; i < pets.size(); i++){

      msg += (" " + pets.get(i).getName());
    }

    return msg;
  }



  /**
  * This method shows avaiable pets <br>

  * <b>pre:</b> pets is initialized, pets != null <br>

  * <b>post:</b> Pets that are avaiable are displayed <br>

  * @return String The method returns a message with pets that are avaiable <br>
  */
    
  public String showPetsAvaiable (){

    String msg = "";

    for (int i = 0; i < pets.size(); i++){

      msg += (pets.get(i).getName() + "\n");
    }

    return msg;
  }


  /**
  * This method show what pet user selected <br>

  * <b>pre:</b> pets is initialized, pets != null <br>

  * <b>post:</b> Pet is found <br>

  * @param selectionPetsAvaiable Is the name of the pet. selectionPetsAvaiable != null, selectionsPetsAvaiable != " " <br>

  * @return Pet The method return the pet that match with the name <br>
  */

  public String showWhatUserSelected (String selectionPetsAvaiable){

    Pet petSelected = null;
    boolean found = false;
    String msg = "";
     
      for (int i= 0; i <pets.size() && !found; i++){

        if(selectionPetsAvaiable.equals(pets.get(i).getName())){

          found = true;
          msg += (pets.get(i).getClinicR().showInformationClinicHistory());
        }
      }
          
        return msg;
  
  }


  /**
  * This method search a specific pet in the owner list <br>

  * <b>pre:</b> pets is initialized, pets != null <br>

  * <b>post:</b> Pet is found <br>

  * @param petNameContact Is the name of the pet. petNameContact != null, petNameContact != " " <br>

  * @return Pet The method return the pet that match with the name <br>
  */

  public Pet dogInformationUserSelected (String petNameContact){

    Pet petSelected = null;
    boolean found = false;
    String msg = "";
     
    for (int i= 0; i <pets.size() && !found; i++){

      if(petNameContact.equals(pets.get(i).getName())){

        found = true;
        petSelected = pets.get(i);
                     
      }
    }
          
    return petSelected;
  }


  /**
  * This method search the pet user select to hospitalize<br>

  * <b>pre:</b> pets is initialized, pets != null <br>

  * <b>post:</b> Pet is found <br>

  * @param petForHospitalization Is the name of the pet. petForHospitalization != null, petForHospitalization != " " <br>

  * @return Pet The method return the pet that match with the name <br>
  */

  public Pet showWhatUserSelectedForHospitalization (String petForHospitalization){

    Pet pet = null;
    boolean found = false;

    for (int i= 0; i <pets.size() && !found; i++){

      if(petForHospitalization.equals(pets.get(i).getName())){

        found = true;
        pet = pets.get(i);
      }
    }
          
    return pet;
  }



  /**
  * This method calculate the cost of hospitalization <br>

  * <b>pre:</b> pets is initialized, pets != null <br>

  * <b>post:</b> Hospitalization cost was calculated <br>

  * @return double The method returns the cost of hospitalization <br>
  */

  public double costHospitalizationOfThePet (){

    Pet pet = null;
    double cost = 0;

    for (int i = 0; i < pets.size(); i++){

      pet = pets.get(i);

      if (pet.getKind().equals("CAT")){

        if (pet.getWeight() >= 1.0 && pet.getWeight() <= 3.0){

          cost += (pet.getClinicR().hospitalizationDays()) * 10;
        }

        else if (pet.getWeight() >= 3.1 && pet.getWeight() <= 10.0){

          cost += 12 * pet.getClinicR().hospitalizationDays();

        }

        else if (pet.getWeight() >= 10.1 && pet.getWeight() <= 20.0){

           cost += 15 * pet.getClinicR().hospitalizationDays();

        }

       else if (pet.getWeight() > 20.0){

        cost += 20 * pet.getClinicR().hospitalizationDays();
      }

    } //cierra el if de cat

      else if (pet.getKind().equals("DOG")){

        if (pet.getWeight() >= 1.0 && pet.getWeight() <= 3.0){

          cost += 15 * pet.getClinicR().hospitalizationDays();
        }

        else if (pet.getWeight() >= 3.1 && pet.getWeight() <= 10.0){

          cost += 17 * pet.getClinicR().hospitalizationDays();

        }

        else if (pet.getWeight() >= 10.1 && pet.getWeight() <= 20.0){

          cost += 20 * pet.getClinicR().hospitalizationDays();

        }

        else if (pet.getWeight() > 20.0){

          cost += 25 * pet.getClinicR().hospitalizationDays();
        }

      } //cierra el if de dog


      else if (pet.getKind().equals("BIRD")){

        if (pet.getWeight() >= 1.0 && pet.getWeight() <= 3.0){

          cost += 10* pet.getClinicR().hospitalizationDays();
        }

        else if (pet.getWeight() >= 3.1 && pet.getWeight() <= 10.0){

          cost += 12 * pet.getClinicR().hospitalizationDays();

        }

        else if (pet.getWeight() >= 10.1 && pet.getWeight() <= 20.0){

          cost += 20 * pet.getClinicR().hospitalizationDays();

        }

        else if (pet.getWeight() > 20.0){

          cost += 25 * pet.getClinicR().hospitalizationDays();
        }

      } //cierra el if de bird


      else if (pet.getKind().equals("OTHER")){

        if (pet.getWeight() >= 1.0 && pet.getWeight() <= 3.0){

          cost += 10 * pet.getClinicR().hospitalizationDays();
        }

        else if (pet.getWeight() >= 3.1 && pet.getWeight() <= 10.0){

          cost += 17 * pet.getClinicR().hospitalizationDays();

        }

        else if (pet.getWeight() >= 10.1 && pet.getWeight() <= 20.0){
 
          cost += 30 * pet.getClinicR().hospitalizationDays();

        }

        else if (pet.getWeight() > 20.0){

          cost += 30 * pet.getClinicR().hospitalizationDays();
        }

      } //cierra el if other
    }

      return cost;
    }


  /**
  * This method shows how many clinic histories a pet has <br>

   * <b>pre:</b> pets is initialized, pets != null <br>

  * <b>post:</b> Number of clinic histories was displayed <br>

  * @param petForHospitalization Is the name of the pet. petForHospitalization != null, petForHospitalization != " " <br>

  * @return String The method returns a message with the number of clnic histories a pet has <br>
  */

  
  public String howManyClinicHThePetHave(String petForHospitalization){

    String msg = "";

    for (int i = 0; i < pets.size(); i++){

      if (pets.get(i).getName().equals(petForHospitalization)){

        if (pets.get(i).getClinicR().howManyClinicH() == 0){

          msg = "La mascota no tiene historias clinicas";
        }

        else {

          msg = ("La mascota tiene " + pets.get(i).getClinicR().howManyClinicH() + "historia(s) clinica(s)");
        }
      }
    }

      return msg;
  }


  /**
  * This method search a pet tha has a closed clinic history and get the cost <br>

  * <b>pre:</b> pets is initialized, pets != null <br>

  * <b>post:</b> Clinic history closed is found and cost is displayed <br>

  * @return double The method returns the cost of closed clinic histories <br>
  */

  public double searchCLinicHClosed(){

    double cost = 0;
    ClinicHistory clinic = null;

    for (int i = 0; i < pets.size(); i++){
      if (pets.get(i).getClinicR().incomePublicOpenClinicH() != null){
        cost += pets.get(i).costHospitalization();
      }
    }

      return cost;
  }


  //Get and set

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public int getId(){
    return id;
  }

  public void setId(int id){
    this.id = id;
  }

  public String getDirection(){
    return direction;
  }

  public void setDirection(String direction){
    this.direction = direction;
  }  

  public int getPhoneNumber(){
    return phoneNumber;
  }

  public void setPhoneNumber(int phoneNumber){
    this.phoneNumber = phoneNumber;
  }

  public ArrayList getPets(){
    return pets;
  }

  public void setPets(ArrayList<Pet> pets){
    this.pets = pets;
  }



}

