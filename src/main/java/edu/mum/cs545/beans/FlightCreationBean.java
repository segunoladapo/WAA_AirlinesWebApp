package edu.mum.cs545.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirplaneService;
import cs545.airline.service.AirportService;
import cs545.airline.service.FlightService;

@Named("flightCreationBean")
@FlowScoped("flightCreation")
public class FlightCreationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private AirlineService airlineService;
	@Inject
	private AirportService airportService;
	@Inject
	private AirplaneService airplaneService;
	@Inject
	private FlightService flightService;

	private Flight flight=new Flight();
	private String departureDate;
	private String arrivalDate;
	private String airlineName;
	private String origin;
	private String destination;
	private String airplaneName;
	
	public String getReturnValue() {
		flight.setOrigin(airportService.findByCode(origin));
		flight.setDestination(airportService.findByCode(destination));
		flight.setAirline(airlineService.findByName(airlineName));
		String airplaneParts[]=airplaneName.split("/");
		flight.setAirplane(airplaneService.findBySrlnr(airplaneParts[0]));
		String departureTimeAndDate[]=departureDate.split(" ");
		flight.setDepartureDate(departureTimeAndDate[0]);
		System.out.println(">>>>>>>>>>>>>>"+departureTimeAndDate[0]+"   "+departureTimeAndDate[1]);
		String arrivalTimeAndDate[]=arrivalDate.split(" ");
		flight.setArrivalDate(arrivalTimeAndDate[0]);
		flight.setArrivalTime(arrivalTimeAndDate[1]);
		flightService.create(flight);
		return "/flightsList";
	}

	
	public List<Airline> getAirlines() {
		return airlineService.findAll();
	}

	public List<Airport> getAirports() {
		return airportService.findAll();
	}

	public List<Airplane> getAirplanes() {
		return airplaneService.findAll();
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getAirplaneName() {
		return airplaneName;
	}

	public void setAirplaneName(String airplaneName) {
		this.airplaneName = airplaneName;
	}

	
}
