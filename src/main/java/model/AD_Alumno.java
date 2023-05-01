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
 * @author Luis-Felipe-Dev
 */
public class AD_Alumno {
    private PreparedStatement pst; //prepara el codigo o consulta SQL, con parametors y lo ejecuta
    private ResultSet rst; //se guarda el resultado de un SELECT
    private CallableStatement cst; //para ejecutar store procedures
    
    public boolean insertar(Alumno alumno) throws SQLException{
        boolean resultado = false; //si es exitosa la ejecucion del insertar
        Connection Conexion = null;
        try {
            Conexion = ConnectionPool.getInstance().getConnection();
            if (Conexion != null) {
                
                String SQL = "INSERT INTO alumno(nombre, apellidos, dni, carrera, periodo) "
                        + "VALUES(?, ?, ?, ?, ?)";
                pst = Conexion.prepareStatement(SQL);
                //agregar los valores al los parametros
                pst.setString(1, alumno.getNombres());
                pst.setString(2, alumno.getApellidos());
                pst.setString(3, alumno.getDni());
                pst.setString(4, alumno.getCarrera());
                pst.setString(5, alumno.getPeriodo());
                
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
    
    public ArrayList<Alumno> listar(){
        ArrayList<Alumno> lista = new ArrayList<>();
        try {
            
        } catch (Exception e) {
        } finally {
        }
        return lista;
    }
    
}
