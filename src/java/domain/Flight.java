/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Ndahigeze
 */
@Entity
public class Flight implements Serializable {

    @OneToMany(mappedBy = "flight")
    private List<SeatCategory> seatCategorys;
  @Id
  private String flightNo;
    @ManyToOne
  private AirLine airLine;
  private String source;
  private String destination;
  @Temporal(javax.persistence.TemporalType.DATE)
  private Date depDate;
  private Date depTime;
  private String depStatus;

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public AirLine getAirLine() {
        return airLine;
    }

    public void setAirLine(AirLine airLine) {
        this.airLine = airLine;
    }

    public String getSource() {
        return source;
    }

    public List<SeatCategory> getSeatCategorys() {
        return seatCategorys;
    }

    public void setSeatCategorys(List<SeatCategory> seatCategorys) {
        this.seatCategorys = seatCategorys;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepDate() {
        return depDate;
    }

    public void setDepDate(Date depDate) {
        this.depDate = depDate;
    }

    public Date getDepTime() {
        return depTime;
    }

    public void setDepTime(Date depTime) {
        this.depTime = depTime;
    }

    

    public String getDepStatus() {
        return depStatus;
    }

    public void setDepStatus(String depStatus) {
        this.depStatus = depStatus;
    }
  
  @Override
    public String toString(){
     return flightNo;
    }
  
}
