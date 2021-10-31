/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.barcos.servicios;

import com.reto3.barcos.modelo.Barcos;
import com.reto3.barcos.repositorio.RepositorioBarcos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Soporte
 */
@Service
public class ServiciosBarcos {
    @Autowired
    private RepositorioBarcos metodosCrud;
    
    public List<Barcos> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Barcos> getBarcos(int idBarcos){
        return metodosCrud.getBarcos(idBarcos);
    }
    
    public Barcos save(Barcos barcos){
        if(barcos.getId()==null){
            return metodosCrud.save(barcos);
        }else{
            Optional<Barcos> evt=metodosCrud.getBarcos(barcos.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(barcos);
            }else{
                return barcos;
            }
        }
    }
    public Barcos update(Barcos barcos){
        if(barcos.getId()!=null){
            Optional<Barcos> e=metodosCrud.getBarcos(barcos.getId());
            if(!e.isEmpty()){
                if(barcos.getName()!=null){
                    e.get().setName(barcos.getName());
                }
                if(barcos.getBrand()!=null){
                    e.get().setBrand(barcos.getBrand());
                }
                if(barcos.getYear()!=null){
                    e.get().setYear(barcos.getYear());
                }
                if(barcos.getDescription()!=null){
                    e.get().setDescription(barcos.getDescription());
                }
                if(barcos.getCategory()!=null){
                    e.get().setCategory(barcos.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return barcos;
            }
        }else{
            return barcos;
        }
    }


    public boolean deleteBarcos(int barcosId) {
        Boolean aBoolean = getBarcos(barcosId).map(barcos -> {
            metodosCrud.delete(barcos);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
