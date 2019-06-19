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

/**
 *
 * @author USUARIO
 */
public class ClienteDAO {

    private static Connection conectar=null;
    PreparedStatement ps;
    ResultSet rs;
    
    public ClienteDAO() {
    
}

    public void Crear(ClienteModelo clienteModelo) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar=Conexion.getconexion();
            ps = conectar.prepareStatement("INSERT INTO clientes(NombreCompañia, NombreContacto, CargoContacto, Direccion, Ciudad, Telefono) values(?,?,?,?,?,?);");
            ps.setString(1, clienteModelo.getNombreCompañia());
            ps.setString(2, clienteModelo.getNombreContacto());
            ps.setString(3, clienteModelo.getCargoContacto());
            ps.setString(4, clienteModelo.getDireccion());
            ps.setString(5, clienteModelo.getCiudad());
            ps.setString(6, clienteModelo.getTelefono());

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

    public void Actualizar(ClienteModelo clienteModelo) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar=Conexion.getconexion();
            ps = conectar.prepareStatement("UPDATE clientes SET NombreCompañia=?, NombreContacto=?, CargoContacto=?, Direccion=?, Ciudad=?, Telefono=? WHERE idclientes=? ;");
            ps.setString(1, clienteModelo.getNombreCompañia());
            ps.setString(2, clienteModelo.getNombreContacto());
            ps.setString(3, clienteModelo.getCargoContacto());
            ps.setString(4, clienteModelo.getDireccion());
            ps.setString(5, clienteModelo.getCiudad());
            ps.setString(6, clienteModelo.getTelefono());
            ps.setInt(7, clienteModelo.getIdCliente());
            
            int Resultado = ps.executeUpdate();

            if (Resultado >= 1) {
                System.out.println("Se hizo el registro correctamente");
            } else {
                System.out.println("Error al actualizar");
            }
            //conectar.getconexion().commit();
            conectar.close();
        } catch (Exception e) {
            System.out.println("error: " + e.getLocalizedMessage());

        } finally {

        }

    }

    public List<ClienteModelo> Lista() {
        List<ClienteModelo> datos = new ArrayList<>();
        ClienteModelo clienteModelo;
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar=Conexion.getconexion();
            ps = conectar.prepareStatement("SELECT * FROM clientes;");
            //ps.setString(1, dni);
            //ps.setInt(2, estado);

            rs = ps.executeQuery();
            //   rs.getArray(1).getResultSet();
            int cantidad = 0;
            //recorre la lista de usuarios

            while (rs.next()) {
                clienteModelo = new ClienteModelo();
                clienteModelo.setIdCliente(rs.getInt(1));
                clienteModelo.setNombreCompañia(rs.getString(2));
                clienteModelo.setNombreContacto(rs.getString(3));
                clienteModelo.setCargoContacto(rs.getString(4));
                clienteModelo.setDireccion(rs.getString(5));
                clienteModelo.setCiudad(rs.getString(6));
                clienteModelo.setTelefono(rs.getString(7));


                datos.add(clienteModelo);
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

    public void Eliminar(int IdCliente) {
        try {
            System.out.println("Intentando conectar a la base de datos");
            conectar=Conexion.getconexion();
            ps = conectar.prepareStatement("DELETE FROM clientes WHERE idclientes=?;");
            ps.setInt(1, IdCliente);

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
