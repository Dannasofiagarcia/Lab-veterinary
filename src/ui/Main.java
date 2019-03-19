package ui;

import model.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
    //Relaciones
	
	private Veterinary myLittlePet;
	
	private Scanner reader;


    public Main() {
		     init ();
		     reader = new Scanner (System.in);
	 }	
	

	     public static void main(String[] args) {
		     Main m = new Main (); 
		     m.showMenu();

	     }
	
	    //Creamos los objetos
	
	     public void init() { 

	         //myLittlePet = new Veterinary ("My Little Pet");
	     } 




	     //Mostramos las opciones del menu
	
	     public void showOptions() {
		
	         System.out.println ("Bienvenido a la veterinaria My Little Pet");

	         System.out.println ("Por favor, digite la opcion que desea ver");

             System.out.println ("1. Para registrar un nuevo cliente");

	         System.out.println ("2. Para ver disponibilidad en las habitaciones");

	         System.out.println ("3. Para ver el historial clinico de la mascota");

	         System.out.println ("4. Para calcular el costo de la hospitalizacion");

	         System.out.println ("5. Para ver la informacion de contacto");

	         System.out.println ("6. Para conocer los ingresos por conceptos de hospitalizacion");

	         System.out.println ("7. Salir");
    
	     }  



	public void showMenu (){
		
	     int userInput = 0;
	  
	     while(userInput != 7){
	
		     showOptions();	
	         userInput = reader.nextInt();
	         reader.nextLine();

	     switch (userInput){

	     	case 1:

	     	     System.out.println ("Ingrese el nombre de la mascota");
                 String registerName = reader.nextLine();

                 System.out.println ("Ingrese el tipo de mascota \n 1. Perro \n 2. Gato \n 3. Pajaro \n 4. Otro");
                 int selectionKind = reader.nextInt();
                 reader.nextLine();

                 public String knowWhatUserSelected(){

                 String kind = ""; 
                 	if (selectionKind == 1){
                 		 kind = "DOG";
                 	} 

                     else if (selectionKind ==2){
                     	 kind = "CAT";

                     }

                     else if (selectionKind ==3){
                     	kind = "BIRD";
                     }

                     else {

                     	kind = "OTHER";
                     }
                 return kind;
                 }

                 System.out.println ("Ingrese el dia de nacimiento de la mascota");
                 int birthDay = reader.nextInt();
                 reader.nextLine();

                 System.out.println ("Ingrese el mes de nacimiento de la mascota");
                 int birthMonth = reader.nextInt();
                 reader.nextLine();

                 System.out.println ("Ingrese el año de nacimiento de la mascota");
                 int birthYear = reader.nextInt();
                 reader.nextLine();
               
                 Time birthDate = new Time (birthYear, birthMonth, birthDay);
                 Pet petRegister = new Pet (name, weight, kind, birthDate);



	         }
	     }
    }
	
}