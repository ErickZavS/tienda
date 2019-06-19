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
import proyectofinal.Modelo.UsuarioModelo;

/**
 *
 * @author USUARIO
 */
public class UsuarioDAO {

    private static Connection conectar = null;
    PreparedStatement ps;
    ResultSet rs;

    public UsuarioDAO() {

    }

    public void Crear(UsuarioModelo categoriaUsuario) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar = Conexion.getconexion();

            ps = conectar.prepareStatement("INSERT INTO usuarios(Usuario, Contraseña) values(?,?);");
            ps.setString(1, categoriaUsuario.getUsuario());
            ps.setString(2, categoriaUsuario.getContraseña());

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

    public void Actualizar(UsuarioModelo categoriaUsuario) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar = Conexion.getconexion();
            ps = conectar.prepareStatement("UPDATE usuarios SET Usuario=?, Contraseña=? WHERE idUsuarios=?;");
            ps.setString(1, categoriaUsuario.getUsuario());
            ps.setString(2, categoriaUsuario.getContraseña());

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

    public List<UsuarioModelo> Lista() {
        List<UsuarioModelo> datos = new ArrayList<>();
        UsuarioModelo categoriaUsuario;
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar = Conexion.getconexion();
            ps = conectar.prepareStatement("SELECT * FROM usuarios;");
            //ps.setString(1, dni);
            //ps.setInt(2, estado);

            rs = ps.executeQuery();
            //   rs.getArray(1).getResultSet();
            int cantidad = 0;
            //recorre la lista de usuarios

            while (rs.next()) {
                categoriaUsuario = new UsuarioModelo();
                categoriaUsuario.setUsuario(rs.getString(1));
                categoriaUsuario.setContraseña(rs.getString(2));

                datos.add(categoriaUsuario);
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

    public List<UsuarioModelo> ListaID(int id) {
        List<UsuarioModelo> datos = new ArrayList<>();
        UsuarioModelo usuarioModelo;
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar = Conexion.getconexion();
            ps = conectar.prepareStatement("SELECT * FROM usuarios where idusuarios=?;");
            ps.setInt(1, id);
            //ps.setInt(2, estado);

            rs = ps.executeQuery();
            //   rs.getArray(1).getResultSet();
            int cantidad = 0;
            //recorre la lista de usuarios

            while (rs.next()) {
                usuarioModelo = new UsuarioModelo();
                usuarioModelo.setUsuario(rs.getString(1));
                usuarioModelo.setContraseña(rs.getString(2));

                datos.add(usuarioModelo);
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
     public List<UsuarioModelo> Login(String Usuario){
        List<UsuarioModelo> datos = new ArrayList<>();
        UsuarioModelo usuarioModelo;
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar = Conexion.getconexion();
            ps = conectar.prepareStatement("SELECT * FROM usuarios where Usuario=?;");
            ps.setString(1, Usuario);
            //ps.setInt(2, estado);

            rs = ps.executeQuery();
            //   rs.getArray(1).getResultSet();
            int cantidad = 0;
            //recorre la lista de usuarios

            while (rs.next()) {
                usuarioModelo = new UsuarioModelo();
                usuarioModelo.setIdUsuarios(rs.getInt(1));
                usuarioModelo.setUsuario(rs.getString(2));
                usuarioModelo.setContraseña(rs.getString(3));

                datos.add(usuarioModelo);
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

    public void Eliminar(int IdUsuarios) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar = Conexion.getconexion();
            ps = conectar.prepareStatement("DELETE FROM usuarios where idusuarios=?;");
            ps.setInt(1, IdUsuarios);

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
