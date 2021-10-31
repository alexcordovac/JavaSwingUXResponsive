/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Date;

/**
 *
 * @author Alex
 */
public class Empleado {
    private int id_comision;
    private String fecha;
    private String nombre_trabajador;
    private String nombre_cliente;
    private int tiempo_trabajado;
    private int comision_obtenida;
    private int descuentos_realizados;
    private int sueldo_total;

    public Empleado() {
    }

    public Empleado(String fecha, String nombre_trabajador, String nombre_cliente, int tiempo_trabajado, int comision_obtenida, int descuentos_realizados, int sueldo_total) {
        this.fecha = fecha;
        this.nombre_trabajador = nombre_trabajador;
        this.nombre_cliente = nombre_cliente;
        this.tiempo_trabajado = tiempo_trabajado;
        this.comision_obtenida = comision_obtenida;
        this.descuentos_realizados = descuentos_realizados;
        this.sueldo_total = sueldo_total;
    }
    

    public Empleado(int id_comision, String fecha, String nombre_trabajador, String nombre_cliente, int tiempo_trabajado, int comision_obtenida, int descuentos_realizados, int sueldo_total) {
        this.id_comision = id_comision;
        this.fecha = fecha;
        this.nombre_trabajador = nombre_trabajador;
        this.nombre_cliente = nombre_cliente;
        this.tiempo_trabajado = tiempo_trabajado;
        this.comision_obtenida = comision_obtenida;
        this.descuentos_realizados = descuentos_realizados;
        this.sueldo_total = sueldo_total;
    }

    public int getId_comision() {
        return id_comision;
    }

    public void setId_comision(int id_comision) {
        this.id_comision = id_comision;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre_trabajador() {
        return nombre_trabajador;
    }

    public void setNombre_trabajador(String nombre_trabajador) {
        this.nombre_trabajador = nombre_trabajador;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public int getTiempo_trabajado() {
        return tiempo_trabajado;
    }

    public void setTiempo_trabajado(int tiempo_trabajado) {
        this.tiempo_trabajado = tiempo_trabajado;
    }

    public int getComision_obtenida() {
        return comision_obtenida;
    }

    public void setComision_obtenida(int comision_obtenida) {
        this.comision_obtenida = comision_obtenida;
    }

    public int getDescuentos_realizados() {
        return descuentos_realizados;
    }

    public void setDescuentos_realizados(int descuentos_realizados) {
        this.descuentos_realizados = descuentos_realizados;
    }

    public int getSueldo_total() {
        return sueldo_total;
    }

    public void setSueldo_total(int sueldo_total) {
        this.sueldo_total = sueldo_total;
    }
    
}
