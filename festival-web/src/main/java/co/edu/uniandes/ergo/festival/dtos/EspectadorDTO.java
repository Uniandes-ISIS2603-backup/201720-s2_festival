/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.ergo.festival.dtos;

import co.edu.uniandes.ergo.festival.entities.EspectadorEntity;

/**
 *
 * @author dj.bautista10
 */
public class EspectadorDTO {
    
    private Long id;
    private String nombre;
    private String direccion;
    
    public EspectadorDTO(){
        
    }
    
    public EspectadorDTO(EspectadorEntity espec){
        this.id = espec.getId();
        this.nombre = espec.getName();
        this.direccion = espec.getDireccion();
    }
    
    public Long getId(){
        return id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String direccion(){
        return direccion;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public EspectadorEntity toEntity(){
        EspectadorEntity entEsp = new EspectadorEntity();
        
        entEsp.setId(this.id);
        entEsp.setName(this.nombre);
        entEsp.setDireccion(this.direccion);
        
        return entEsp;
    }
}