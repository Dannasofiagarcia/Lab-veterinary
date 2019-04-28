package model;

import java.util.*;

public class Pet{


	  //Constantes

     public final static String DOG = "perro";
     public final static String CAT = "gato";
     public final static String BIRD = "ave";
     public final static String OTHER = "otro";

     //Atributos

     private String name;
     private double weight;
     private double height;
     private String kind;


     //Relaciones

     private ClinicRecord clinicR;
     private Time bornTime;
     private Client owner;


     //Metodo constructor

     public Pet (String name, double weight, double height, String kind, Time bornTime){

     	this.name = name;
     	this.weight = weight;
      this.height = height;
     	this.kind = kind;
     }


     //Costo hospitalizacion

     public double costHospitalization (){

          double cost = 0;

           if (kind.equals(CAT)){

                if (weight >= 1.0 && weight <= 3.0){

                    cost += getClinicR().hospitalizationDays() *10;
                }

                else if (weight >= 3.1 && weight <= 10.0){

                    cost += 12.0 * getClinicR().hospitalizationDays();

                }

                else if (weight >= 10.1 && weight <= 20.0){

                    cost += 15.0 * getClinicR().hospitalizationDays();

                }

                else if (weight > 20.0){

                    cost += 20.0 * getClinicR().hospitalizationDays();
                }

           } //cierra el if de cat

           else if (kind.equals(DOG)){

                if (weight >= 1.0 && weight <= 3.0){

                    cost += 15.0 * getClinicR().hospitalizationDays();
                }

                else if (weight >= 3.1 && weight <= 10.0){

                    cost += 17.0 * getClinicR().hospitalizationDays();

                }

                else if (weight >= 10.1 && weight <= 20.0){

                    cost += 20.0 * getClinicR().hospitalizationDays();

                }

                else if (weight > 20.0){

                    cost += 25.0 * getClinicR().hospitalizationDays();
                }

           } //cierra el if de dog


           else if (kind.equals(BIRD)){

                if (weight >= 1.0 && weight <= 3.0){

                    cost += 10.0 * getClinicR().hospitalizationDays();
                }

                else if (weight >= 3.1 && weight <= 10.0){

                    cost += 12.0 * getClinicR().hospitalizationDays();

                }

                else if (weight >= 10.1 && weight <= 20.0){

                    cost += 20.0 * getClinicR().hospitalizationDays();

                }

                else if (weight > 20.0){

                    cost += 25.0 * getClinicR().hospitalizationDays();
                }

           } //cierra el if de bird


           else if (kind.equals(OTHER)){

                if (weight >= 1.0 && weight <= 3.0){

                    cost += 10.0 * getClinicR().hospitalizationDays();
                }

                else if (weight >= 3.1 && weight <= 10.0){

                    cost += 17.0 * getClinicR().hospitalizationDays();

                }

                else if (weight >= 10.1 && weight <= 20.0){

                    cost += 30.0 * getClinicR().hospitalizationDays();

                }

                else if (weight > 20.0){

                    cost += 30.0 * getClinicR().hospitalizationDays();
                }

           } //cierra el if de other

           return cost;
     }

     //Metodo para calcular la masa corporal de la mascota

     public double calculateBMI(){
 
     double indexBM = 0;
     String msg = "";

     indexBM = weight/height*height;

       if (height == 0){

         msg = "No se puede realizar la operacion, la division entre 0 no existe";

       }
  
     return indexBM;
     }



     //Get and set

      public String getName(){
          return name;
     }

     public void setName(String name){
          this.name = name;
     }

     public Client getOwner(){
          return owner;
     }

     public void setOwner(Client owner){
          this.owner = owner;
     }


     public double getWeight(){
          return weight;
     }

     public void setWeight(double weight){
          this.weight = weight;
     }

     public double getHeight(){
          return height;
     }

     public void setHeight(double height){
          this.height = height;
     }


     public String getKind(){
          return kind;
     }

     public void setKind (String kind){
          this.kind = kind;
     }

     public Time getBornTime(){
          return bornTime;
     }

     public void setBornTime (Time bornTime){
          this.bornTime = bornTime;
     }

      public ClinicRecord getClinicR(){
          return clinicR;
     }

     public void setClinicR (ClinicRecord clinicR){
          this.clinicR = clinicR;
     }
}



