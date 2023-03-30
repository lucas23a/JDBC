
package tienda.persistencia;

import java.util.ArrayList;
import tienda.entidades.Producto;


public class ProductoDAO extends DAO{
    
    public void agregarProducto(Producto producto) throws Exception{
        try {
            if (producto== null) {
                throw new Exception("Debe indicar el producto");                
            }
            String sql= "INSERT INTO Producto (nombre, precio, codigo_fabricante)"
                    + "VALUES ('" + producto.getNombre() + "', '" + producto.getPrecio() 
                    + "', '"+ producto.getCodigoFabricante()+ "' );";
            insetarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
            
    public ArrayList<Producto> listarNombres() throws Exception{
        try {
            String sql="SELECT nombre FROM producto;";
            consultarBase(sql);
            Producto producto= null;
            ArrayList lista = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                lista.add(producto);
            }
            desconectarBase();
            return lista;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
            
     public ArrayList<Producto> nombreYprecio() throws Exception{
         try {
            String sql = "SELECT nombre, precio FROM producto;";
             consultarBase(sql);
             Producto producto= null;
             ArrayList lista = new ArrayList();
             while (resultado.next()) {                 
                 producto= new Producto();
                 producto.setNombre(resultado.getString(1));
                 producto.setPrecio(resultado.getDouble(2));
                 lista.add(producto);
             }
             desconectarBase();
             return lista;
         } catch (Exception e) {
             throw e;
         }
     }
     
    public ArrayList<Producto> precioEntre102y120() throws Exception{
        try {
            String sql= "SELECT * FROM producto WHERE precio BETWEEN 102 AND 120;";
            consultarBase(sql);
            Producto producto= null;
            ArrayList <Producto> lista = new ArrayList();
            while (resultado.next()) {                
                producto= new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                lista.add(producto);
            }
            desconectarBase();
            return lista;
        } catch (Exception e) {
            throw e;
        }
    }
     
     public ArrayList<Producto> listarPortatiles() throws Exception{
         try {
             String sql = "SELECT * FROM producto WHERE nombre LIKE '%Portátil%';";
             consultarBase(sql);
             Producto producto = null;
             ArrayList <Producto> lista = new ArrayList();
             while (resultado.next()) {                
                producto= new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                lista.add(producto);
            }
            desconectarBase();
            return lista;
             
         } catch (Exception e) {
             throw e;
         }
     }
    
     public void modificarProducto (Producto p) throws Exception{
         try {
             if (p== null) {
                 throw new Exception("Debe indicar un producto");
             }
             String sql = "UPDATE producto SET "
                    + " nombre = '" + p.getNombre() + "' , precio = '" + p.getPrecio() +
                     "' , codigo_fabricante = " + p.getCodigoFabricante()+
                    " WHERE codigo = '" + p.getCodigo() + "';";
             insetarModificarEliminar(sql);
         } catch (Exception e) {
             throw e;
         }finally{
             desconectarBase();
         }
     }
     
    public Producto BuscarProdPorCodigo(int codigo) throws Exception{
         try {
              String sql = "SELECT * FROM producto WHERE codigo = " + codigo + "";
              consultarBase(sql);
              Producto producto = null;
              while (resultado.next()) {                 
                 producto= new Producto();
                 producto.setCodigo(resultado.getInt(1));
                 producto.setNombre(resultado.getString(2));
                 producto.setPrecio(resultado.getDouble(3));
                 producto.setCodigoFabricante(resultado.getInt(4));
             }
              desconectarBase();
              return producto;
         } catch (Exception e) {
             throw e;
         }
     }
     
    public Producto BuscarMasBarato() throws Exception{
               try {

            String sql = "SELECT nombre, precio from producto ORDER BY precio LIMIT 1;";

            consultarBase(sql);

            Producto producto = null;

            while (resultado.next()) {

                producto = new Producto();

                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
            }
            return producto;
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public ArrayList<Producto> listarProductos() throws Exception{
        try {
            String sql="SELECT * FROM producto;";
            consultarBase(sql);
            Producto producto= null;
            ArrayList lista = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                lista.add(producto);
            }
            desconectarBase();
            return lista;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    
}
