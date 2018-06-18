package edu.mum.cs545.ws;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

@Named
@Path("hello")
public class HelloRest {

	@Inject
	private AirlineService airlineService;

	@GET
	public String helloWorld(@DefaultValue("Gorgeous") @QueryParam("name") String name) {
		return "Hello " + name + "!";
	}

	@Path("airline")
	@GET
	public String getAirlineTest() {
	    System.out.println("Starting to add a new Airline to the DB");
		String result = "Nil!";
        Airline airline = new Airline();
        airline.setName("HelloWorldAirline");
		airlineService.delete(airline);
	//	airlineService.create(airline);
		airline = airlineService.findByName("HelloWorldAirline");
		if (airline != null) {
			result = "This is an airline: " + airline.getName() +  " " + airline.getId();
		}
		return result;
	}

}
