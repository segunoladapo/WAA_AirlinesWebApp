package edu.mum.cs545.beans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.airline.model.Airport;
import cs545.airline.service.AirportService;




@Named("airportBean")
@SessionScoped
public class AirportBean implements  Serializable{
    
  
	private static final long serialVersionUID = 1L;
 
	@Inject
	private AirportService airportService;
	private Airport airport=new Airport();
	private List<Airport>airports=new ArrayList<>();

	public String create() {
		airportService.create(airport);
		airport=new Airport();
		return "airports";
	}
	
	public String update(Airport airport) {
		System.out.println(airport);
		airportService.create(airport);
		return "airports";
	}
	
	public String delete(Airport airport) {
		airportService.delete(airport);
		return "airports";
	}
	public AirportService getAirportService() {
		return airportService;
	}

	public void setAirportService(AirportService airportService) {
		this.airportService = airportService;
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public List<Airport> getAirports() {
		airports=airportService.findAll();
		return airports;
	}

	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}



}