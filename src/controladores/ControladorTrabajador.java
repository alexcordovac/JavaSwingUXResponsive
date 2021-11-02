/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.EmpleadoDao;
import modelos.Empleado;

/**
 *
 * @author Alex
 */
public class ControladorTrabajador {
    
    EmpleadoDao empleadoDao;
    
    public ControladorTrabajador() {
        empleadoDao = new EmpleadoDao();
    }
    
    public int guardarEmpleado(Empleado empleadoTmp){
        int resultado = empleadoDao.insertarEmpleado(empleadoTmp);
        return resultado;
    }
    
    
    
}
