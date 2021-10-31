/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.barcos.repositorio;

import com.reto3.barcos.interfaces.interfaceBarcos;
import com.reto3.barcos.modelo.Barcos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Soporte
 */
@Repository
public class RepositorioBarcos {
    @Autowired
    private interfaceBarcos crud;
    

    public List<Barcos> getAll(){
        return (List<Barcos>) crud.findAll();       
    }
    
    public Optional <Barcos> getBarcos(int id){
        return crud.findById(id);
    }
    
    public Barcos save(Barcos barcos){
        return crud.save(barcos);
    }
      public void delete(Barcos barcos){
        crud.delete(barcos);
    }
}
