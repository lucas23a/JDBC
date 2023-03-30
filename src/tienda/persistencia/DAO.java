
package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class DAO {
    protected Connection conexion;
    protected ResultSet resultado;
    protected Statement sentencia;
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String Driver= "com.mysql.jdbc.Driver";
    
    protected void conectarBase(){
        try {
            //Class.forName(Driver);
            String urlBaseDeDatos="jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion= DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
            
        } catch (Exception e) {
        }                            
        }
        
        protected  void desconectarBase() throws Exception{
            try {
                if (resultado != null) {
                    resultado.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
                if (sentencia != null) {
                    sentencia.close();
                }
            } catch (Exception e) {
                throw e;
            }
        }
        
        protected void insetarModificarEliminar(String sql) throws Exception{
            try {
                conectarBase();
                sentencia= conexion.createStatement();
                sentencia.executeUpdate(sql);
            } catch (SQLException e) {
                // conexion.rollback();
            /*  Descomentar la linea anterior si desean tener en cuenta el rollback.
                Correr el siguiente script en Workbench
            
                SET autocommit=1;
                COMMIT;
            
                **Sin rollback igual anda */
                throw e;
            } finally {
                desconectarBase();
            }
        }
        
        protected void consultarBase(String sql) throws Exception{
            try {
                conectarBase();
                sentencia= conexion.createStatement();
                resultado= sentencia.executeQuery(sql);
            } catch (Exception e) {
                throw e;
            }
        }
        
        
    }
    
    
    
    
    

