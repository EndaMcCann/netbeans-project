/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import static com.mycompany.Service.TaxService.list;
import javax.ws.rs.core.Response;

/**
 *
 * @author Beast
 */
public class TaxPayer {
    private int id;
    private String firstName;
    private String lastName;
    private String city;
    private String pps;
    String result;

    public TaxPayer(int id, String firstName, String lastName, String city, String pps) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.pps = pps;
    }

    public TaxPayer(String firstname, String surname, String city, String pps) {
        //used to search the list with entries from the web form
       this.firstName = firstname;
       this.lastName = surname;
       this.city=city;
       this.pps=pps;
      for(int i=0; i<=list.size();i++){
          // if any of the entries on the form match return a string called result with the entries
      if(list.get(i).firstName.equals(firstname) || list.get(i).lastName.equals(surname)
          ||list.get(i).city.equals(city) || list.get(i).pps.equals(pps)){
      this.result += firstname +","+ surname+","+city+","+pps+"\n";
      }
          
      
      } //end for loop 
        

  
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPps(String pps) {
        this.pps = pps;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getPps() {
        return pps;
    }
    
    
    
    
}
