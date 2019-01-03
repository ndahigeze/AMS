/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Message;
import dao.AirLineDao;
import domain.AirLine;
import domain.Users;
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
public class AiLineModel {
 private AirLine airLine=new AirLine();
 private AirLine update=new AirLine();
 private List<AirLine> airLines=new ArrayList();
 private String dist;
 private String search=new String();

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
 
  

    public AirLine getUpdate() {
        return update;
    }

    public void setUpdate(AirLine update) {
        this.update = update;
    }

    public AirLine getAirLine() {
        return airLine;
    }

    public void setAirLine(AirLine airLine) {
        this.airLine = airLine;
    }

    public List<AirLine> getAirLines() {
        return airLines;
    }

    public void setAirLines(List<AirLine> airLines) {
        this.airLines = airLines;
    }

  

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }
 
    public void recordAirLine(){
        try{
             String msg=new AirLineDao().create(airLine);
            airLine=new AirLine();
            airLines=new AirLineDao().findAll(AirLine.class);
             Message.succes(msg, "crecod");
        }catch(Exception ex){
              Message.failure(ex.getLocalizedMessage(), "crecod");
        }
        
    }
    
     public void updateAirLine(){
        try{
             String msg=new AirLineDao().update(update);
            update=new AirLine();
            airLines=new AirLineDao().findAll(AirLine.class);
             Message.succes(msg, "");
        }catch(Exception ex){
             Message.failure(ex.getLocalizedMessage(), "");
        }
        
    }
      @PostConstruct
     public void viewHotle(){
         airLines=new AirLineDao().findAll(AirLine.class);
     }
    
    public void setDetail(final AirLine AirLine){
      this.update=AirLine; 
    }
    
    public void deleteAirLine(AirLine u){
      try{
         String msg=new AirLineDao().delete(u);
         update=new AirLine();
         airLines=new AirLineDao().findAll(AirLine.class);
          Message.succes(msg, "");
      }catch(Exception ex){
         Message.failure(ex.getLocalizedMessage(), "");
      }
    }
    public void setupdate(AirLine u){
      airLine=u;
    }
    
}
