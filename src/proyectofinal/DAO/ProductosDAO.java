/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.DAO;

import java.sql.Connection;
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
    
        private static Connection conectar=null;
    PreparedStatement ps;
    ResultSet rs;
    
    public ProductosDAO() {
    
}
    
    public void Crear(ProductosModelo productosModelo) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar=Conexion.getconexion();
            ps = conectar.prepareStatement("INSERT INTO productos(NombreProductos, UnidaddeMedida, Categoria) VALUES (?, ?, ?);");
            ps.setString(1, productosModelo.getNombreProductos());
            ps.setString(2, productosModelo.getUnidadMedida());
            ps.setInt(3, productosModelo.getIdCategoría());

            int Resultado = ps.executeUpdate();

            if (Resultado == 1) {
                System.out.println("Se hizo el registro correctamente");
            } else {
                System.out.println("Error al registrar en la tabla Diccionario");
            }
             
            conectar.close();
        } catch (Exception e) {
            System.out.println("error: " + e.getLocalizedMessage());

        } finally {

        }

    }

    public void Actualizar(ProductosModelo productosModelo) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar=Conexion.getconexion();
            ps = conectar.prepareStatement("UPDATE productos SET NombreProductos=?, UnidadMedida=?, Categoria=? WHERE idProductos=? ;");
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
            conectar.close();
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
            conectar=Conexion.getconexion();
            ps = conectar.prepareStatement("SELECT * FROM productos;");
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
            conectar.close();
        } catch (Exception e) {
            System.out.println("error: " + e.getLocalizedMessage());

        } finally {

        }
        return datos;
    }
    
    
    public void Eliminar(int IdProductos) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar=Conexion.getconexion();
            ps = conectar.prepareStatement("DELETE FROM productos WHERE idProductos=?;");
            ps.setInt(1, IdProductos);

            int Resultado = ps.executeUpdate();

            if (Resultado == 1) {
                System.out.println("Se hizo el registro correctamente");
            } else {
                System.out.println("Error al registrar en la tabla Diccionario");
            }
             
            conectar.close();
        } catch (Exception e) {
            System.out.println("error: " + e.getLocalizedMessage());

        } finally {

        }

    }
    
}
