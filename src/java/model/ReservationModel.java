/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Message;
import dao.ReservationDao;
import dao.FlightDao;
import dao.SeatCategoryDao;
import domain.Reservation;
import domain.AirLine;
import domain.Flight;
import domain.SeatCategory;
import domain.Users;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ndahigeze
 */
@ManagedBean
@SessionScoped
public class ReservationModel {

    private Reservation booking = new Reservation();
    private Reservation update = new Reservation();
    private List<Reservation> bookings = new ReservationDao().findAll(Reservation.class);
    private String dist;
    private String search = new String();
    public String getSearch() {
        return search;
    }

    public SeatCategory getS() {
        return s;
    }

    public void setS(SeatCategory s) {
        this.s = s;
    }
 
    private SeatCategory s;
      public void sets(SeatCategory seat){
       s=seat;
      }
    public void setSearch(String search) {
        this.search = search;
    }

    public Reservation getBooking() {
        return booking;
    }

    public void setBooking(Reservation booking) {
        this.booking = booking;
    }

    public Reservation getUpdate() {
        return update;
    }

    public void setUpdate(Reservation update) {
        this.update = update;
    }

    public List<Reservation> getBookings() {
        return bookings;
    }

    public void setBookings(List<Reservation> bookings) {
        this.bookings = bookings;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public void recordBooking() {
       
      System.out.println(s.getId()+"hello there");
        Users u = searchUser();
        try {
            if (checkNumberOfSeat(s.getId(), booking.getNumberofSeat())) {
                booking.setSeatCategory(s);
                booking.setBookingDate(new Date());
                booking.setCustomer(u);
                Double p=calculateAmoutn(s.getId(), booking.getNumberofSeat());
                reduceSeat(booking.getNumberofSeat(), s.getId());
                booking.setTotal(calculateAmoutn(s.getId(), booking.getNumberofSeat()));
                String msg = new ReservationDao().create(booking);
                booking = new Reservation();
                bookings = new ReservationDao().findAll(Reservation.class);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage("recorded", new FacesMessage(msg+" Price: "+p+" RWF"));
            } else {
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage("recorded", new FacesMessage("Seats Number you choosed is not Available"));
            }

        } catch (Exception ex) {
             FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage("recorded", new FacesMessage(ex.getMessage()));
        }

    }

    public void reduceSeat(int no, String id) {
        SeatCategory r = new SeatCategoryDao().findOne(SeatCategory.class, id);
        SeatCategory up=new SeatCategory();
        up.setFlight(r.getFlight());
        up.setId(r.getId());
        up.setPrice(r.getPrice());
        up.setType(r.getType());
        up.setSeatNumbers(r.getSeatNumbers() - no);
        new SeatCategoryDao().update(up);
    }

    public double calculateAmoutn(String id, int no) {
        SeatCategory r = new SeatCategoryDao().findOne(SeatCategory.class, id);
        return r.getPrice() * no;
    }

    public boolean checkNumberOfSeat(String id, int no) {
        SeatCategory r = new SeatCategoryDao().findOne(SeatCategory.class, id);
        return r.getSeatNumbers() > no;
    }

    public void updateBooking() {
        try {
            String msg = new ReservationDao().update(update);
            update = new Reservation();
            bookings = new ReservationDao().findAll(Reservation.class);
            Message.succes(msg, "rrecord");
        } catch (Exception ex) {
            Message.failure(ex.getLocalizedMessage(), "rrecord");
        }

    }

    public void find(String s) {
        search = s;
        view();
    }

    @PostConstruct
    public void view() {
         bookings = new ArrayList();
        bookings = new ReservationDao().findAll(Reservation.class);
    }

    public void setDetail(final Reservation booking) {
        this.update = booking;
    }

    public void deleteBooking(Reservation u) {
        try {
            String msg = new ReservationDao().delete(u);
            update = new Reservation();
            bookings = new ReservationDao().findAll(Reservation.class);
            Message.succes(msg, "rrecord");
        } catch (Exception ex) {
            Message.failure(ex.getLocalizedMessage(), "rrecord");
        }
    }

    public void setupdate(Reservation u) {
        booking = u;
    }

    public Users searchUser() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        Users user = (Users) session.getAttribute("session");
        return user;
    }
}
