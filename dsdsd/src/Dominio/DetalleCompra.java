
package Dominio;


public class DetalleCompra {

    private int idDetalle;
    private Compra idCompra;
    private Producto idProducto;
    private double precioCosto;
    private int cantidad;
    private boolean estado;

    public DetalleCompra() {
    }

    public DetalleCompra(int idDetalle, Compra idCompra, Producto idProducto, double precioCosto, int cantidad, boolean estado) {
        this.idDetalle = idDetalle;
        this.idCompra = idCompra;
        this.idProducto = idProducto;
        this.precioCosto = precioCosto;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public DetalleCompra(Compra idCompra, Producto idProducto, double precioCosto, int cantidad, boolean estado) {
        this.idCompra = idCompra;
        this.idProducto = idProducto;
        this.precioCosto = precioCosto;
        this.cantidad = cantidad;
        this.estado = estado;
    }
    

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Compra getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Compra idCompra) {
        this.idCompra = idCompra;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
    
}
