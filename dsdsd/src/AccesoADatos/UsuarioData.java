
package AccesoADatos;

import Dominio.Usuario;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioData {
    private Connection conexion = null;
    private Usuario user = null;
    public UsuarioData(){
        conexion = Conexion.conectar();
    }  

    public List<Usuario> buscarUsuario(String nombre){
        String sql = "SELECT * FROM usuario WHERE nombreCuenta LIKE ?"; 
        List<Usuario> usuario = new ArrayList<>();
        try {            
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre+ "%");
            
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                user = new Usuario();                
                user.setIdUsuario(rs.getInt("idUsuario"));
                user.setNombreCuenta(rs.getString("nombreCuenta"));
                user.setContrasena(rs.getString("contrasena"));
                user.setCorreoElec(rs.getString("correoElec"));                
                usuario.add(user);               
            }           
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioData.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return usuario;
    }
    
    public List<Usuario> listarUsuariosActivos(){
        String sql = "SELECT * FROM usuario WHERE estado = 1";
        List<Usuario> user = new ArrayList<>();
        try { 
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombreCuenta(rs.getString("nombreCuenta"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setCorreoElec(rs.getString("correoElec"));
                
                user.add(usuario);
                    
            }
      
        } catch (SQLException ex) {
            
            Logger.getLogger(UsuarioData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
        
    public void crearUsuario(Usuario user){
        String sql="INSERT INTO usuario( nombreCuenta, contrasena, correoElec, estado)" + " VALUES (?, ?, ?, 1)";    
        
        try {
            
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, user.getNombreCuenta());
            ps.setString(2, user.getContrasena());
            ps.setString(3, user.getCorreoElec());
            
            ps.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            
            Logger.getLogger(UsuarioData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cambiarContasena(String nombreUsuario, String newContrasena){  
        String sql= "UPDATE  usuario SET contrasena = ? WHERE nombreCuenta = ? AND estado = 1";
        
        try {
            
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, newContrasena);
            ps.setString(2, nombreUsuario);
            
            ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(UsuarioData.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public void darDeBaja(String nombreCuenta){
        String sql = "UPDATE usuario SET estado = 0 WHERE nombreCuenta = ? AND estado = 1";
        
        try {
            
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombreCuenta);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(UsuarioData.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
    }   
    
}
