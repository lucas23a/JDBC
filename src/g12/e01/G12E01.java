/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package g12.e01;

import java.util.Scanner;

import tienda.servicios.FabricanteServicio;
import tienda.servicios.MenuServicio;

import tienda.servicios.ProductoServicio;



public class G12E01 {

    public static void main(String[] args) throws Exception  {
     FabricanteServicio fabService = new FabricanteServicio();
    ProductoServicio prodService = new ProductoServicio();
    Scanner leer = new Scanner (System.in);

  
       // MenuServicio menu = new MenuServicio();
        //menu.verMenu();
    
int opc;
        
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
      
        
        switch (opc) {
            case 1:
                    prodService.verNombresDeProductos();
                break;
            case 2:
                prodService.listaDeNombresYPrecios();
                break;
            case 3: 
                prodService.verPrecioEntre102y120();
                break;
            case 4:
                prodService.verPortatiles();
            break;
            case 5: 
                prodService.BuscarMasBarato();
               break;
            case 6:
                prodService.crearProducto();
                break;
            case 7:
                fabService.crearFabricante();
                break;
            case 8:
                prodService.modificarProducto();
                break;
            case 9:
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
        } while (opc<10);
    }
    }

