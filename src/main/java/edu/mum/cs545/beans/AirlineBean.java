package edu.mum.cs545.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

@Named("airlineBean")
@SessionScoped
public class AirlineBean implements Serializable {

	private static final long serialVersionUID = 1L;
 
	@Inject
	private AirlineService airlineService;
	private Airline airline=new Airline();
	private List<Airline>airlines=new ArrayList<>();

	public String create() {
		airlineService.create(airline);
		airline=new Airline();
		return "airlines";
	}
	
	public String update(Airline airline) {
		System.out.println(airline);
		airlineService.create(airline);
		return "airlines";
	}
	
	public String delete(Airline airline) {
		airlineService.delete(airline);
		return "airlines";
	}
	public AirlineService getAirlineService() {
		return airlineService;
	}

	public void setAirlineService(AirlineService airlineService) {
		this.airlineService = airlineService;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public List<Airline> getAirlines() {
		airlines=airlineService.findAll();
		return airlines;
	}

	public void setAirlines(List<Airline> airlines) {
		this.airlines = airlines;
	}



}
