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
import proyectofinal.Modelo.ProveedoresModelo;

/**
 *
 * @author USUARIO
 */
public class ProveedoresDAO {

    private static Connection conectar=null;
    PreparedStatement ps;
    ResultSet rs;
    
    public ProveedoresDAO() {
        
    }

    public void Crear(ProveedoresModelo proveedoresModelo) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar=Conexion.getconexion();
            ps = conectar.prepareStatement("INSERT INTO proveedores(NombreCompañia, NombreContacto, CargoContacto, Direccion, Ciudad, Telefono) VALUES (?, ?, ?, ?, ?, ?);");
            ps.setString(1, proveedoresModelo.getNombreCompañia());
            ps.setString(2, proveedoresModelo.getNombreContacto());
            ps.setString(3, proveedoresModelo.getCargoContacto());
            ps.setString(4, proveedoresModelo.getDireccion());
            ps.setString(5, proveedoresModelo.getCiudad());
            ps.setString(6, proveedoresModelo.getTelefono());

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

    public void Actualizar(ProveedoresModelo proveedoresModelo) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar=Conexion.getconexion();
            ps = conectar.prepareStatement("UPDATE proveedores SET NombreCompañia=?, NombreContacto=?, CargoContacto=?, Direccion=?, Ciudad=?, Telefono=? WHERE idProveedores=? ;");
            ps.setString(1, proveedoresModelo.getNombreCompañia());
            ps.setString(2, proveedoresModelo.getNombreContacto());
            ps.setString(3, proveedoresModelo.getCargoContacto());
            ps.setString(4, proveedoresModelo.getDireccion());
            ps.setString(5, proveedoresModelo.getCiudad());
            ps.setString(6, proveedoresModelo.getTelefono());
            ps.setInt(7, proveedoresModelo.getIdProveedores());

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

    public List<ProveedoresModelo> Lista() {
        List<ProveedoresModelo> datos = new ArrayList<>();
        ProveedoresModelo proveedoresModelo;
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar=Conexion.getconexion();
            ps = conectar.prepareStatement("SELECT * FROM proveedores;");
            //ps.setString(1, dni);
            //ps.setInt(2, estado);

            rs = ps.executeQuery();
            //   rs.getArray(1).getResultSet();
            int cantidad = 0;
            //recorre la lista de usuarios

            while (rs.next()) {
                proveedoresModelo = new ProveedoresModelo();
                proveedoresModelo.setIdProveedores(rs.getInt(1));
                proveedoresModelo.setNombreCompañia(rs.getString(2));
                proveedoresModelo.setNombreContacto(rs.getString(3));
                proveedoresModelo.setCargoContacto(rs.getString(4));
                proveedoresModelo.setDireccion(rs.getString(5));
                proveedoresModelo.setCiudad(rs.getString(6));
                proveedoresModelo.setTelefono(rs.getString(7));

                datos.add(proveedoresModelo);
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

    public void Eliminar(int IdProveedores) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar=Conexion.getconexion();
            ps = conectar.prepareStatement("DELETE FROM proveedores WHERE idProveedores=?;");
            ps.setInt(1, IdProveedores);

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
