/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Resources;

/**
 *
 * @author Thomas McCann
 */

import com.mycompany.Service.TaxService;
import com.mycompany.model.TaxPayer;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
 

//if no paramater is specified then return all the taxpayers
@Path("/taxpayers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class TaxResources {
        
  TaxService TaxService = new TaxService();
  
  @GET
  public List<TaxPayer> getTaxPayers(){
      // gets all the tax payers
  return TaxService.getAllTaxPayers();
  }
  
  @POST
  public TaxPayer postTaxPayer(TaxPayer tp){
      //creates a new tax payer
  return TaxService.createTaxPayer(tp);
  }
  
        
  @GET
  @Path("/{taxPayerId}")
  public TaxPayer getTaxPayer(@PathParam("taxPayerId") int id){
      //return taxpayer with this id 
  return TaxService.getTaxPayer(id);
  
  }

      @GET
    @Path("/payment")
      @Produces(MediaType.APPLICATION_JSON)
    public Response getPayment(@Context UriInfo info) {
        String city =
                info.getQueryParameters().getFirst("city");
        String pps =
                info.getQueryParameters().getFirst("pps");
        String firstname =
                info.getQueryParameters().getFirst("firstname");
        String surname =
               info.getQueryParameters().getFirst("surname");     
        
        
        String output = firstname + "," + surname + "," + city + "," + pps;
        
        TaxPayer taxPayer = new TaxPayer(firstname,surname,city,pps);
       
        
        return Response.status(200).entity(taxPayer).build();
    }
  
  
}// end class TaxResources
