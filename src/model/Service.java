package model;

public class Service {

	//Constantes

	 public final static String BATH_PETS_VETERINARY = "baño de mascotas en la veterinaria";
	 public final static String BATH_PETS_HOME = "baño de mascotas a domicilio";
	 public final static String COURT_NAILS = "corte de uñas";
	 public final static String PROPHYLAXIS = "profilaxis";
	 public final static String APPLICATION_VACCINES = "aplicacion de vacunas";
	
	//Atributos

	 private String type;
	 private double cost;
	 private String namePet;
	 private int idOwner;

	//Relaciones

	 private Time dateService;

	//Constructor

	 public Service (String type, String namePet, int idOwner, Time dateService){

	 	 this.type = type;
	 	 this.namePet = namePet;
	 	 this.idOwner = idOwner;
	 	 this.dateService = dateService;
	 	 cost = serviceCost();
	 }


	 /**
    * This method calculate service cost  <br>

    * <b>pre:</b>type is initilized, type != null <br>

    * <b>post:</b> Service cost is calculated <br>

    * @return double The method returns service cost <br>
    */
     
     public double serviceCost(){

     	if (type.equals(BATH_PETS_VETERINARY)){
     		cost += 20.0;
     	}

     	else if (type.equals(BATH_PETS_HOME)){
 			cost += 30.0;

     	}

     	else if (type.equals(COURT_NAILS)){
     		cost += 8.0;
     	}

     	else if (type.equals(PROPHYLAXIS)){
     		cost += 12.0;
     	}

     	else if (type.equals(APPLICATION_VACCINES)){
     		cost += 45.0;
     	}

     	return cost;
     }


     /**
    * This method convert a date to days  <br>

    * <b>pre:</b> dateService is initilized, dateService != null <br>

    * <b>post:</b> Date was converted to only days <br>

    * @return int The method return the number of days <br>
    */

     public int serviceDate (){

     	int days = 0;
     	int year = 0;

     	days = ((dateService.getMonth()-1)*30 + dateService.getDay());
     	year = ((dateService.getYear()-2001)*360);
     	days = days + year;

     	return days;
     }

	 //Get y set

	 public String getType(){
		 return type;
	}

    public void setType (String type) {
	     this.type = type;
	}

	public double getCost(){
		 return cost;
	}

    public void setCost (double cost) {
	     this.cost = cost;
	}

	public String getNamePet(){
		 return namePet;
	}

    public void setNamePet (String namePet) {
	     this.namePet = namePet;
	}

	public int getIdOwner(){
		 return idOwner;
	}

    public void setIdOwner (int idOwner) {
	     this.idOwner = idOwner;
	}


}