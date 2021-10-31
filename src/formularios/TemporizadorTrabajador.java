/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import controladores.ControladorGeneral;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.Timer;
import utiles.Constantes;

/**
 *
 * @author Alex
 */
public class TemporizadorTrabajador {

    //Constantes
    /*Se utilizan para definir qué unidad se está manejando,
     en la variable tiempoFinal por ejemplo, 
        se pone n (tiempo que queremos que dure el temporizador) * multiplicador
        ej. 7 * multiplicador(multiplicadorMinutos) serían 7 minutos convertidos en milisegundos*/
    public static final int multiplicadorHora = 1000 * 60 * 60; //multiplicador hora
    public static final int multiplicadorMinutos = 1000 * 60; //multiplicador minutos
    public static final int multiplicadorSegundos = 1000; //multiplicador segundos
    public static int multiplicador = multiplicadorMinutos; // 

    //Constantes para el temporizador jlabel, es decir el texto
    private static String formatIzquierda = (multiplicador == multiplicadorHora) ? "h"
            : (multiplicador == multiplicadorMinutos) ? "m" : "m";
    private static String formatDerecha = (multiplicador == multiplicadorHora) ? "m"
            : (multiplicador == multiplicadorMinutos) ? "s" : "s";

    //Temporizador
    public static long tiempoInicial;
    public static long temporizador;
    public static int jornada;
    //Duración del reloj es 8 minutos (porque el multiplicador está en minutos)
    public static long tiempoFinal; //dependiento del multiplicador serán N horas o minutos o segundos

    public static Timer timer = new Timer(0,null); 
   //Variable que determina cada cuanto se debe ir actualizando el temporizador
    public static int timerLoop;

    //Label donde se va a pintar el temporizador
    JLabel label;

    //Label donde se va a pintar mensaje de error, etc
    public static JLabel lblMensaje;

    //Lista de formulariosTrbajador
    List<FormTrabajador> listaFormTrabajadores;
    
    //Controlador general
    ControladorGeneral ctrlGeneral;
    
    /*Constructor*/
    public TemporizadorTrabajador(JLabel label, JLabel lblMensaje, List<FormTrabajador> lista) {
        this.label = label;
        this.lblMensaje = lblMensaje;
        this.listaFormTrabajadores = lista;
        label.setText("00" + formatIzquierda + " 00" + formatDerecha);
        ctrlGeneral = new ControladorGeneral();
    }

    /*Métodos*/
 /*Método para inicializar el timer, es decir, darle función*/
    private void iniTimer() {
        //El timer se repite cada timerLoop(milisegundos)
        timer = new Timer(timerLoop, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temporizador += timerLoop; //se le suma el timerLoop (el tiempo en ms que tiene que ciclar el timerLoop)
                label.setText(format(temporizador));
                if (temporizador >= tiempoFinal) {
                    PanelTrabajadorLayout.destacarBoton.start();
                    timer.stop();
                    habiitarFormularioTrabajador();
                    ctrlGeneral.notificarMensaje(lblMensaje, 5000, "¡Trabajos finalizados!", Constantes.COLOR_SUCCESS);
                }
            }
        });
        timer.start();
    }

    /*Método para formatear el temporizador*/
    public static String format(Long temporizador) {
        long izquierda;
        long derecha;

        if (multiplicador == multiplicadorHora) {
            izquierda = TimeUnit.MILLISECONDS
                    .toHours(temporizador);
            temporizador -= TimeUnit.HOURS.toMillis(izquierda);

            derecha = TimeUnit.MILLISECONDS
                    .toMinutes(temporizador);
        } else {
            izquierda = TimeUnit.MILLISECONDS
                    .toMinutes(temporizador);
            temporizador -= TimeUnit.MINUTES.toMillis(izquierda);

            derecha = TimeUnit.MILLISECONDS
                    .toSeconds(temporizador);
        }
        return String.format("%02d" + formatIzquierda + " %02d" + formatDerecha, izquierda, derecha);
    }

    /*Método para empezar a correr el temporizador*/
    public void empezarTemporizador() {
        //Si el timer no está inicializado o está en ejecución que el click no haga nada
        if (timer.isRunning()) {
            ctrlGeneral.notificarMensaje(lblMensaje, 5000, "¡Jornada en curso!", Constantes.COLOR_OK);
            return;
        }
        tiempoInicial = System.currentTimeMillis();
        temporizador = 0;
        iniTimer();
        resetFormularioTrabajador();
        ctrlGeneral.notificarMensaje(lblMensaje, 5000, "¡Temporizador inicializado!", Constantes.COLOR_SUCCESS);
        
        //Empezamos hilos del form trabajador
        for (FormTrabajador formTrabajador : listaFormTrabajadores) {
            formTrabajador.setEmpleadoGuardado(false);
            Thread threadTmp = new Thread(formTrabajador);
            threadTmp.setName("Thread-Trabajador" + formTrabajador.getIDFORM());
            threadTmp.start();
        }
    }

    private void resetFormularioTrabajador() {
        for (FormTrabajador formTrabajador : listaFormTrabajadores) {
            formTrabajador.deshabilitarCampos();
            formTrabajador.getLblMensaje().setText("");
        }
    }
    
    private void habiitarFormularioTrabajador() {
        for (FormTrabajador formTrabajador : listaFormTrabajadores) {
            formTrabajador.habilitarCampos();
        }
    }
}
