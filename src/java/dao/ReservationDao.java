/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Reservation;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utilPac.HibernateUtil;

/**
 *
 * @author Ndahigeze
 */
public class ReservationDao extends GenericDao<Reservation>{
    public static List<Reservation> viewByCustomer(String pr){
      Session ses=HibernateUtil.getSessionFactory().openSession();
      Query que=ses.createQuery("FROM Reservation b WHERE b.customer= :v ");
      que.setString("v",pr );
      List<Reservation> list=que.list();
      ses.close();
      return list;
    }   
     public static List<Reservation> viewByFlight(String pr){
      Session ses=HibernateUtil.getSessionFactory().openSession();
      Query que=ses.createQuery("FROM Reservation b WHERE b.flight= :v ");
      que.setString("v",pr );
      List<Reservation> list=que.list();
      ses.close();
      return list;
    }   
       public static List<Reservation> viewBySeatCategory(String pr){
      Session ses=HibernateUtil.getSessionFactory().openSession();
      Query que=ses.createQuery("FROM Reservation b WHERE b.seatCategory= :v ");
      que.setString("v",pr );
      List<Reservation> list=que.list();
      ses.close();
      return list;
    }   
}
