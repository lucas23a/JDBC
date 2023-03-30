/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;

/**
 *
 * @author Cristian
 */
public class FabricanteDAO extends DAO{
    
    public void guardarFabricante(Fabricante fabricante) throws Exception{
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante");
            }
            String sql = "INSERT INTO Fabricante (nombre)" 
                    + "VALUES ('" + fabricante.getNombre()+"' );";
                insetarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }finally {
            desconectarBase();
        }
    }
    
    public Collection<Fabricante> listarFabricantes() throws Exception{
        try {
            String sql= "SELECT * FROM Fabricante";
            consultarBase(sql);
            Fabricante fabricante= null;
            Collection<Fabricante> fabricantes= new ArrayList();
            while (resultado.next()) {
                fabricante= new Fabricante();
                fabricante.setNombre(resultado.getString(1));
                fabricantes.add(fabricante);
            }
            desconectarBase();
            return fabricantes;
            
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;          
        }
    }
}
