/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import proyectofinal.Modelo.ClienteModelo;
import proyectofinal.Modelo.ProductosModelo;

/**
 *
 * @author USUARIO
 */
public class ProductosDAO {
    
        Conexion conectar;
    PreparedStatement ps;
    ResultSet rs;
    
    public void Crear(ProductosModelo productosModelo) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar.getconexion();
            ps = conectar.getconexion().prepareStatement("INSERT INTO diccionario(Palabra) values(?);");
            ps.setString(1, productosModelo.getNombreProductos());
            ps.setString(2, productosModelo.getUnidadMedida());
            ps.setInt(3, productosModelo.getIdCategoría());

            int Resultado = ps.executeUpdate();

            if (Resultado == 1) {
                System.out.println("Se hizo el registro correctamente");
            } else {
                System.out.println("Error al registrar en la tabla Diccionario");
            }
             
            conectar.getconexion().close();
        } catch (Exception e) {
            System.out.println("error: " + e.getLocalizedMessage());

        } finally {

        }

    }

    public void Actualizar(ProductosModelo productosModelo) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar.getconexion();
            ps = conectar.getconexion().prepareStatement("UPDATE diccionario SET nivel=? WHERE IdDiccionario=? ;");
            ps.setString(1, productosModelo.getNombreProductos());
            ps.setString(2, productosModelo.getUnidadMedida());
            ps.setInt(3, productosModelo.getIdCategoría());
            ps.setInt(4, productosModelo.getIdProducto());
            
            int Resultado = ps.executeUpdate();

            if (Resultado >= 1) {
                System.out.println("Se hizo el registro correctamente");
            } else {
                System.out.println("Error al actualizar el nivel ");
            }
              //conectar.getconexion().commit();
            conectar.getconexion().close();
        } catch (Exception e) {
            System.out.println("error: " + e.getLocalizedMessage());

        } finally {

        }

    }
    
    public List<ProductosModelo> Lista() {
        List<ProductosModelo> datos = new ArrayList<>();
        ProductosModelo productosModelo;
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar.getconexion();
            ps = conectar.getconexion().prepareStatement("SELECT * FROM diccionario where nivel=0;");
            //ps.setString(1, dni);
            //ps.setInt(2, estado);

            rs = ps.executeQuery();
            //   rs.getArray(1).getResultSet();
            int cantidad = 0;
            //recorre la lista de usuarios

            while (rs.next()) {
                productosModelo = new ProductosModelo();
                productosModelo.setIdProducto(rs.getInt(1));
                productosModelo.setNombreProductos(rs.getString(2));
                productosModelo.setUnidadMedida(rs.getString(3));
                productosModelo.setIdCategoría(rs.getInt(4));

                datos.add(productosModelo);
                cantidad = cantidad + 1;

            }
            System.out.println("cantidad de registros: " + cantidad);
            conectar.getconexion().close();
        } catch (Exception e) {
            System.out.println("error: " + e.getLocalizedMessage());

        } finally {

        }
        return datos;
    }
    
    
    public void Eliminar(int IdProductos) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar.getconexion();
            ps = conectar.getconexion().prepareStatement("DELETE FROM diccionario(Palabra) values(?);");
            ps.setInt(1, IdProductos);

            int Resultado = ps.executeUpdate();

            if (Resultado == 1) {
                System.out.println("Se hizo el registro correctamente");
            } else {
                System.out.println("Error al registrar en la tabla Diccionario");
            }
             
            conectar.getconexion().close();
        } catch (Exception e) {
            System.out.println("error: " + e.getLocalizedMessage());

        } finally {

        }

    }
    
}
