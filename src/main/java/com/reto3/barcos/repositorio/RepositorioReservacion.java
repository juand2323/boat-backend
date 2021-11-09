/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.barcos.repositorio;

import java.util.ArrayList;
import java.util.Date;
import com.reto3.barcos.interfaces.interfaceReservacion;
import com.reto3.barcos.modelo.Reservacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.reto3.barcos.modelo.Cliente;
import com.reto3.barcos.reportes.ContadorClientes;


/**
 *
 * @author Soporte
 */
@Repository
public class RepositorioReservacion {
    @Autowired
    private interfaceReservacion crud4;
    
    public List<Reservacion> getAll(){
        return (List<Reservacion>) crud4.findAll();
    }
    public Optional<Reservacion> getReservation(int id){
        return crud4.findById(id);
    }
    public Reservacion save(Reservacion reservacion){
        return crud4.save(reservacion);
    }
     public void delete(Reservacion reservacion){
        crud4.delete(reservacion);
    }

    public List<Reservacion> ReservacionStatusRepositorio (String status){
        return crud4.findAllByStatus(status);
    }
    
    public List<Reservacion> ReservacionTiempoRepositorio (Date a, Date b){
        return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
    
    }
    
    public List<ContadorClientes> getClientesRepositorio(){
        List<ContadorClientes> res = new ArrayList<>();
        List<Object[]> report = crud4.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){
            res.add(new ContadorClientes((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
        }
        return res;
    }

}
