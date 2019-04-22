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
	private String idOwner;

	//Relaciones

	private Time dateService;


}