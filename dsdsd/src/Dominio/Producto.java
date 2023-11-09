package Dominio;

public class Producto {

    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private double descuento;
    private boolean estado;

    public Producto(int idProducto, String nombre, String descripcion, double precio, double descuento, boolean estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuento = descuento;
        this.estado = estado;
    }

    public Producto(String nombre, String descripcion, double precio, double descuento, boolean estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.descuento = descuento;
        this.estado = estado;
    }
    
    
    public Producto() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

  

}
