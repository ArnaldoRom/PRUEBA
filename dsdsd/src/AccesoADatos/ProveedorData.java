package AccesoADatos;

import Dominio.Proveedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProveedorData {

    private Proveedor proveedor = null;
    private Connection conexion = null;

    public ProveedorData() {
        conexion = Conexion.conectar();
    }

    
    
       //        METODO AGREGAR PROVEEDOR 
    
    public void agregarProveedor(Proveedor prove) {
        String sql = "INSERT INTO proveedor (razonSocial, domicilio, telefono, estado) VALUES (?, ?, ?, ?)";
        proveedor = new Proveedor();
        try {

            PreparedStatement ps = conexion.prepareStatement(sql);

            if (proveedor != null) {
                ps.setString(1, prove.getRazonSocial());
                ps.setString(2, prove.getDomicilio());
                ps.setString(3, prove.getTelefono());
                ps.setBoolean(4, prove.getEstado());

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "EL proveedor se cargo correctamente", "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El proveedor ingresado es ERRONEO", "ERROR", 0);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la Tabla Proveedor.", "Error de Conexion.", JOptionPane.ERROR_MESSAGE);
        }
    }   
    
    //           METODO MODIFICAR PROVEEDOR
    
    public void modificarProveedor(Proveedor prove) {
        String sql = "UPDATE proveedor SET razonSocial = ?, domicilio = ?, telefono = ? WHERE idProveedor = ? ";

        try {

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, prove.getRazonSocial());
            ps.setString(2, prove.getDomicilio());
            ps.setString(3, prove.getTelefono());
            ps.setInt(4, prove.getIdProveedor());

            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Modificado Correctamente", "", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la Tabla Proveedor.", "Error de Conexion.", JOptionPane.ERROR_MESSAGE);
             
        }

    }    
    
    //           METODO ELIMINAR PROVEEDOR
    
    public void eliminarProveedor(String razonSocial) {
        String sql = "UPDATE proveedor SET estado = 0 WHERE razonSocial = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, razonSocial);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Eliminado correctamente", "", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la Tabla Proveedor.", "Error de Conexion.", JOptionPane.ERROR_MESSAGE);
        }

    }    
    
     public void darDeAltaProveedor(String razonSocial) {
        String sql = "UPDATE proveedor SET estado = 1 WHERE razonSocial = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, razonSocial);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Eliminado correctamente", "", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la Tabla Proveedor.", "Error de Conexion.", JOptionPane.ERROR_MESSAGE);
        }

    }    
    
    //           METODO LISTAR PROVEEDORES.
    
    public List<Proveedor> listarProveedores()  {
        String sql = "SELECT * FROM proveedor WHERE estado = 1";
        List<Proveedor> listaProveedor = new ArrayList();

        //idProveedor, razonSocial, domicilio, telefono, estado
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setEstado(rs.getBoolean("estado"));

                listaProveedor.add(proveedor);

                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la Tabla Proveedor.", "Error de Conexion.", JOptionPane.ERROR_MESSAGE);
        }
        return listaProveedor;
    }    
    
    //          METODO PARA BUSCAR PROVEEDOR POR ID
    //sacar prove y colocar proveedor
  public Proveedor buscarProveedor(int id) {
    String sql = "SELECT * FROM proveedor WHERE idProveedor = ? AND estado = 1";
    Proveedor prove = null; 

    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            prove = new Proveedor();

            prove.setIdProveedor(rs.getInt("idProveedor"));
            prove.setRazonSocial(rs.getString("razonSocial"));
            prove.setDomicilio(rs.getString("domicilio"));
            prove.setTelefono(rs.getString("telefono"));
        }

        
        
        ps.close();

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al conectar con Proveedor", "Error", JOptionPane.ERROR_MESSAGE);
    }

    return prove;
}
  
  //                  METODO PARA BUSCAR PROVEEDOR POR NOMBRE
  
  public Proveedor buscarProveedorNombre(String rSocial){
      String sql = "SELECT * FROM proveedor WHERE razonSocial = ? AND estado = 1";
      
        try {
            
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, rSocial);
            
            ResultSet rs = ps.executeQuery();
          
            while(rs.next()){
                proveedor = new Proveedor();
                
                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));
                
                
                
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con Proveedor", "Error", JOptionPane.ERROR_MESSAGE);
        }
      
  
  
      return proveedor;
  } 
    
}
