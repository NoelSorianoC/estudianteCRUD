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
    
        System.out.println(e.getMessage());
    }

}

 public void actualizarEliminarRegistro(string tabla, string valoresCamposNuevos, string condicion) {
     
      Conexion_estudianteCRUD conectar = new conexion_estudianteCRUD ();
Connection cone = conectar.getConnection ();
      try {
        statement stmt;
        string sqlQueryStmt;
        if(valoresCamposNuevos.isEmpty()) {
             sqlQueryStmt = "DELETE FROM" + tabla + "WHERE" + condición + ";" ;
         }
         else{
             sqlQueryStmt = "UPDATE" + tabla + "SET" + valoresCaposNuevos + "WHERE" + condición + ";" ;
  }
   stmt = cone.createstatement ();
   stmt.executeUpdate (sqlQueryStmt);
   stmt.close ();
   cone.close ();
}catch (SQLException ex)  {
      System.out.printin ( " Ha ocurrido el siguiente error:" + ex.getMessage () );
 }

}


 
  

    

    


