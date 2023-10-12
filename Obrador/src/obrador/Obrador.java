
package obrador;

import java.sql.*;
import javax.swing.JOptionPane;


public class Obrador {

    
    public static void main(String[] args) {
        
        
        try {
            //cargo Driver de conexion
        Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("exito");
            
            //Establecer conexion 
            
            String URL="jdbc:mariadb://localhost:3306/obrador";
            String usuario= "root";
            String password= "";
           Connection con=DriverManager.getConnection(URL,usuario,password);
           
           //Dar de alta a 3 empleados. Insert 
           
           
        //String sql="INSERT INTO empleado (dni,apellido,nombre,acceso,estado)"
               // + "VALUES (39395372,'Ledesma','Franco',1,true)";
        
       //String sql= "INSERT INTO empleado (dni,apellido,nombre,acceso,estado)"
               // + "VALUES (39395253,'Felix','Damian',2,true)";
     
        //String sql="INSERT INTO empleado (dni,apellido,nombre,acceso,estado)"
               // + "VALUES (39394586,'Salinas','Ezequiel',3,true)";
               
         //String sql="INSERT INTO herramienta (nombre,descripcion,stock,estado)"
               // + "VALUES ('taladro','herramienta de perforacion',10,true)";
         
         //String sql="INSERT INTO herramienta (nombre,descripcion,stock,estado)"
              //  + "VALUES ('caladora','herramienta de corte',10,true)";
              
         // String sql="INSERT INTO herramienta (nombre,descripcion,stock,estado)"
              //  + "VALUES ('pistola plastica','herramienta de ensamblar',12,true)";
              
       // PreparedStatement ps=con.prepareStatement(sql);
       // ResultSet rs= ps.executeUpdate();   
        //int filas =ps.executeUpdate();
        
       //if (filas>0){}
        
        //JOptionPane.showMessageDialog(null,"herramienta agregada");
         
             
          
    
    //listamos herramientas con stock superior a 10 unidades
    String sql3="SELECT  herramienta.nombre, herramienta.stock"
            + " FROM herramienta "
            + "WHERE (stock>10)";
    PreparedStatement ps=con.prepareStatement(sql3);
    ResultSet rs=ps.executeQuery();
    while(rs.next()){
        String nombre=rs .getString("nombre");
        int stock=rs.getInt("stock");
        
        //mostrar datos en consola
        System.out.println("Producto con stock mayor a 10 unidades:");
        System.out.println("Herramienta: "+nombre);
        System.out.println("Stock actual: "+stock);
        System.out.println("*****************************");
               
    }
    
        
        //Dar de baja al primer empleado
        
        //String sql= "UPDATE empleado SET estado = false WHERE id_empleado = 2";
        // PreparedStatement ps=con.prepareStatement(sql);
         //int registro= ps.executeUpdate();
         
         
             //System.out.println("registro");
         
        
         
        
        } catch (ClassNotFoundException ex ) {
        
        JOptionPane.showMessageDialog(null,"error al cargar driver");
    }
        catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"error de conexion");
        int error=ex.getErrorCode();
        if(error ==1146){
        JOptionPane.showMessageDialog(null,"tabla inexistente");
        } else if (error ==1062) {
        JOptionPane.showMessageDialog(null,"dni duplicado");
        }else if (error ==1049){
        JOptionPane.showMessageDialog(null,"BD inexistente");
        } else {
        JOptionPane.showMessageDialog(null,"error SQL");
        }
        
        
        
}
    }
}
