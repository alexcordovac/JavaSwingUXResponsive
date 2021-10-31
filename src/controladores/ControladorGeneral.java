/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author Alex
 */
public class ControladorGeneral {
    private Timer notificacion = new Timer(0, null);
    
    //Función para ocultar un JLabel, generalmente usada como un logger
    public void notificarMensaje(JLabel label, int tiempo, String mensaje, Color co){
        if(notificacion.isRunning()){
            notificacion.stop();
        }
        
        SwingUtilities.invokeLater(() ->{
            label.setForeground(co);
            label.setText(mensaje);
        });
        
        ActionListener tarea = (ActionEvent evt) -> {
            label.setText("");
        };
        
        notificacion = new Timer(tiempo, tarea);
        notificacion.setRepeats(false);
        notificacion.start();
    }
}
