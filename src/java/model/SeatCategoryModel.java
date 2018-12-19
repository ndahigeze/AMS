/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import config.Message;
import dao.SeatCategoryDao;
import domain.Flight;
import domain.SeatCategory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ndahigeze
 */
@ManagedBean
@SessionScoped
public class SeatCategoryModel {

    private SeatCategory seatCategory = new SeatCategory();
    private List<SeatCategory> seatCategorys = new SeatCategoryDao().findAll(SeatCategory.class);
    private List<SeatCategory> sc=new ArrayList();
    private String search = new String();
    private String proUp = new String();
    private String pid = new String();
    private SeatCategory pr = new SeatCategory();
    private String prod;
    private SeatCategory update = new SeatCategory();

    public List<SeatCategory> getSc() {
        return sc;
    }

    public void setSc(List<SeatCategory> sc) {
        this.sc = sc;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }

    public List<SeatCategory> getSeatCategorys() {
        return seatCategorys;
    }

    public void setSeatCategorys(List<SeatCategory> seatCategorys) {
        this.seatCategorys = seatCategorys;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getProUp() {
        return proUp;
    }

    public void setProUp(String proUp) {
        this.proUp = proUp;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public SeatCategory getPr() {
        return pr;
    }

    public void setPr(SeatCategory pr) {
        this.pr = pr;
    }

    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = prod;
    }

    public SeatCategory getUpdate() {
        return update;
    }

    public void setUpdate(SeatCategory update) {
        this.seatCategory = update;
    }

    public void create() {
        Flight f = new Flight();
        f.setFlightNo(pid);
        seatCategory.setFlight(f);
        String msg = new SeatCategoryDao().create(seatCategory);
        seatCategory = new SeatCategory();
        seatCategorys = new SeatCategoryDao().findAll(SeatCategory.class);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage("seat", new FacesMessage(msg));
    }

    @PostConstruct
    public void SeatCategory() {
         seatCategorys = new ArrayList();
        seatCategorys = new SeatCategoryDao().findAll(SeatCategory.class);
    }

    public void deleteSeatCategory(SeatCategory u) {
        try {
            String msg = new SeatCategoryDao().delete(u);
            update = new SeatCategory();
            seatCategorys = new SeatCategoryDao().findAll(SeatCategory.class);
            Message.succes(msg, "rrecord");
        } catch (Exception ex) {
            Message.failure(ex.getLocalizedMessage(), "rrecord");
        }
    }

    public void updateSeatCategory() {
        try {
            String msg = new SeatCategoryDao().update(update);
            update = new SeatCategory();
            seatCategorys = new SeatCategoryDao().findAll(SeatCategory.class);
            Message.succes(msg, "rrecord");
        } catch (Exception ex) {
            Message.failure(ex.getLocalizedMessage(), "rrecord");
        }
    }
    public void viewByFlight(){
      sc=SeatCategoryDao.viewByFlight(pid);
    }
}
