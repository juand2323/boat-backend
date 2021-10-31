/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.barcos.web;

import com.reto3.barcos.modelo.Barcos;
import com.reto3.barcos.servicios.ServiciosBarcos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Soporte
 */
@RestController
@RequestMapping("/api/Boat")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class WebBarcos {
    @GetMapping("/holaMundo")
    public String saludad(){
    return "Hola Mundo Tutoria";
    }

    
    @Autowired
    private ServiciosBarcos servicio;
    @GetMapping("all")
    public List <Barcos> getBarcos(){
        return servicio.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Barcos> getBarcos(@PathVariable("id") int idBarcos) {
        return servicio.getBarcos(idBarcos);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Barcos save(@RequestBody Barcos barcos) {
        return servicio.save(barcos);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Barcos update(@RequestBody Barcos barcos) {
        return servicio.update(barcos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int barcosId) {
        return servicio.deleteBarcos(barcosId);
    }
    
}
