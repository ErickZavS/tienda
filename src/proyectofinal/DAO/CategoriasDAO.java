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
import proyectofinal.Modelo.CategoriaModelo;
import proyectofinal.Modelo.ClienteModelo;

/**
 *
 * @author USUARIO
 */
public class CategoriasDAO {
    
        Conexion conectar;
    PreparedStatement ps;
    ResultSet rs;
    
    public void Crear(CategoriaModelo categoriaModelo) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar.getconexion();
            ps = conectar.getconexion().prepareStatement("INSERT INTO diccionario(Palabra) values(?);");
            ps.setString(1, categoriaModelo.getNombreCategoria());
            ps.setString(2, categoriaModelo.getDescripcion());

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

    public void Actualizar(CategoriaModelo categoriaModelo) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar.getconexion();
            ps = conectar.getconexion().prepareStatement("UPDATE diccionario SET nivel=? WHERE IdDiccionario=? ;");
            ps.setString(1, categoriaModelo.getNombreCategoria());
            ps.setString(2, categoriaModelo.getDescripcion());
           int Resultado = ps.executeUpdate();

            if (Resultado >= 1) {
                System.out.println("Se hizo el registro correctamente");
            } else {
              //  System.out.println("Error al actualizar el nivel " + nivel);
            }
              //conectar.getconexion().commit();
            conectar.getconexion().close();
        } catch (Exception e) {
            System.out.println("error: " + e.getLocalizedMessage());

        } finally {

        }

    }
    
    public List<CategoriaModelo> Lista() {
        List<CategoriaModelo> datos = new ArrayList<>();
        CategoriaModelo categoriaModelo;
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
                categoriaModelo = new CategoriaModelo();
                categoriaModelo.setIdCategoria(rs.getInt(1));
                categoriaModelo.setNombreCategoria(rs.getString(2));
                categoriaModelo.setDescripcion(rs.getString(3));

                datos.add(categoriaModelo);
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
    
    
    public void Eliminar(int IdCategorias) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar.getconexion();
            ps = conectar.getconexion().prepareStatement("DELETE FROM diccionario(Palabra) values(?);");
            ps.setInt(1, IdCategorias);

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
