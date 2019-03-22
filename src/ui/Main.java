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

	         myLittlePet = new Veterinary ("My Little Pet");

	         Client clientCarolina = new Client ("Carolina Diaz", 783, "Street 87 44", 315623869);
	         myLittlePet.addClient(clientCarolina);

	         Pet petCoquito = new Pet ("Coquito", 3.0, "PET", new Time (2018, 10, 18));
	         clientCarolina.addPet(petCoquito);
	         petCoquito.setOwner(clientCarolina);

	         ClinicRecord clinicRecordCoquito = new ClinicRecord();
	         petCoquito.setClinicR(clinicRecordCoquito);

	         ClinicHistory clinicHistory1Coquito = new ClinicHistory("OPEN", "Stranger body in the eye", "Blindness", new Time (2019, 03, 13), null);
             clinicRecordCoquito.addHistory(clinicHistory1Coquito);

             Medication coquitoMedication1 = new Medication("Ocucan", 15.0, 23.8, "Once in a day");
            clinicHistory1Coquito.addMedicine(coquitoMedication1);

            myLittlePet.getMiniRoom()[0].setPetClient(petCoquito);

         
	         Client clientJames = new Client ("James Gonzalez", 985, "Street 34 65", 317890453);
	         myLittlePet.addClient(clientJames);

	         Pet petRoberto = new Pet ("Roberto", 0.8, "BIRD", new Time (2018, 10, 18));
	         clientJames.addPet(petRoberto);
	         petRoberto.setOwner(clientJames);

	         ClinicRecord clinicRecordRoberto = new ClinicRecord();
	         petCoquito.setClinicR(clinicRecordCoquito);

	         ClinicHistory clinicHistory1Roberto = new ClinicHistory ("OPEN", "Lack of appetite", "Parasites", new Time (2019, 01, 2), null);
	         clinicRecordRoberto.addHistory(clinicHistory1Roberto);

	         Medication robertoMedication1 = new Medication ("Cardotek 30", 145.0, 36.5, "Twice in a day");
	         clinicHistory1Roberto.addMedicine(robertoMedication1);

	         myLittlePet.getMiniRoom()[1].setPetClient(petRoberto);


	     } 
     


	     //Mostramos las opciones del menu
	
	     public void showOptions() {


		
	         System.out.println ("Bienvenido a la veterinaria My Little Pet");

	         System.out.println ("Por favor, digite la opcion que desea ver");

             System.out.println ("1. Para registrar un nuevo cliente");

             System.out.println ("2. Para registrar una nueva mascota");

             System.out.println ("3. Para hospitalizar una mascota");

             System.out.println ("4. Para dar de alta a una mascota");

	         System.out.println ("5. Para ver disponibilidad en las habitaciones");

	         System.out.println ("6. Para ver el historial clinico de la mascota");

	         System.out.println ("7. Para calcular el costo de la hospitalizacion");

	         System.out.println ("8. Para ver la informacion de contacto");

	         System.out.println ("9. Para conocer los ingresos por conceptos de hospitalizacion");

	         System.out.println ("10. Salir");
    
	     }  



	public void showMenu (){
		
	     int userInput = 0;
	  
	     while(userInput != 10){
	
		     showOptions();	
	         userInput = reader.nextInt();
	         reader.nextLine();

	     switch (userInput){

	     	case 1:

             System.out.println ("Ingrese el id del cliente");
             int registerClientId = reader.nextInt();
             reader.nextLine();

                 if (myLittlePet.checkIfClientExist(registerClientId) == false){

             	     System.out.println ("Su id no existe en el sistema, ¿desea registrarse?");
             	     System.out.println ("¿Desea registrarse? \n 1. Deseo registrarme \n 2. No deseo registrarme \n");
             	     int registerSelection = reader.nextInt();

             	         if (registerSelection == 1){

                             System.out.println ("Ingrese el nombre del cliente");
                             String registerClientName = reader.nextLine();
 
                             System.out.println ("Ingrese la direccion del cliente");
                             String registerClientDirection = reader.nextLine();

                             System.out.println ("Ingrese el numero de telefono del cliente");
                             int registerNumberPhoneClient = reader.nextInt();
                             reader.nextLine();

                             Client registerClient = new Client (registerClientName, registerClientId, registerClientDirection, registerNumberPhoneClient);
                             myLittlePet.addClient(registerClient);

                             System.out.println ("Cliente registrado con exito \n");
                             System.out.println ("¿Desea registrar una mascota? \n 1. Sí, registrarla \n 2. No, no la deseo registrar");
                             int registerAPetSelection = reader.nextInt();


                                 if (registerAPetSelection == 1){

                                 	 System.out.println ("Ingrese el nombre de la mascota");
                                     String registerPetName = reader.nextLine();

                                     System.out.println ("Ingrese el tipo de mascota \n 1. Perro \n 2. Gato \n 3. Pajaro \n 4. Otro");
                                     int selectionKind = reader.nextInt();
                                     reader.nextLine();

                                     System.out.println ("Ingrese el peso de la mascota");
                                     double registerPetWeight = reader.nextDouble();

                                     
                                     String kind = "";

                                         if (selectionKind ==1){
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
                                     Pet petRegister = new Pet (registerPetName, registerPetWeight, kind, birthDate);
                                     registerClient.addPet(petRegister);
                                     petRegister.setOwner(registerClient);


                                     System.out.println ("¿Desea hospitalizar la mascota? \n 1. Sí, hospitalizar \n 2. No, no hospitalizar");
                                     int hospitalizationSelection = reader.nextInt();
                                     reader.nextLine();

                                     System.out.println (myLittlePet.hospitalization(registerClientId, registerPetName));



                                 }

                         else {
                         	 System.out.println ("No se realizo el registro \n");
                         }

                     	     break;

                    }  
               }
	        }
        }
	
    }
}


