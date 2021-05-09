
package colegio;


import java.sql.SQLException;
import java.util.Scanner;


public class menu_principal {
    
      public static void main (String[] arg) throws SQLException{
      
    desplegarmenu();
  }

 
    public static void desplegarmenu(){
        Scanner New = null;
        Scanner opcionSeleccionada = New Scanner (System.in);
        String Opcionmenu = null;
        
        System.out.println("************************************");
        System.out.println("!       CRUD CON JAVA "              );
        System.out.println("************************************");
        System.out.println("  Opciones:                         ");
        System.out.println("      1: Crear Registros            ");
        System.out.println("      2: Consultar Registros        ");
        System.out.println("      3: Actualizar Registros       ");
        System.out.println("      4: Eliminar Registros         ");
        System.out.println("      5: Salir                      ");
        System.out.println("************************************");
        System.out.println("! Seleccionar Opcion"                ); 
        String opcionmenu = opcionSeleccionada.next();
        
        switch (Opcionmenu){
            
            case "1":
                //Create create = new Create();
            break;
                
                
            case "2":
                // Read read  = new Read();
            break;
                
            case "3":
               // Actualizar actualizar = new Actualizar ();
            break;
            
            case "4":
               // Delete delete = new Delete ();
            break;
                
                
        }
    }

   
}

    
    
