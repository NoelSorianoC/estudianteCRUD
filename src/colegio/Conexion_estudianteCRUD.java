package colegio;
import java.sql.Connection;


public class Conexion_estudianteCRUD {
    
 private final String servidor = "jbdc:mysql://127.0.0.1:3306/bd_colegio";
 private final int id = 00;
 private final String carnet_estudiante = "";
 private final String nom_estudiante = "Carlos";
 private final String ape_estudiante = "Campos";
 private final int carnet = 001;
 private final String DriverConector = "com.mysql.jbdc.Driver";
 private static Connection conexion;
 
    public Conexion_estudianteCRUD(){
       
        try{
            class.forName(DriverConector)
                    
            conexion= DriverMannager.getConecction(Servidor, nom_estudiante);
        }catch (ClassNoFoundException | SQLException e){
            System.out.println("Conexion fallida! Error!: "+ e.getMessage());
        }
        
    }   
    
    public Connection getConnection (){
        return conexion;
    }
    
    public Void GuardadRegistro(Stringtabla, StringCamposTabla, StringValorestabla){
        Conexion_estudianteCRUD conectar = New Conexion_estudianteCRUD;
        conection cone = conectar.getConnection;
    }
    
    try{
    
        String SqlQueryStmt = "INSERT" + tabla + "("+ CamposTabla+ ") VALUES ("+Valorestabla+");";
        
        Statement stmt;
        
         stmt = cone.CreateStatement();
         stmt = execute.Update(SqlQueryStmt);
         stmt.close();
         cone.close();
         
         {     System.out.println("Registro guardado correctamente ");
          
}  
    }catch (Exception e){
    
        System.out.println("e.getMessage()");
    
    
 }