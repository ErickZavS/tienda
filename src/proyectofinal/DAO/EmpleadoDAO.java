/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import proyectofinal.Modelo.ClienteModelo;
import proyectofinal.Modelo.EmpleadosModelo;

/**
 *
 * @author USUARIO
 */
public class EmpleadoDAO {
    
        Conexion conectar;
    PreparedStatement ps;
    ResultSet rs;
    
    public void Crear(EmpleadosModelo empleadosModelo) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar.getconexion();
            ps = conectar.getconexion().prepareStatement("INSERT INTO diccionario(Palabra) values(?);");
            ps.setString(1, empleadosModelo.getApellido());
            ps.setString(2, empleadosModelo.getNombre());
            ps.setString(3, empleadosModelo.getCargo());
            ps.setDate(4, (Date) empleadosModelo.getFechaContratacion());
            ps.setDate(5, (Date) empleadosModelo.getFechaNacimiento());
            ps.setString(6, empleadosModelo.getDireccion());
            ps.setString(7, empleadosModelo.getCiudad());
            ps.setString(8, empleadosModelo.getPais());
            ps.setString(9, empleadosModelo.getTelDomicilio());
            ps.setString(10, empleadosModelo.getExtension());
            ps.setString(11, empleadosModelo.getNotas());

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

    public void Actualizar(EmpleadosModelo empleadosModelo) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar.getconexion();
            ps = conectar.getconexion().prepareStatement("UPDATE diccionario SET nivel=? WHERE IdDiccionario=? ;");
            ps.setString(1, empleadosModelo.getApellido());
            ps.setString(2, empleadosModelo.getNombre());
            ps.setString(3, empleadosModelo.getCargo());
            ps.setDate(4, (Date) empleadosModelo.getFechaContratacion());
            ps.setDate(5, (Date) empleadosModelo.getFechaNacimiento());
            ps.setString(6, empleadosModelo.getDireccion());
            ps.setString(7, empleadosModelo.getCiudad());
            ps.setString(8, empleadosModelo.getPais());
            ps.setString(9, empleadosModelo.getTelDomicilio());
            ps.setString(10, empleadosModelo.getExtension());
            ps.setString(11, empleadosModelo.getNotas());
            ps.setInt(12, empleadosModelo.getIdEmpleado());
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
    
    public List<EmpleadosModelo> Lista() {
        List<EmpleadosModelo> datos = new ArrayList<>();
        EmpleadosModelo empleadosModelo;
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
                empleadosModelo = new EmpleadosModelo();
                empleadosModelo.setIdEmpleado(rs.getInt(1));
                empleadosModelo.setApellido(rs.getString(2));
                empleadosModelo.setNombre(rs.getString(3));
                empleadosModelo.setCargo(rs.getString(4));
                empleadosModelo.setFechaNacimiento(rs.getDate(5));
                empleadosModelo.setFechaContratacion(rs.getDate(6));
                empleadosModelo.setDireccion(rs.getString(7));
                empleadosModelo.setCiudad(rs.getString(8));
                empleadosModelo.setPais(rs.getString(9));
                empleadosModelo.setTelDomicilio(rs.getString(10));
                empleadosModelo.setExtension(rs.getString(11));
                empleadosModelo.setNotas(rs.getString(12));

                datos.add(empleadosModelo);
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
    
    
    public void Eliminar(int IdEmpleado) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar.getconexion();
            ps = conectar.getconexion().prepareStatement("DELETE FROM diccionario(Palabra) values(?);");
            ps.setInt(1, IdEmpleado);

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
