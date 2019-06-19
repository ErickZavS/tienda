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
import proyectofinal.Modelo.CategoriaModelo;


/**
 *
 * @author USUARIO
 */
public class CategoriasDAO {
    
    private static Connection conectar=null;
    PreparedStatement ps;
    ResultSet rs;
    
    public CategoriasDAO() {
    
}
    
    public void Crear(CategoriaModelo categoriaModelo) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar=  Conexion.getconexion();
           
            ps = conectar.prepareStatement("INSERT INTO categorias(NombreCategoria, Descripcion) values(?,?);");
            ps.setString(1, categoriaModelo.getNombreCategoria());
            ps.setString(2, categoriaModelo.getDescripcion());

            int Resultado = ps.executeUpdate();

            if (Resultado == 1) {
                System.out.println("Se hizo el registro correctamente");
            } else {
                System.out.println("Error al registrar en la tabla Diccionario");
            }
             
            conectar.close();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());

        } finally {

        }

    }

    public void Actualizar(CategoriaModelo categoriaModelo) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar=Conexion.getconexion();
            ps = conectar.prepareStatement("UPDATE categorias SET NombreCategoria=?, Descripcion=? WHERE idcategorias=? ;");
            ps.setString(1, categoriaModelo.getNombreCategoria());
            ps.setString(2, categoriaModelo.getDescripcion());
            ps.setInt(3, categoriaModelo.getIdCategoria());
            
           int Resultado = ps.executeUpdate();

            if (Resultado >= 1) {
                System.out.println("Se hizo el registro correctamente");
            } else {
              //  System.out.println("Error al actualizar el nivel " + nivel);
            }
              //conectar.getconexion().commit();
            conectar.close();
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
           conectar=  Conexion.getconexion();
           ps = conectar.prepareStatement("SELECT * FROM categorias;");
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
         conectar.close();
        } catch (Exception e) {
            System.out.println("error: " + e.getLocalizedMessage());

        } finally {

        }
        return datos;
    }
    
        public List<CategoriaModelo> ListaID(int id) {
        List<CategoriaModelo> datos = new ArrayList<>();
        CategoriaModelo categoriaModelo;
        try {
            System.out.println("Intentando conectar a la base de datos");
           conectar=  Conexion.getconexion();
           ps = conectar.prepareStatement("SELECT * FROM categorias where idcategorias=?;");
           ps.setInt(1, id);
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
         conectar.close();
        } catch (Exception e) {
            System.out.println("error: " + e.getLocalizedMessage());

        } finally {

        }
        return datos;
    }
    
    
    public void Eliminar(int IdCategorias) {
        try {
            System.out.println("Intentando conectar a la base de datos");
          conectar=  Conexion.getconexion();
           ps = conectar.prepareStatement("DELETE FROM categorias where idcategorias=?;");
            ps.setInt(1, IdCategorias);

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
