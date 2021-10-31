/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Empleado;

/**
 *
 * @author Alex
 */
public class EmpleadoDao {

    public EmpleadoDao() {
    }

    public List<Empleado> obtenerEmpleados() {
        Connection con;
        Statement st;
        ResultSet rs;
        String query = "SELECT * FROM empleados";

        List<Empleado> listaEmpleados = new ArrayList<>();

        try {
            con = Conexion.conectar();
            st = con.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                int id_comision = rs.getInt(1);
                String fecha = rs.getString(2);
                String nombre_trabajador = rs.getString(3);
                String nombre_cliente = rs.getString(4);
                int tiempo_trabajador = rs.getInt(5);
                int comision_obtenida = rs.getInt(6);
                int descuentos_realizados = rs.getInt(7);
                int sueldo_total = rs.getInt(8);

                Empleado empleadoTmp = new Empleado(id_comision, fecha, nombre_trabajador,
                        nombre_cliente, tiempo_trabajador, comision_obtenida, descuentos_realizados,
                        sueldo_total);

                listaEmpleados.add(empleadoTmp);
            }

            return listaEmpleados;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: Clase EmpleadoDao/obtenerEmpleados");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public int insertarEmpleado(Empleado empleadoTmp) {
        PreparedStatement stm;
        Connection con;

        String sql = "INSERT INTO empleados(fecha, nombre_trabajador, nombre_cliente, "
                + "tiempo_trabajado, comision_obtenida, descuentos_realizados, "
                + "sueldototal) VALUES (?,?,?,?,?,?,?)";
        try {
            con = Conexion.conectar();
            stm = con.prepareStatement(sql);
            stm.setString(1, empleadoTmp.getFecha());
            stm.setString(2, empleadoTmp.getNombre_trabajador());
            stm.setString(3, empleadoTmp.getNombre_cliente());
            stm.setInt(4, empleadoTmp.getTiempo_trabajado());
            stm.setInt(5, empleadoTmp.getComision_obtenida());
            stm.setInt(6, empleadoTmp.getDescuentos_realizados());
            stm.setInt(7, empleadoTmp.getSueldo_total());
           
            int filas = stm.executeUpdate();
            System.out.println("Empleado "+empleadoTmp.getNombre_trabajador()+" agregado. Filas afectadas: " + filas);
            stm.close();
            Conexion.desconectar();
            return filas;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Clase EmpleadoDao/insertarEmpleado");
            System.out.println(e.getMessage());
        }
        return -1;
    }
    
    

}
