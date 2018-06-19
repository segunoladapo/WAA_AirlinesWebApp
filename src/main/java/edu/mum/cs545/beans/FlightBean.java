package edu.mum.cs545.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.airline.model.Airline;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirportService;
import cs545.airline.service.FlightService;

@Named("flightBean")
@SessionScoped
public class FlightBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FlightService flightService;
	@Inject
	private AirlineService airlineService;
	@Inject
	private AirportService airportService;
	private List<Flight> flights = new ArrayList<>();
	private List<Flight> flightslist = new ArrayList<>();
	private List<Airline> airlines = new ArrayList<>();
	private List<Airport> airports = new ArrayList<>();
	private String selectedName;
	private String selectedOrigin;
	private String selectedDestination;

	public String getSelectedName() {
		return selectedName;
	}

	public void setSelectedName(String selectedName) {
		this.selectedName = selectedName;
	}

	public String getSelectedOrigin() {
		return selectedOrigin;
	}

	public void setSelectedOrigin(String selectedOrigin) {
		this.selectedOrigin = selectedOrigin;
	}

	public String getSelectedDestination() {
		return selectedDestination;
	}

	public void setSelectedDestination(String selectedDestination) {
		this.selectedDestination = selectedDestination;
	}

	public void getFlightByOrigin() {
		Airport airport = airportService.findByCode(selectedOrigin);
		flights = flightService.findByOrigin(airport);
	}

	public void getFlightByDestination() {
		Airport airport = airportService.findByCode(selectedDestination);
		flights = flightService.findByDestination(airport);

	}

	public void getSelectedFlights() {
		Airline airline = airlineService.findByName(selectedName);
		flights = airline.getFlights();
	}

	public List<Flight> getFlightslist() {
		flightslist = flightService.findAll();
		return flightslist;
	}

	public List<Airline> getAirlines() {
		airlines = airlineService.findAll();
		return airlines;
	}

	public List<Airport> getAirports() {
		airports = airportService.findAll();
		return airports;
	}

	public List<Flight> getFlights() {
		return flights;
	}

}
