package colegio;
import java.sql.*;


public class Conexion_estudianteCRUD
{
    
 private final String servidor = "jbdc:mysql://127.0.0.1:3306/bd_colegio";
 private final int id = 00;
 private final String carnet_estudiante = "";
 private final String nom_estudiante = "";
 private final String ape_estudiante = "";
 private final int carnet = 001;
 private final String DriverConector = "com.mysql.jbdc.Driver";
 private static Connection conexion;
 
    public Conexion_estudianteCRUD(){
       
        try{
            Class.forName(DriverConector);     
            conexion=DriverManager.getConnection(servidor, carnet_estudiante, nom_estudiante);
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("");
        }
        
    } 

    
    public Connection getConnection (){
        return conexion;
    }
    
    public Void GuardadRegistro(String tabla, String CamposTabla, String Valorestabla){
      
        Conexion_estudianteCRUD conectar = new Conexion_estudianteCRUD();
        Connection cone = conectar.getConnection();
    
    
    try{
    
        String SqlQueryStmt = "INSERT" + tabla + "("+ CamposTabla+ ") VALUES ("+Valorestabla+");";
        
        Statement stmt;
         stmt = cone.createStatement();
         stmt.executeUpdate(SqlQueryStmt);
         stmt.close();
         cone.close();
         
             System.out.println("Registro guardado correctamente ");
          
  
    }catch (Exception e){
    
        System.out.println(e.getMessage());{
    }
    }
    }

 public void actualizarEliminarRegistro(String tabla, String valoresCamposNuevos, String condicion) {
     
      Conexion_estudianteCRUD conectar = new Conexion_estudianteCRUD();
Connection cone = conectar.getConnection ();
      try {
        Statement stmt;
        String sqlQueryStmt;
        if(valoresCamposNuevos.isEmpty()) {
             sqlQueryStmt = "DELETE FROM" + tabla + "WHERE" + condicion + ";" ;
         }
         else{
             sqlQueryStmt = "UPDATE" + tabla + "SET" + valoresCamposNuevos + "WHERE" + condicion + ";" ;
  }
   stmt = cone.createStatement();
   stmt.executeUpdate (sqlQueryStmt);
   stmt.close ();
   cone.close ();
}catch (SQLException ex)  {
          System.out.println( " Ha ocurrido el siguiente error:" + ex.getMessage () );
 }

}
 
public void  desplegarRegistros (String tablaBuscar, String camposBuscar, String condicionBuscar) throws SQLException{
       //Cargar la conexión
       Conexion_estudianteCRUD conectar = new Conexion_estudianteCRUD();
       Connection cone =conectar.getConnection ();
        try{
               Statement stmt;
               String sqlQueryStmt;
               if (condicionBuscar.equals ("") ) {
                      sqlQueryStmt = "SELECT" + camposBuscar + "FROM " + tablaBuscar + ";";
              }else{
              sqlQueryStmt= "SELECT " + camposBuscar + "FROM " + tablaBuscar + "WHERE" + condicionBuscar;
}
stmt = cone.createStatement () ;
stmt.executeQuery (sqlQueryStmt);
// Le indicamos que ejecute la consulta de la tabla y le pasamos por argumentos nuestra sentencia
try (ResultSet miResultSet = stmt.executeQuery (sqlQueryStmt)) {
       if    (miResultSet.next () ) { // Ubica el cursor en la primera fila de la tabla de resultado
             ResultSetMetaData metaData = miResultSet.getMetaData ();
              int numColumnas = metaData.getColumnCount (); //Obtiene el número de columnas de la consulta
             System.out.println("<<REGISTROS ALMACENADOS>>");
             System.out.println("");
                 for (int i = 1; i <= numColumnas; i++) {
                       //Muestra los títulos de las columnas y %-20s\t indica la separación entre columnas
                      System.out.println("%-20s\t"+ metaData.getColumnName(i));
                  }

           System.out.println("");
do  {
         for  (int i = 1; i <= numColumnas; i++)  {
               System.out.println("%-20s\t" + miResultSet.getObject(i));
        }
        System.out.println("");
 }   while  (miResultSet.next ()) ;
           System.out.println("");
} else {
           System.out.println("No se han encontrado registros");
}
miResultSet.close () ; //Cerrar el ResutSet
}finally{
      // Cerrar el Statement y la Conexión; se cierran en orden inverso de como           se han abierto
      stmt.close ();
      cone.close ();
}
}catch (SQLException ex ) {
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage ());
        }
    }
}

     



 
  

    

    


