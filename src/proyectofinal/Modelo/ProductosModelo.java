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
public class ProductosModelo {
    
    private int IdProducto;
    private String NombreProductos;
    private String UnidadMedida;
    private int IdCategoría;

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombreProductos() {
        return NombreProductos;
    }

    public void setNombreProductos(String NombreProductos) {
        this.NombreProductos = NombreProductos;
    }

    public String getUnidadMedida() {
        return UnidadMedida;
    }

    public void setUnidadMedida(String UnidadMedida) {
        this.UnidadMedida = UnidadMedida;
    }

    public int getIdCategoría() {
        return IdCategoría;
    }

    public void setIdCategoría(int IdCategoría) {
        this.IdCategoría = IdCategoría;
    }
    
    
    
}
