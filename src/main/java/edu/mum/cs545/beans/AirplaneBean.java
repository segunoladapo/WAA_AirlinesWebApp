package edu.mum.cs545.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.airline.model.Airplane;
import cs545.airline.service.AirplaneService;

@Named("airplaneBean")
@SessionScoped
public class AirplaneBean implements Serializable {

	private static final long serialVersionUID = 1L;
 
	@Inject
	private AirplaneService airplaneService;
	private Airplane airplane=new Airplane();
	private List<Airplane>airplanes=new ArrayList<>();

	public String create() {
		airplaneService.create(airplane);
		airplane=new Airplane();
		return "airplanes";
	}
	
	public String update(Airplane airplane) {
		System.out.println(airplane);
		airplaneService.create(airplane);
		return "airplanes";
	}
	
	public String delete(Airplane airplane) {
		airplaneService.delete(airplane);
		return "airlines";
	}

	public List<Airplane> getAirplanes() {
		airplanes=airplaneService.findAll();
		return airplanes;
	}

	
}
