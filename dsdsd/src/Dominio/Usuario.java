
package Dominio;


public class Usuario {

    private int idUsuario;
    private String nombreCuenta;
    private String contrasena;
    private String correoElec;
    private boolean estado;
//idUsuario, nombreCuenta, contrasena, correoElec, estado
    public Usuario(int idUsuario, String nombreCuenta, String contrasena, String correoElec, boolean estado) {
        this.idUsuario = idUsuario;
        this.nombreCuenta = nombreCuenta;
        this.contrasena = contrasena;
        this.correoElec = correoElec;
        this.estado = estado;
    }

    public Usuario(String nombreCuenta, String contrasena, String correoElec, boolean estado) {
        this.nombreCuenta = nombreCuenta;
        this.contrasena = contrasena;
        this.correoElec = correoElec;
        this.estado = estado;
    }

    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreoElec() {
        return correoElec;
    }

    public void setCorreoElec(String correoElec) {
        this.correoElec = correoElec;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

  
    
    
    
}
