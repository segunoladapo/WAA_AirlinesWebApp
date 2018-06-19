package edu.mum.cs545.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.airline.model.Airline;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.FlightService;

@Named("flightBean")
@SessionScoped
public class FlightBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FlightService flightService;
	@Inject
	private AirlineService airlineService;
	private List<Flight> flights = new ArrayList<>();
	private List<Airline> airlines = new ArrayList<>();
	private String selectedName;

	public String getSelectedName() {
		return selectedName;
	}

	public void setSelectedName(String selectedName) {
		this.selectedName = selectedName;
	}

	public void getSelectedFlights(){
		System.out.println(selectedName);
	}
	
	public List<Flight> getFlights() {
		if(selectedName==null || selectedName.equalsIgnoreCase("all")) {
		flights = flightService.findAll();
		}else {
			Airline airline=airlineService.findByName(selectedName);
			flights=airline.getFlights();
		}
		return flights;
	}

	public List<Airline> getAirlines() {
		airlines = airlineService.findAll();
		return airlines;
	}

}
