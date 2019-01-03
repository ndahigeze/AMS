/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Ndahigeze
 */
@Entity
public class AirLine implements Serializable {

    @OneToMany(mappedBy = "airLine")
    private List<Flight> rooms;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Flight> getRooms() {
        return rooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRooms(List<Flight> rooms) {
        this.rooms = rooms;
    }
 
    @Override
    public String toString(){
      return id+"";
    }
}
