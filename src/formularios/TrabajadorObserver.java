/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import controladores.ControladorGeneral;
import java.util.Observable;
import java.util.Observer;
import utiles.Constantes;

/**
 *
 * @author Alex
 */
public class TrabajadorObserver {

    FormTrabajador formTrabajador;
    ControladorGeneral ctrlGeneral;
    
    public TrabajadorObserver(FormTrabajador formTrabajador) {
        //Agregar TrabajadorObserver a los Observados
        this.formTrabajador = formTrabajador;
        this.formTrabajador.getTrabajadorObservable().getCamposObservables().addObserver(new ObservadorCamposLlenos());
        this.formTrabajador.getTrabajadorObservable().getTrabajoFinalizadoObservable().addObserver(new ObservadorTrabajadorFinalizado());
        ctrlGeneral = new ControladorGeneral();
    }

    private class ObservadorCamposLlenos implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            PanelTrabajadorLayout.activarBotones = true;
            for (FormTrabajador formTrabajador : PanelTrabajadorLayout.listaFormTrabajadores) {
                if (formTrabajador.trabajadorObservable.getCamposObservables().getCamposLlenos() == false) {
                    PanelTrabajadorLayout.activarBotones = false;
                    break;
                }
            }
        }
    }

    private class ObservadorTrabajadorFinalizado implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            boolean detenerTemporizador = true;
            for (FormTrabajador formTrabajador : PanelTrabajadorLayout.listaFormTrabajadores) {
                if (formTrabajador.trabajadorObservable.getTrabajoFinalizadoObservable().getTrabajoFinalizado() == false) {
                    detenerTemporizador = false;
                    break;
                }
            }

            if (detenerTemporizador) {
                for (FormTrabajador formTrabajador : PanelTrabajadorLayout.listaFormTrabajadores) {
                   formTrabajador.habilitarCampos();
                }
                
                //Detenemos el temporizador
                TrabajadorTemporizador.timer.stop();
                
                //Destacamos que ya se puede guardar los registros 
                PanelTrabajadorLayout.destacarBoton.start();
                
                //Indicamos que ya fueron terminadas todas las jornadas
                TrabajadorTemporizador.jornadasTerminadas = true;
                
                //Mandamos un mensaje
                ctrlGeneral.notificarMensaje(TrabajadorTemporizador.lblMensaje, 5000, "¡Trabajos finalizados!", Constantes.COLOR_SUCCESS);
            }
        }
    }

}
