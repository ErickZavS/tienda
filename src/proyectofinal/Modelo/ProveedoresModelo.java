/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.Modelo;

/**
 *
 * @author USUARIO
 */
public class ProveedoresModelo {
    
    private int IdProveedores;
    private String NombreCompañia;
    private String NombreContacto;
    private String CargoContacto;
    private String Direccion;
    private String Ciudad;
    private String Telefono;

    public int getIdProveedores() {
        return IdProveedores;
    }

    public void setIdProveedores(int IdCliente) {
        this.IdProveedores = IdCliente;
    }

    public String getNombreCompañia() {
        return NombreCompañia;
    }

    public void setNombreCompañia(String NombreCompañia) {
        this.NombreCompañia = NombreCompañia;
    }

    public String getNombreContacto() {
        return NombreContacto;
    }

    public void setNombreContacto(String NombreContacto) {
        this.NombreContacto = NombreContacto;
    }

    public String getCargoContacto() {
        return CargoContacto;
    }

    public void setCargoContacto(String CargoContacto) {
        this.CargoContacto = CargoContacto;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    
}
