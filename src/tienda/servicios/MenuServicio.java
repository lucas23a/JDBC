/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.servicios;

import java.util.Scanner;

/**
 *
 * @author Cristian
 */
public class MenuServicio {
    FabricanteServicio FabService;
    ProductoServicio ProdService;
    Scanner leer = new Scanner (System.in);

    public MenuServicio() {
        this.FabService= new FabricanteServicio();
        this.ProdService= new ProductoServicio();
    }

    public void verMenu(){
        int opc;
        try{
        do {                    
        System.out.println("Menu:");
        System.out.println("1-Lista el nombre de todos los productos que hay en la tabla producto.");
        System.out.println("2-Lista los nombres y los precios de todos los productos de la tabla producto.");
        System.out.println("3-Listar aquellos productos que su precio esté entre 120 y 202.");
        System.out.println("4-Buscar y listar todos los Portátiles de la tabla producto.");
        System.out.println("5-Listar el nombre y el precio del producto más barato.");
        System.out.println("6-Ingresar un producto a la base de datos.");
        System.out.println("7-Ingresar un fabricante a la base de datos");
        System.out.println("8-Editar un producto con datos a elección.");
        System.out.println("9-Salir");
     opc= leer.nextInt();
        } while (opc<10);
        
        switch (opc) {
            case 1:
                    ProdService.verNombresDeProductos();
                break;
            case 2:
                ProdService.listaDeNombresYPrecios();
                break;
            case 3: 
                ProdService.verPrecioEntre102y120();
                break;
            case 4:
                ProdService.verPortatiles();
            break;
            case 5: 
                ProdService.BuscarMasBarato();
               break;
            case 6:
                ProdService.crearProducto();
                break;
            case 7:
                FabService.crearFabricante();
                break;
            case 8:
                ProdService.modificarProducto();
                break;
            case 9:
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    
}
