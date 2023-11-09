
package AccesoADatos;

import Dominio.Compra;
import Dominio.Producto;
import Dominio.Proveedor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class CompraData {
    private Connection conexion;
    private ProveedorData proveedorData = new ProveedorData();

    public CompraData() {
       conexion= Conexion.conectar();
    }
    
    public void registrarCompra(Compra compra){
        String sql="INSERT compra (idProveedor,fecha,estado) VALUES(?, ?, ?)";
        try {
            PreparedStatement añadir=conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            añadir.setInt(1,compra.getProveedor().getIdProveedor());
            añadir.setDate(2,Date.valueOf(compra.getFecha()));
            añadir.setBoolean(3,compra.isEstado());
            añadir.executeUpdate();
            ResultSet añadido=añadir.getGeneratedKeys();
            if(añadido.next()){
                compra.setIdCompra(añadido.getInt("idCompra"));
                JOptionPane.showMessageDialog(null,"Compra añadida");
            }
            añadir.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error Ingresar tabla compra");
        }        
    }
    
    public List<Proveedor> listarCompraporProveedor(int idProveedor){
        
        String sql="SELECT * FROM proveedor WHERE idProveedor=? AND estado=1";
        
        List<Proveedor> listado= new ArrayList<>();
        
        try {
            PreparedStatement lista=conexion.prepareStatement(sql);
            lista.setInt(1,idProveedor);
            
            ResultSet rs=lista.executeQuery();
            
            while(rs.next()){
                
                int idProv=rs.getInt("idProveedor");
                String nombre=rs.getString("razonSocial");
                String domicilio=rs.getString("domicilio");
                String telefono=rs.getString("telefono");
                boolean estado=rs.getBoolean("estado");
                Proveedor pro=new Proveedor(idProv,nombre,domicilio,telefono,estado);
                listado.add(pro);
            }
            lista.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error con Listar Proveedor");
        }
        return listado;
        
    }
     
    public List<Compra> entreFechas(LocalDate inicio, LocalDate fin){        
        String sql= "SELECT * FROM compra WHERE fecha BETWEEN ? AND ?";
        List<Compra> compras=new ArrayList<>();  
                
        try {
            PreparedStatement lista=conexion.prepareStatement(sql);            
            lista.setDate(1,Date.valueOf(inicio));
            lista.setDate(2, Date.valueOf(fin));                    
            ResultSet rs=lista.executeQuery();
            
            while(rs.next()){                
                Compra compra=new Compra(); 
                compra.setIdCompra(rs.getInt("idCompra"));
                int idProvee=rs.getInt("idProveedor");
                Proveedor id=proveedorData.buscarProveedor(idProvee);
                
                compra.setProveedor(id);
                compra.setFecha(rs.getDate("fecha").toLocalDate());
                compra.setEstado(rs.getBoolean("estado"));                
                compras.add(compra);
            }
            
        } catch (SQLException ex) {
             ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error con Lista Compra");
        }        
        return compras;
    }
        
    public Compra obtenerCompraPorID(int idCompra){
        String sql="SELECT * FROM compra WHERE idCompra=? AND estado=1";
        Compra compra=null;
        Proveedor proveedor = new Proveedor();
        try {
            PreparedStatement obtener= conexion.prepareStatement(sql);
            obtener.setInt(1, idCompra);
            ResultSet lista=obtener.executeQuery();
            
            while(lista.next()){
                int idProveedor=lista.getInt("idProveedor");                                
                LocalDate fecha=lista.getDate("fecha").toLocalDate();
                boolean estado=lista.getBoolean("estado");
                proveedor = proveedorData.buscarProveedor(idProveedor);
                
                compra=new Compra(idCompra,proveedor,fecha,estado);
            }
            obtener.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al Obtener Compras");
        }
        return compra;
        
    }
    
    public List<Producto> listarCompraporProducto(int idProveedor){
        String sql="SELECT * FROM producto WHERE idProducto=? AND estado=1";
        ArrayList<Producto> listado=new ArrayList<>();
        
        try {
            
            PreparedStatement lista=conexion.prepareStatement(sql);
            lista.setInt(1,idProveedor);
            ResultSet rs=lista.executeQuery();
            
            while(rs.next()){
                int idProduc=rs.getInt("idProducto");
                String nombre=rs.getString("nombre");
                String descripcion=rs.getString("descripcion");
                double precio=rs.getDouble("precio");
                double descuento=rs.getDouble("descuento");
                boolean estado=rs.getBoolean("estado");
                Producto nuevo=new Producto(idProduc,nombre,descripcion,precio,descuento,estado);
                listado.add(nuevo);
            }
            lista.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error con Listar Productos");
        }
        return listado;
        
    }    

}
