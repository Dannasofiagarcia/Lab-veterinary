package model;

import java.util.*;

public class Time{

	 //Atributos
	 
	 private int month;
	 private int day;
	 private int year;
	 
	 
	 //Metodos
	 
    public Time (int year, int month, int day){
	
	this.year = year;
	this.month = month;
	this.day = day;
	}
	 
	 
	 public int getMonth() {
		return month;
	}

    public void setMonth (int month){
	    this.month = month;
	}

    public int getDay() {
		return day;
	}

    public void setDay (int day){
	    this.day = day;
	}
	
	public int getYear() {
		return year;
	}

    public void setYear (int year){
	    this.year = year;
	}
	

}


