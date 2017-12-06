/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.mycompany.model.TaxPayer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beast
 */
public class TaxService {
    //create the taxpayer list
    public static List<TaxPayer> list = new ArrayList<>();
    //flag used to create the data when it is run for the first time
    public static boolean init = true;
    
    public TaxService(){
        // if data hasnt been created then do so
    if (init){
    
            TaxPayer t1 = new TaxPayer(1,"Noel", "Pecci", "Dublin","12345678");
            TaxPayer t2 = new TaxPayer(2,"Yamar", "Da Silva", "Galway","11223344");
            TaxPayer t3 = new TaxPayer(3,"John", "Smith", "Cork","12823456");
            TaxPayer t4 = new TaxPayer(4,"Nial", "Horan", "Limerick","12312312");
            TaxPayer t5 = new TaxPayer(5,"Joe", "Pesci", "Clare","45678123");
       
            list.add(t1);
            list.add(t2);
            list.add(t3);
            list.add(t4);
            list.add(t5);
            //data now created. set flag so not to repeat.
            init = false;
    
    }
    
    }// end of taxService()
    
    public List<TaxPayer> getAllTaxPayers(){
        //return all tax payers
    return list;
    }

    public TaxPayer getTaxPayer(int id) {
        //return taxpayer with this id-1 (as arrays start at 0 not 1)
      return list.get(id-1);
    }

    public TaxPayer createTaxPayer(TaxPayer taxPayer) {
        //create a taxpayer
        taxPayer.setId(list.size()+1);
        list.add(taxPayer);
        System.out.println("201 - Tax Payer created with id:" + String.valueOf(taxPayer.getId()));
        return taxPayer;
    }
    
    
    
}
