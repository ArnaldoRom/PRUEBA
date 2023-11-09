
package AccesoADatos;

import Dominio.DetalleCompra;
import Dominio.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;


public class ProductoData {
    private Producto producto= null;
    private Connection conexion = null;
    
    public ProductoData(){
        conexion = Conexion.conectar();
    }
    
    public void registroProducto(Producto produ){
        String sql="INSERT INTO producto (nombre,descripcion,precio, descuento, estado) VALUES(?, ?, ?, ?, ?)";
        producto= new Producto();
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setString(1, produ.getNombre());
            ps.setString(2, produ.getDescripcion());
            ps.setDouble(3, produ.getPrecio());
            ps.setDouble(4, produ.getDescuento());
            ps.setBoolean(5, produ.isEstado());
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Producto cargado con exito", "", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"producto incorrecto");
        }
    }
    
    public void modificarProducto(Producto produ){
        
        String sql="UPDATE producto SET nombre = ?, descripcion=?, precio=?, descuento=?, estado=? WHERE idProducto = ?";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setString(1, produ.getNombre());
            ps.setString(2, produ.getDescripcion());
            ps.setDouble(3, produ.getPrecio());
            ps.setDouble(4, produ.getDescuento());
            ps.setBoolean(5, produ.isEstado());
            ps.setInt(6, produ.getIdProducto());
            
            ps.executeUpdate();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Producto no encontrado","error de conexion",0);
        }
    }
    
    public void eliminarProducto(int idProducto){
        String sql="UPDATE producto SET estado = 0 WHERE idProducto = ?";
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1,idProducto);
            ps.executeUpdate();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al conectar con Producto");
        }
    }
       
    public Producto consultaProductoPorID(int idProducto){
        String sql = " SELECT * FROM producto WHERE idProducto = ? AND estado = 1";
        Producto producto = null;
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);            
            ps.setInt(1, idProducto);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){                
                producto = new Producto();                
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setDescuento(rs.getDouble("descuento"));
                
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Producto no encontrado");
        }        
        return producto;   
    }
    
    
    public List<DetalleCompra> listarProductos(int idProveedor){
        String sql="SELECT producto.nombre, producto.descripcion, producto.precio, detalleCompra.cantidad" +
                " FROM proveedor JOIN compra ON (proveedor.idProveedor = compra.idProveedor) JOIN detallecompra ON (compra.idCompra = detallecompra.idCompra )" + 
                " JOIN producto ON (detallecompra.idProducto = producto.idProducto)WHERE proveedor.idProveedor = ? AND producto.estado = 1"; 
        
        List<DetalleCompra>listaProducto = new ArrayList(); 
        try{
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idProveedor);            
            ResultSet rs = ps.executeQuery();
            DetalleCompra detalleCompra = null;
//nombre, precio, cantidad
            while(rs.next()){
                
                //producto = new Producto();
                detalleCompra= new DetalleCompra();
                producto = new Producto();
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                detalleCompra.setCantidad(rs.getInt("cantidad"));
                
                detalleCompra.setIdProducto(producto);
                
                
                
                
                listaProducto.add(detalleCompra);
                
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No hay Productos");
        }
        return listaProducto;
    }
}
