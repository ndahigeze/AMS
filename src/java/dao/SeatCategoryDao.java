/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.SeatCategory;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utilPac.HibernateUtil;

/**
 *
 * @author Ndahigeze
 */
public class SeatCategoryDao extends GenericDao<SeatCategory>{
     public static List<SeatCategory> viewByFlight(String pr){
      Session ses=HibernateUtil.getSessionFactory().openSession();
      Query que=ses.createQuery("FROM SeatCategory b WHERE b.flight= :v ");
      que.setString("v",pr );
      List<SeatCategory> list=que.list();
      ses.close();
      return list;
    }   
}
