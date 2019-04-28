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


     //Metodo para agregarle la mascota a un cliente

     public void addPet (Pet nuevo){
          pets.add(nuevo);
     }

 
      //Metodo para buscar a la mascota

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

 
      //Metodo para mostrar el nombre de las mascotas

      public String showInformationPets (){

           String msg = "";
           for (int i = 0; i < pets.size(); i++){

                msg += (" " + pets.get(i).getName());
          }


          return msg;
      }

      //Metodo para mostrar las mascotas disponibles

      public String showPetsAvaiable (){

          String msg = "";

          for (int i = 0; i < pets.size(); i++){

          msg += (pets.get(i).getName() + "\n");
          }

           return msg;
      }

      //Metodo para ver que mascota selecciono el usuario

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


      //Metodo para ver que mascota selecciono el usuario dentro de las distintas mascotas que tenga un usuario

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




       //Metodo para ver que mascota selecciono el usuario

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

      //Metodo para calcular el costo de hospitalizacion

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
           }
     }
           return cost;
     }



     //Metodo para ver el historial de historias clinicas de una mascota

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

