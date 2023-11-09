/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinal;

import AccesoADatos.CompraData;
import AccesoADatos.DetalleCompraData;
import AccesoADatos.ProductoData;
import AccesoADatos.ProveedorData;
import AccesoADatos.UsuarioData;
import Dominio.Compra;
import Dominio.DetalleCompra;
import Dominio.Producto;
import Dominio.Proveedor;
import Dominio.Usuario;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author ejarq
 */
public class ProyectoFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //  objetos para llamar a los metodos
        CompraData compraData = new CompraData();
       ProveedorData proveData = new ProveedorData();
        ProductoData produData = new ProductoData();
        UsuarioData uData = new UsuarioData();
        DetalleCompraData dCompraData = new DetalleCompraData();
        
        //objetos para setear atributos      
        Compra compra = null;
        Proveedor proveedor = null;
        Producto producto = null;
        DetalleCompra dCompra = null;
        Usuario user = null;
        
        
        //                    PROBANDO METODOS PROVEEDORDATA FUNCIONAAAAAAAN TODOS
        
        
                                     //METODO AGREGAR PROVEEDOR 
        //proveedor = new Proveedor(3,"Musimundo", "Pedernera 368", "+54 2657-902030", true);
        //proveData.agregarProveedor(proveedor);
                
                                     //METODO MODIFICAR PROVEEDOR
        //proveData.modificarProveedor(proveedor);
                
                                     //METODO ElIMINAR PROVEEDOR
        //proveData.eliminarProveedor(1);
                
                                     //METODO ListarProveedores
        /*
        List<Proveedor> proveList = new ArrayList();
        proveList = proveData.listarProveedores();
        System.out.println("Lista Proveedores");
        for(Proveedor pro : proveList){
            System.out.println("Nombre: " + pro.getRazonSocial());
            System.out.println(" ");
        }
        */
        
                                     //METODO BUSCAR POR ID METODO       
        //proveedor = new Proveedor();
        //proveedor = proveData.buscarProveedor(3);      
        
                                     //METODO PARA BUSCAR POR NOMBRE        
        /*
        proveedor = new Proveedor();
        proveedor = proveData.buscarProveedorNombre("Musimundo");
        
        System.out.println("Nombre: " + proveedor.getRazonSocial());
        */
        
        //                    PROBANDO METODOS DE PRODUCTODATA
        
        
                                     // METODOS REGISTRAR y MODIFICAR
        //producto = new Producto(2,"Heladera","HGF358 plata con freezer 282L 220V", 250000, 0, true);
        //produData.registroProducto(producto);            
        //produData.modificarProducto(producto);
                
                                     //METODO ELIMINAR PRODUCTO
        
        //produData.eliminarProducto(3);
        
                                     //METODO CONSULTA POR ID        
        /*
        producto = new Producto();
        producto = produData.consultaProductoPorID(1);
        
        System.out.println("Nombre: " + producto.getNombre()); 
        */
        
                                     //METODO LISTAR PRODUCTO POR IDPROVEEDOR
       /*
        List<DetalleCompra> lis= new ArrayList<>();
        lis = produData.listarProductos(2);
        for(DetalleCompra pro:lis){
            System.out.println("Nombre: "+pro.getIdProducto().getNombre());
            System.out.println("Descripcion:" + pro.getIdProducto().getDescripcion());
            System.out.println("Precio: " + pro.getIdProducto().getPrecio());
            System.out.println("Cantidad" +  pro.getCantidad());
        }
        */
        
        //                    PROBANDO METODOS DE COMPRADATA
        
        
                                     //METODO registrarCompra
        //compra = new Compra(proveedor, LocalDate.of(2022, 8,21), true);
        //compraData.registrarCompra(compra);

        
                                     //METODO LISTAR COMPRA POR PROVEEDOR
        /*
        List<Proveedor> listCom = new ArrayList<>();
        listCom = compraData.listarCompraporProveedor(2);
       
        for(Proveedor pro : listCom){
            System.out.println("Nombre: " + pro.getRazonSocial());
        }
        */
                
                                     //METODO ENTE FECHA Y FECHA
        /*
        List<Compra> listComp = new ArrayList();
        listComp = compraData.entreFechas(LocalDate.of(2023, 8, 1), LocalDate.of(2023,11,30));
        
        for(Compra com : listComp){
            System.out.println("Fecha: " + com.getFecha());
        } 
        */                             
        
                                     //METODO OBTENER COMPRA POR ID
        /*
        compra = new Compra();        
        compra = compraData.obtenerCompraPorID(1);
        
        System.out.println("id: " + compra.getIdCompra());
        System.out.println("fecha: " + compra.getFecha());
        */
        
                                     //METODO LISTAR COMPRA POR PRODUCTO
        /*
        List<Producto> listProve = new ArrayList<>();
        listProve = compraData.listarCompraporProducto(2);
        
        for(Producto pd : listProve){
            System.out.println("Nombre" + pd.getNombre());
        }
        */
        
        
        //                    PROBANDO  METODOS DE DETALLE COMPRADATA
        
        
                                     //METODO REGISTRAR
             /*                       
        compra = new Compra();
        compra = compraData.obtenerCompraPorID(1);
        producto = new Producto();
        producto = produData.consultaProductoPorID(2);
        
        dCompra = new DetalleCompra(compra,producto,900.2,100,true);
        
        dCompraData.registrarDetalleCompra(dCompra);
         */                            
        
        
                                     //METODO LISTAR DETALLE COMPRA POR ID
        /*
        List<DetalleCompra> lis=new ArrayList<>();
        lis=dCompraData.listarDetalleCOmpra(2);
        
        for(DetalleCompra dc:lis){
            System.out.println("Nombre: "+dc.getIdProducto().getNombre());
        }
        */
        
                                     //METODO LISTAR DETALLE DEL PRODUCTO
        /*
        List<DetalleCompra> pro=new ArrayList<>();
        pro=dCompraData.listarDetalleDelProducto(3);
        
        for(DetalleCompra ls:pro){
            System.out.println("Nomre: "+ls.getIdProducto().getNombre());
            System.out.println("Descripcion: "+ls.getIdProducto().getDescripcion());
            System.out.println("Cantidad: "+ls.getCantidad());
        }
        */          
        
                                     //METODO MODIFICAR
        /*
        Producto pro=new Producto();
        pro=produData.consultaProductoPorID(2);
        Compra com=new Compra();
        com=compraData.obtenerCompraPorID(3);
        
        DetalleCompra comp= new DetalleCompra(3,com,pro,5666,10000,true);
        
        dCompraData.modificarDetalleCompra(comp);
        */
        
                                     //METODO ELIMINAR
                                     
        //dCompraData.eliminarDetalleCompra(2);
      
        //Usuario user = null;
        //UsuarioData uData = new UsuarioData();
        
        
        //                    PROBANDO METODOS DE USUARIO DATA
            
        
                                     //METODO REGISTRAR
                                     
        //user = new Usuario("Marco", "ooopsdssss3", "stakatakau@gmail.com", true);
        //uData.crearUsuario(user);
        
                                     //METODO BUSCAR USUARIO
        /*                             
        List<Usuario> uss = new ArrayList<>();       
        uss = uData.buscarUsuario("e");
        
        for(Usuario us : uss){
            System.out.println("Nombre: " + us.getNombreCuenta());
        }
        */                             
               
                                     //METODO LISTAR USUARIOS
        /*
        uss = uData.listarUsuariosActivos();
        for(Usuario us : uss){
            System.out.println("Nombre: " + us.getNombreCuenta());
        }
        */
        
                                     //METODO CAMBIAR CONTRASENA
                                     
        //uData.cambiarContasena("Matias", "bolita20");
        
                                     //METODO DAR DE BAJA
        
        //uData.darDeBaja("Pablo");
        
        
        //METODO actualizarCantidad de DETALLECOMPRA
       /*
        List<DetalleCompra> nombreQueQuiera = new ArrayList<>();
        
        nombreQueQuiera=dCompraData.actualizaCantidad(1);
        
        for(DetalleCompra ss : nombreQueQuiera ){
            System.out.println("Nombre: "+ ss.getIdProducto().getNombre());
            System.out.println("descripcion: "+ ss.getIdProducto().getDescripcion());
            System.out.println("Cantidad: " + ss.getCantidad());
        }
            */
    }
    
}
