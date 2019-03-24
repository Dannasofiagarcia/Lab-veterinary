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

                msg = (pets.get(i).getName());
          }

          return msg;
      }

      //Metodo para mostrar las mascotas disponibles

      public String showPetsAvaiable (){

          String msg = "";

          for (int i = 0; i < pets.size(); i++){

          msg += (pets.get(i).getName());
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

