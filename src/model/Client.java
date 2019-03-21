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
     	ArrayList <Pet> pets = new ArrayList <Pet>();
     }


     //Metodo para agregarle la mascota a un cliente

     public void addPet (Pet nuevo){
          pets.add(nuevo);
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

