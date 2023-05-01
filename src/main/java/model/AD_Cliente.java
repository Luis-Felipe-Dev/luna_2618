/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author luisf
 */
public class AD_Cliente {
    private PreparedStatement pst; //prepara el codigo o consulta SQL, con parametors y lo ejecuta
    private ResultSet rst; //se guarda el resultado de un SELECT
    private CallableStatement cst; //para ejecutar store procedures
    
    public boolean insertar(Cliente cliente) throws SQLException{
        boolean resultado = false; //si es exitosa la ejecucion del insertar
        Connection Conexion = null;
        try {
            Conexion = ConnectionPool.getInstance().getConnection();
            if (Conexion != null) {
                String SQL = "INSERT INTO cliente(nombres_razonsocial, tipo_documentoidentidad,"
                        + "numero_documentoidentidad, direccion, pais, email, telefono) "
                        + "VALUES(?, ?, ?, ?, ?, ?, ?)";
                pst = Conexion.prepareStatement(SQL);
                //agregar los valores al los parametros
                pst.setString(1, cliente.getNombres_razonsocial());
                pst.setString(2, cliente.getTipo_documentoidentidad());
                pst.setString(3, cliente.getNumero_documentoidentidad());
                pst.setString(4, cliente.getDireccion());
                pst.setString(5, cliente.getPais());
                pst.setString(6, cliente.getEmail());
                pst.setString(7, cliente.getTelefono());
                int res = 0;
                res = pst.executeUpdate(); //ejecutamos el query
                
                if (res > 0) {
                    resultado = true;
                }else{
                    resultado = false;
                }
                
            } else {
                System.out.println("Error en la conexion a base de datos");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            ConnectionPool.getInstance().closeConnection(Conexion);
        }
        return resultado;
    }
    
    public ArrayList<Cliente> listar(){
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
        } catch (Exception e) {
        } finally {
        }
        return lista;
    }
    
}
