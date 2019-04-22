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

	         Client clientCarolina = new Client ("Carolina Diaz", 783, "Calle 87 44", 315623869);
	         myLittlePet.addClient(clientCarolina);

	         Pet petCoquito = new Pet ("Coquito", 3.0, 0.15, Pet.DOG, new Time (2018, 10, 18));
	         clientCarolina.addPet(petCoquito);
	         petCoquito.setOwner(clientCarolina);

	         ClinicRecord clinicRecordCoquito = new ClinicRecord();
	         petCoquito.setClinicR(clinicRecordCoquito);

	         ClinicHistory clinicHistory1Coquito = new ClinicHistory("OPEN", "cuerpo extraño en el ojo", "ceguera", new Time (2019, 03, 13), null, null);
             clinicRecordCoquito.addHistory(clinicHistory1Coquito);

             Medication coquitoMedication1 = new Medication("Ocucan", 15.0, 23.8, "Una vez al dia");
             clinicHistory1Coquito.addMedicine(coquitoMedication1);

             myLittlePet.getMiniRoom()[0].setPetClient(petCoquito);
             myLittlePet.getMiniRoom()[0].setAvaiable(false);
             myLittlePet.getMiniRoom()[0].setClinicHistoryOfThePet(clinicHistory1Coquito);

         
	         Client clientJames = new Client ("James Gonzalez", 985, "Calle 34 65", 317890453);
	         myLittlePet.addClient(clientJames);

	         Pet petRoberto = new Pet ("Roberto", 1.0, 0.05, "BIRD", new Time (2018, 10, 18));
	         clientJames.addPet(petRoberto);
	         petRoberto.setOwner(clientJames);

	         ClinicRecord clinicRecordRoberto = new ClinicRecord();
	         petRoberto.setClinicR(clinicRecordRoberto);

	         ClinicHistory clinicHistory1Roberto = new ClinicHistory ("OPEN", "sin apetito", "parasitos", new Time (2019, 01, 2), null, null);
	         clinicRecordRoberto.addHistory(clinicHistory1Roberto);

	         Medication robertoMedication1 = new Medication ("Cardotek 30", 145.0, 3.5, "dos veces al dia");
	         clinicHistory1Roberto.addMedicine(robertoMedication1);

	         myLittlePet.getMiniRoom()[1].setPetClient(petRoberto);
	         myLittlePet.getMiniRoom()[1].setAvaiable(false);
             myLittlePet.getMiniRoom()[1].setClinicHistoryOfThePet(clinicHistory1Roberto);


	     } 
     


	     //Mostramos las opciones del menu
	
	     public void showOptions() {


		
	         System.out.println ("Bienvenido a la veterinaria My Little Pet");

	         System.out.println ("Por favor, digite la opcion que desea ver");

	         System.out.println ("1. Para ver los clientes registrados en la veterinaria y sus mascotas");

	         System.out.println ("2. Para ver el historial de historias clinicas de una mascota");

	         System.out.println ("3. Para ver disponibilidad en las habitaciones");

             System.out.println ("4. Para registrar un cliente");

             System.out.println ("5. Para registrar una nueva mascota");

             System.out.println ("6. Para hospitalizar una mascota ya registrada");

             System.out.println ("7. Para dar de alta a una mascota");

	         System.out.println ("8. Para ver los ingresos por concepto de hospitalizaciones");

	         System.out.println ("9. Para ver la informacion de contacto de una mascota");

             System.out.println ("10. Para ver el reporte de las historias clinicas de las mascotas hospitalizadas actualmente");

             System.out.println ("11. Para cambiar el numero de telefono del cliente y su direccion");

             System.out.println ("12. Para añadir medicamentos a la historia clinica de una mascota hospitalizada");

	         System.out.println ("15. Salir");
    
	     }  



	public void showMenu (){
		
	     int userInput = 0;
	  
	     while(userInput != 15){
	
		     showOptions();	
	         userInput = reader.nextInt();
	         reader.nextLine();

	     switch (userInput){

	     	case 1: 

	     	     System.out.println (myLittlePet.showInformationOfTheClients());

	     	 break;


	     	 case 2:

	     	     System.out.println ("Las mascotas disponibles son las siguientes");
	     	     System.out.println (myLittlePet.showPetsThatAreAvaiable());
	     	     System.out.println ("Escriba el nombre la mascota que desea ver su historial clinico");
                 String selectionPetsAvaiable = reader.nextLine();


                 System.out.println (myLittlePet.showInformationOfTheClinicR(selectionPetsAvaiable));
            
             break;


             case 3:

                  System.out.println (myLittlePet.showRoomsInformation());

             break;


	     	case 4:

                 System.out.println ("Ingrese el id del cliente");
                 int registerClientId = reader.nextInt();
                 reader.nextLine();

                 if (myLittlePet.checkIfClientExist(registerClientId) == true){
                 	 System.out.println ("Usted ya se encuentra registrado en el sistema");
                 }
				 
				 else{

             	     System.out.println ("El id no existe en el sistema, desea registrar el cliente?");
             	     System.out.println ("1. Si" + "\n" + "2. No" + "\n");
             	     int registerSelection = reader.nextInt();
             	     reader.nextLine();

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
                         System.out.println ("Desea registrar una mascota? \n 1. Si, registrarla \n 2. No, no la deseo registrar");
                         int registerAPetSelection = reader.nextInt();
                         reader.nextLine();



                     if (registerAPetSelection == 1){

                         System.out.println ("Ingrese el nombre de la mascota");
                         String registerPetName = reader.nextLine();

                         System.out.println ("Ingrese el tipo de mascota \n 1. Perro \n 2. Gato \n 3. Pajaro \n 4. Otro");
                         int selectionKind = reader.nextInt();
                         reader.nextLine();

                         System.out.println ("Ingrese el peso de la mascota (recuerde que debe ir con coma, por ejemplo 3,0)");
                         double registerPetWeight = reader.nextDouble();
                         reader.nextLine();

                         System.out.println ("Ingrese la altura de la mascota (recuerde que debe ir con coma, por ejemplo 3,0)");
                         double registerPetHeight = reader.nextDouble();
                         reader.nextLine();

                                     
                         String kind = "";

                         if (selectionKind ==1){
                             kind = Pet.DOG;
                         }

                         else if (selectionKind ==2){
                     	     kind = Pet.CAT;

                         }

                         else if (selectionKind ==3){
                             kind = Pet.BIRD;
                         }

                         else {
                             kind = Pet.OTHER;
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
                         Pet petRegister = new Pet (registerPetName, registerPetWeight, registerPetHeight, kind, birthDate);
                         registerClient.addPet(petRegister);
                         petRegister.setOwner(registerClient);


                         System.out.println ("Desea hospitalizar la mascota? \n 1. Si, hospitalizar \n 2. No, no hospitalizar");
                         int hospitalizationSelection = reader.nextInt();
                         reader.nextLine();

                         if (hospitalizationSelection == 1){

                             System.out.println ("Ingrese los sintomas que presenta la mascota");
                             String symptomsSelected = reader.nextLine();

                             System.out.println ("Ingrese el diagnostico de la mascota");
                             String diagnosisSelected = reader.nextLine();

                             System.out.println ("Ingrese el dia en el que ingreso la mascota");
                             int admisionDay = reader.nextInt();
                             reader.nextLine();

                             System.out.println ("Ingrese el mes en el que ingreso la mascota");
                             int admisionMonth = reader.nextInt();
                             reader.nextLine();

                             System.out.println ("Ingrese el año en el que ingreso la mascota");
                             int admisionYear = reader.nextInt();
                             reader.nextLine();


                         ClinicRecord clinicPetRegister = new ClinicRecord();
                         petRegister.setClinicR(clinicPetRegister);

                         Time admisionDate = new Time (admisionYear, admisionMonth, admisionDay);
                         ClinicHistory historyPetRegister = new ClinicHistory("OPEN", symptomsSelected, diagnosisSelected, admisionDate, null, null);

                         clinicPetRegister.addHistory(historyPetRegister);


                             System.out.println ("La mascota tiene medicamentos recetados? \n 1. Si \n 2. No");
                             int medicineSelection = reader.nextInt();
                             reader.nextLine();

                                 if (medicineSelection == 1){

                                     System.out.println ("Ingrese el nombre del medicamento");
                                     String nameMedicineSelected = reader.nextLine();

                                     System.out.println ("Ingrese la dosis del medicamento (recuerde que debe ir con coma, por ejemplo 3,0)");
                                     double doseMedicineSelected = reader.nextDouble();
                                     reader.nextLine();

                                     System.out.println ("Ingrese el costo del medicamento (recuerde que debe ir con coma, por ejemplo 3,0)");
                                     double costDoseMedicineSelected = reader.nextDouble();
                                     reader.nextLine();
                                    
                                     System.out.println ("Ingrese la frecuencia del medicamento (por ejemplo, dos veces al dia)");
                                     String medicineFrecuencySelected = reader.nextLine();

                                Medication petRegisterMedication = new Medication (nameMedicineSelected, doseMedicineSelected, costDoseMedicineSelected, medicineFrecuencySelected);
                                historyPetRegister.addMedicine(petRegisterMedication);


                                 }

                                 else if (medicineSelection == 2){

                                     System.out.println ("No se agrego ningun medicamento a la historia clinica de la mascota");
                                 }
                                     

                             System.out.println (myLittlePet.hospitalization(registerClientId, registerPetName));

                         } //cierra el if si se quiere hospitalizar la mascota

                         else if (hospitalizationSelection == 2){

                         	 System.out.println ("No se pudo hacer la hospitalizacion \n");
                         
                         }

					} //cierra el if de registrar a una mascota

                         if(registerAPetSelection == 2){

                             System.out.println ("No se realizo el registro \n");

                        }

					 } //cierra el si se quiere registrar
					 
                      else{

                         	 System.out.println ("No se realizo el registro \n");
                         }


                         

                     
               } //cierra el if si no esta registrado
			   
			 break;

             case 5: 

             System.out.println ("Los siguientes son los clientes registrados en la veterinaria y sus respectivos id");
             System.out.println (myLittlePet.showClientsAvaiable());


             System.out.println ("Ingrese el id del cliente al que desea registrarle una nueva mascota");
             registerClientId = reader.nextInt();
             reader.nextLine();

                 if (myLittlePet.checkIfClientExist(registerClientId) == true){

                 	System.out.println ("Ingrese el nombre de la mascota");
                    String registerPetName = reader.nextLine();



                    System.out.println ("Ingrese el tipo de mascota \n 1. Perro \n 2. Gato \n 3. Pajaro \n 4. Otro");
                    int selectionKind = reader.nextInt();
                    reader.nextLine();

                    System.out.println ("Ingrese el peso de la mascota (recuerde que debe ir con coma, por ejemplo 3,0)");
                    double registerPetWeight = reader.nextDouble();
                    reader.nextLine();

                    System.out.println ("Ingrese la altura de la mascota (recuerde que debe ir con coma, por ejemplo 3,0)");
                    double registerPetHeight = reader.nextDouble();
                    reader.nextLine();

                                     
                    String kind = "";

                    if (selectionKind ==1){
                             kind = Pet.DOG;
                         }

                         else if (selectionKind ==2){
                             kind = Pet.CAT;

                         }

                         else if (selectionKind ==3){
                             kind = Pet.BIRD;
                         }

                         else {
                             kind = Pet.OTHER;
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
                    Pet petRegister = new Pet (registerPetName, registerPetWeight, registerPetHeight, kind, birthDate);
          
                    myLittlePet.findTheOwnerOfThePet(registerClientId).addPet(petRegister);
                    petRegister.setOwner(myLittlePet.findTheOwnerOfThePet(registerClientId));


                    System.out.println ("Desea hospitalizar la mascota? \n 1. Sí, hospitalizar \n 2. No, no hospitalizar");
                    int hospitalizationSelection = reader.nextInt();
                    reader.nextLine();

                    if (hospitalizationSelection == 1){

                             System.out.println ("Ingrese los sintomas que presenta la mascota");
                             String symptomsSelected = reader.nextLine();

                             System.out.println ("Ingrese el diagnostico de la mascota");
                             String diagnosisSelected = reader.nextLine();

                             System.out.println ("Ingrese el dia en el que ingreso la mascota");
                             int admisionDay = reader.nextInt();
                             reader.nextLine();

                             System.out.println ("Ingrese el mes en el que ingreso la mascota");
                             int admisionMonth = reader.nextInt();
                             reader.nextLine();

                             System.out.println ("Ingrese el año en el que ingreso la mascota");
                             int admisionYear = reader.nextInt();
                             reader.nextLine();


                         ClinicRecord clinicPetRegister = new ClinicRecord();
                         petRegister.setClinicR(clinicPetRegister);

                         Time admisionDate = new Time (admisionYear, admisionMonth, admisionDay);
                         ClinicHistory historyPetRegister = new ClinicHistory("OPEN", symptomsSelected, diagnosisSelected, admisionDate, null, null);

                         clinicPetRegister.addHistory(historyPetRegister);


                             System.out.println ("La mascota tiene medicamentos recetados? \n 1. Si \n 2. No");
                             int medicineSelection = reader.nextInt();
                             reader.nextLine();

                                 if (medicineSelection == 1){

                                     System.out.println ("Ingrese el nombre del medicamento");
                                     String nameMedicineSelected = reader.nextLine();

                                     System.out.println ("Ingrese la dosis del medicamento (recuerde que debe ir con coma, por ejemplo 3,0)");
                                     double doseMedicineSelected = reader.nextDouble();
                                     reader.nextLine();

                                     System.out.println ("Ingrese el costo del medicamento (recuerde que debe ir con coma, por ejemplo 3,0)");
                                     double costDoseMedicineSelected = reader.nextDouble();
                                     reader.nextLine();
                                    
                                     System.out.println ("Ingrese la frecuencia del medicamento (por ejemplo, dos veces al dia)");
                                     String medicineFrecuencySelected = reader.nextLine();

                                Medication petRegisterMedication = new Medication (nameMedicineSelected, doseMedicineSelected, costDoseMedicineSelected, medicineFrecuencySelected);
                                historyPetRegister.addMedicine(petRegisterMedication);


                                 }

                                 else if (medicineSelection == 2){

                                     System.out.println ("No se agrego ningun medicamento a la historia clinica de la mascota");
                                 }
                                     

                             System.out.println (myLittlePet.hospitalization(registerClientId, registerPetName));

                         } //cierra el if si se quiere hospitalizar la mascota

                         else if (hospitalizationSelection == 2){

                             System.out.println ("No se pudo hacer la hospitalizacion \n");
                         
                         }
                    } //cierra la verificacion de si el cliente se encuentra registrado


             break;


             case 6:

             System.out.println ("Ingrese el id del cliente");
             registerClientId = reader.nextInt();
             reader.nextLine();

                 if (myLittlePet.checkIfClientExist(registerClientId) == true){

                     System.out.println ("El cliente tiene las siguientes mascotas registradas, seleccione la que desea hospitalizar");
                     System.out.println (myLittlePet.showPetsOfClient(registerClientId));
                     String petForHospitalization = reader.nextLine();

                     System.out.println (myLittlePet.showHowManyClinicH(registerClientId, petForHospitalization));


             System.out.println ("Ingrese los sintomas que presenta la mascota");
             String symptomsSelected = reader.nextLine();

             System.out.println ("Ingrese el diagnostico de la mascota");
             String diagnosisSelected = reader.nextLine();

             System.out.println ("Ingrese el dia en el que ingreso la mascota");
             int admisionDay = reader.nextInt();
             reader.nextLine();

             System.out.println ("Ingrese el mes en el que ingreso la mascota");
             int admisionMonth = reader.nextInt();
             reader.nextLine();

             System.out.println ("Ingrese el año en el que ingreso la mascota");
             int admisionYear = reader.nextInt();
             reader.nextLine();

             Pet petRegister = myLittlePet.showInformationWhatUserSelectedHospitalization(petForHospitalization, registerClientId);

             ClinicRecord clinicPetRegister = new ClinicRecord();
             petRegister.setClinicR(clinicPetRegister);

             Time admisionDate = new Time (admisionYear, admisionMonth, admisionDay);
             ClinicHistory historyPetRegister = new ClinicHistory("OPEN", symptomsSelected, diagnosisSelected, admisionDate, null, null);

             clinicPetRegister.addHistory(historyPetRegister);


             System.out.println ("La mascota tiene medicamentos recetados? \n 1. Si \n 2. No");
             int medicineSelection = reader.nextInt();
             reader.nextLine();

             if (medicineSelection == 1){

                 System.out.println ("Ingrese el nombre del medicamento");
                 String nameMedicineSelected = reader.nextLine();

                 System.out.println ("Ingrese la dosis del medicamento (recuerde que debe ir con coma, por ejemplo 3,0)");
                 double doseMedicineSelected = reader.nextDouble();
                 reader.nextLine();

                 System.out.println ("Ingrese el costo del medicamento (recuerde que debe ir con coma, por ejemplo 3,0)");
                 double costDoseMedicineSelected = reader.nextDouble();
                 reader.nextLine();
                                    
                 System.out.println ("Ingrese la frecuencia del medicamento (por ejemplo, dos veces al dia)");
                 String medicineFrecuencySelected = reader.nextLine();

                 Medication petRegisterMedication = new Medication (nameMedicineSelected, doseMedicineSelected, costDoseMedicineSelected, medicineFrecuencySelected);
                 historyPetRegister.addMedicine(petRegisterMedication);


            } //cierra el if de si tiene medicinas

            else if (medicineSelection == 2){

                 System.out.println ("No se agrego ningun medicamento a la historia clinica de la mascota");
            }
                                     

             System.out.println (myLittlePet.hospitalizationRegisterPet(petForHospitalization, registerClientId));
    }

             break;


            case 7:

             System.out.println ("Las siguientes son las mascotas hospitalizadas actualmente");
             System.out.println (myLittlePet.showInformationPetsHospitalization());
             System.out.println ("Escriba el nombre de la mascota a la que desea dar de alta");
             String petForDischarge = reader.nextLine();

             System.out.println ("Ingrese el dia actual");
             int actualDay = reader.nextInt();
             reader.nextLine();

             System.out.println ("Ingrese el mes actual");
             int actualMonth = reader.nextInt();
             reader.nextLine();

             System.out.println ("Ingrese el año actual");
             int actualYear = reader.nextInt();
             reader.nextLine();

             Time actualDate = new Time (actualYear, actualMonth, actualDay);

             myLittlePet.setOffDatePet(petForDischarge, actualDate);

             System.out.println (myLittlePet.dischargeAPet(petForDischarge, actualDate));


            break;


             case 8:

             System.out.println ("Los ingresos de la veterinaria por concepto de hospitalizaciones es ");
             System.out.println (myLittlePet.getIncomeHospitalizations());
  
             break;

             case 9:

              System.out.println ("Seleccione como desea buscar los datos de contacto de una mascota");
              System.out.println ("1. Nombre de la mascota \n 2. Nombre del dueño de la mascota");   
              int selection = reader.nextInt();
              reader.nextLine();   


            if (selection == 1){

                 System.out.println ("Ingrese el nombre de la mascota");
                 String petNameContact = reader.nextLine();
                 System.out.println (myLittlePet.contactInformationByPetName(petNameContact));
            }

            else if (selection == 2){

                 System.out.println ("Ingrese el nombre del dueño de la mascota");
                 String clientNameContact = reader.nextLine();
                 System.out.println (myLittlePet.contactInformationByClientName(clientNameContact));
            }

             break;


             case 10:


             System.out.println (myLittlePet.showInformationPetsHospitalizationNow());

             break;


             case 11:

             System.out.println ("Ingrese el nombre del cliente al que desea cambiarle la informacion de contacto");
             String nameClient = reader.nextLine();
             System.out.println ("Ingrese el nuevo numero de telefono del cliente");
             int newNumber = reader.nextInt();
             reader.nextLine();

             System.out.println ("Ingrese la nueva direccion del cliente");
             String newDirection = reader.nextLine();

             System.out.println (myLittlePet.changeClientData(newNumber, newDirection, nameClient));

             break;


             case 12:

             System.out.println ("Seleccione la mascota a la que desea agregarle el medicamento, las siguientes son las mascotas actualmente hospitalizadas \n");
             System.out.println (myLittlePet.showInformationPetsHospitalizationNow());
             String namePetMedicine = reader.nextLine();

             System.out.println ("Ingrese el nombre del medicamento");
             String nameMedicineSelected = reader.nextLine();

             System.out.println ("Ingrese la dosis del medicamento (recuerde que debe ir con coma, por ejemplo 3,0)");
             double doseMedicineSelected = reader.nextDouble();
             reader.nextLine();

             System.out.println ("Ingrese el costo del medicamento (recuerde que debe ir con coma, por ejemplo 3,0)");
             double costDoseMedicineSelected = reader.nextDouble();
             reader.nextLine();
                                    
             System.out.println ("Ingrese la frecuencia del medicamento (por ejemplo, dos veces al dia)");
             String medicineFrecuencySelected = reader.nextLine();

             Medication petNewMedication = new Medication (nameMedicineSelected, doseMedicineSelected, costDoseMedicineSelected, medicineFrecuencySelected);

             System.out.println (myLittlePet.addMedicinePetHospitalization(namePetMedicine, petNewMedication));

             break;


             case 13:

             System.out.println ("Seleccione la mascota a la que desea agregarle las notas en la historia clinica, las siguientes son las mascotas actualmente hospitalizadas \n");
             System.out.println (myLittlePet.showInformationPetsHospitalizationNow());
             String nameNotes = reader.nextLine();

             System.out.println ("Ingrese las notas del posible diagnostico de la mascota");
             String notesClinicHistory = reader.nextLine();

             System.out.println (myLittlePet.addNotesToClinicH(nameNotes, notesClinicHistory));

             break;


	        } //cierra el switch

        } //cierra el while
	
    } //cierra el showMenu

} //cierra el main 


