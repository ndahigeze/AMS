/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Message;
import dao.FlightDao;
import domain.AirLine;
import domain.Flight;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ndahigeze
 */
@ManagedBean
@SessionScoped
public class FlightModel {
 private Flight flight=new Flight();
 private Flight update=new Flight();
 private List<Flight> flights=new ArrayList();
 private String dist;
 private String search=new String();
 private List<Flight> byp=new ArrayList();
 private String h;

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }
 
    public List<Flight> getByp() {
        return byp;
    }

    public void setByp(List<Flight> byp) {
        this.byp = byp;
    }
 
    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
 
   

    public Flight getUpdate() {
        return update;
    }

    public void setUpdate(Flight update) {
        this.update = update;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }
 
    public void recordFlight(){
        try{
            AirLine d=new AirLine();
            d.setName(dist);
            flight.setAirLine(d);
             String msg=new FlightDao().create(flight);
            flight=new Flight();
            flights=new FlightDao().findAll(Flight.class);
             Message.succes(msg, "rrecord");
        }catch(Exception ex){
              Message.failure(ex.getLocalizedMessage(), "rrecord");
        }
        
    }
     
     public void updateFlight(){
        try{
             String msg=new FlightDao().update(update);
            update=new Flight();
            flights=new FlightDao().findAll(Flight.class);
             Message.succes(msg, "rrecord");
        }catch(Exception ex){
             Message.failure(ex.getLocalizedMessage(), "rrecord");
        }
        
    }
     
     public void find(String s){
         search=s;
         view();
     }
     @PostConstruct
     public void view(){
         flights=new FlightDao().findAll(Flight.class);
    
     }
    
    public void setDetail(final Flight Flight){
      this.update=Flight; 
    }
    
    public void deleteFlight(Flight u){
      try{
         String msg=new FlightDao().delete(u);
         update=new Flight();
         flights=new FlightDao().findAll(Flight.class);
          Message.succes(msg, "rrecord");
      }catch(Exception ex){
         Message.failure(ex.getLocalizedMessage(), "rrecord");
      }
    }
    public void setupdate(Flight u){
      flight=u;
    }
    public void byAiline(){
      byp=FlightDao.viewByAiline(dist);
    }
   
}
