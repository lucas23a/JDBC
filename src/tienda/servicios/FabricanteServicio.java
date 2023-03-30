/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.servicios;

import java.util.Scanner;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

/**
 *
 * @author Cristian
 */
public class FabricanteServicio {
Scanner leer = new Scanner (System.in);
    private FabricanteDAO dao;
    
    public FabricanteServicio() {
        this.dao = new FabricanteDAO();
    }
    
    public void crearFabricante() throws Exception {
        // Validar
       /* try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }*/

            //Crear Fabricante
            Fabricante fabricante = new Fabricante();
            System.out.println("Ingrese el nombre del fabricante");
            fabricante.setNombre(String.valueOf(leer.next()));
            dao.guardarFabricante(fabricante);
       /* } catch (Exception e) {
            throw e;
        */}
    }
    

