/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.EmpleadoDao;
import formularios.FormRecordObtenidos;
import java.util.List;
import modelos.Empleado;

/**
 *
 * @author Alex
 */
public class ControladorRegistros {
    
    FormRecordObtenidos vista;
    EmpleadoDao empleadoDao;

    public ControladorRegistros() {
        empleadoDao = new EmpleadoDao();
    }

    public ControladorRegistros(FormRecordObtenidos vista) {
        this();
        this.vista = vista;
        pintarTabla();
    }
    
    public List<Empleado> obtenerListaEmpleados(){
        return empleadoDao.obtenerEmpleados();
    }
    
    public void pintarTabla(){
        List<Empleado> lista = obtenerListaEmpleados();
        vista.cargarRegistrosTabla(lista);
    }
}
