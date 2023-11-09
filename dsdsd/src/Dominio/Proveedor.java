
package Dominio;


public class Proveedor {
private int idProveedor;
private String razonSocial;
private String domicilio;
private String telefono;
private Boolean estado;

    public Proveedor(int idProveedor, String razonSocial, String domicilio, String telefono, Boolean estado) {
        this.idProveedor = idProveedor;
        this.razonSocial = razonSocial;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Proveedor(String razonSocial, String domicilio, String telefono, Boolean estado) {
        this.razonSocial = razonSocial;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Proveedor() {
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }




}
