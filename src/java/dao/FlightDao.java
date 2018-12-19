/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.AirLine;
import domain.Flight;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utilPac.HibernateUtil;

/**
 *
 * @author Ndahigeze
 */
public class FlightDao extends GenericDao<Flight>{
   public static List<Flight> viewByAiline(String pr){
      Session ses=HibernateUtil.getSessionFactory().openSession();
      Query que=ses.createQuery("FROM Flight b WHERE b.airLine= :v ");
      que.setString("v",pr );
      List<Flight> list=que.list();
      ses.close();
      return list;
    }   
}
