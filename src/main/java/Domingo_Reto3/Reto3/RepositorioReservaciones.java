/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domingo_Reto3.Reto3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioReservaciones {
       @Autowired
    private InterfaceReservaciones crud;

    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) crud.findAll();
    }
    public Optional<Reservaciones> getReservacion(int id){
        return crud.findById(id);
    }
    public Reservaciones save(Reservaciones reservation){
        return crud.save(reservation);
    }
    public void delete(Reservaciones reservation){
        crud.delete(reservation);
    }
    
    public List<Reservaciones> RepositorioStatus (String status){
	         return crud.findAllByStatus(status);
	     }
	     
	     public List<Reservaciones> RepositorioTiempo (Date a, Date b){
	         return crud.findAllByStartDateAfterAndStartDateBefore(a, b);
	     
	     }
	     
	     public List<Contador> getClientesRepo(){
	         List<Contador> datos = new ArrayList<>();
	         List<Object[]> report = crud.countTotalReservationsByClient();
	         for(int i=0; i<report.size(); i++){
	             datos.add(new Contador((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
	         }
	         return datos;
	     }
}
