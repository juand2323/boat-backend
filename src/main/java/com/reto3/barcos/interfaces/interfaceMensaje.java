/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto3.barcos.interfaces;

import com.reto3.barcos.modelo.Mensaje;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Soporte
 */
public interface interfaceMensaje extends CrudRepository<Mensaje,Integer> {
    
}
