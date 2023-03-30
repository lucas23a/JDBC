
package tienda.servicios;

import java.util.ArrayList;
import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

public class ProductoServicio {
    private ProductoDAO dao;
    Scanner leer = new Scanner (System.in);

    public ProductoServicio() {
        this.dao= new ProductoDAO();
    }   
    
    public void crearProducto() {
      try{
            Producto producto = new Producto();
            System.out.println("Agregue el nombre del producto");
            producto.setNombre(String.valueOf(leer.next()));
            System.out.println("Precio:");
            producto.setPrecio(leer.nextInt());
            System.out.println("Ingrese el codigo de Fabricante");
            producto.setCodigoFabricante(leer.nextInt());    
            dao.agregarProducto(producto); 
      }catch(Exception e){
          e.printStackTrace();
      }
    }
    
    public ArrayList<Producto> verNombresDeProductos() throws Exception{
        try {
            ArrayList<Producto> productos = dao.listarNombres();
            System.out.println("----Lista de nombres----");
            for (Producto aux : productos) {             
                System.out.println("Nombre: "+aux.getNombre());
            }
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
     public void listaDeNombresYPrecios() throws Exception{
         try {
              ArrayList<Producto> productos = dao.nombreYprecio();
              for (Producto aux : productos) {
                  System.out.println("Nombre:"+aux.getNombre()+" ,Precio:"+aux.getPrecio());
             }
         } catch (Exception e) {
             throw e;
         }
     }
    
     public void verPrecioEntre102y120() throws Exception{
         try {
             ArrayList<Producto> productos = dao.precioEntre102y120();
             for (Producto aux : productos) {
                 System.out.println("Nombre:"+aux.getNombre()+", Precio:"+aux.getPrecio());
             }
         } catch (Exception e) {
             throw e;
         }
     }
    
      public void verPortatiles () throws Exception{
          try {
               ArrayList<Producto> productos = dao.listarPortatiles();             
              for (Producto aux : productos) {
                  System.out.println("Codigo:"+aux.getCodigo()+", Nombre:"+aux.getNombre());
              }
          } catch (Exception e) {
              throw e;
          }
      }
      
      public Producto buscarPorCodigo(int codigo) throws Exception{
          try {
              if (codigo <=0) {
                  throw new Exception("Debe indicar un codigo valido");
              }
              Producto p = dao.BuscarProdPorCodigo(codigo);
              if (p== null) {
                  throw new Exception("No se encontro un producto con ese codigo");
              }
              return p;
              
          } catch (Exception e) {
              throw e;
          }
      }
     
      public void modificarProducto() throws Exception{
          try {
              Producto p = new Producto();
              System.out.println("Ingrese el codigo del producto");
              p.setCodigo(leer.nextInt());
              buscarPorCodigo(p.getCodigo());
              System.out.println("Ingrese el nombre nuevo");
              p.setNombre(String.valueOf(leer.next()));
              System.out.println("Ingrese el precio");
              p.setPrecio(leer.nextDouble());
              System.out.println("Ingrese codigo de fabricante");
              p.setCodigoFabricante(leer.nextInt());
              dao.modificarProducto(p);
              
          } catch (Exception e) {
                 throw e;
          }
       
          
      }
    
      public void BuscarMasBarato(){
          try{
          Producto p = dao.BuscarMasBarato();
          System.out.println("Nombre: "+p.getNombre()+", Precio:"+p.getPrecio());
          }catch(Exception e){
              e.printStackTrace();
          }
      }
      
      public void verTodosLosProductos() throws Exception{
           ArrayList<Producto> productos = dao.listarProductos();            
            for (Producto aux : productos) {             
                System.out.println(aux);
            }
      }
}
 
