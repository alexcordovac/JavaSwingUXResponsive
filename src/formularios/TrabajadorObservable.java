/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import java.util.Observable;

/**
 *
 * @author Alex 
 * 
 */
public class TrabajadorObservable {
    private CamposObservable camposObservables;
    private TrabajoFinalizadoObservable trabajoFinalizadoObservable;

    public TrabajadorObservable() {
        camposObservables = new CamposObservable();
        trabajoFinalizadoObservable = new TrabajoFinalizadoObservable();
    }
    
    /*Getters y Setters*/

    public CamposObservable getCamposObservables() {
        return camposObservables;
    }

    public void setCamposObservables(CamposObservable camposObservables) {
        this.camposObservables = camposObservables;
    }

    public TrabajoFinalizadoObservable getTrabajoFinalizadoObservable() {
        return trabajoFinalizadoObservable;
    }

    public void setTrabajoFinalizadoObservable(TrabajoFinalizadoObservable trabajoFinalizadoObservable) {
        this.trabajoFinalizadoObservable = trabajoFinalizadoObservable;
    }
    
    /*Clases observables*/
    
    /*Variable observable para saber cuando los campos han sido llenados*/
    public class CamposObservable extends Observable{

        private boolean camposLlenos;

        public CamposObservable() {
        }

        public CamposObservable(boolean ready) {
            this.camposLlenos = ready;
        }

        public boolean getCamposLlenos() {
            return camposLlenos;
        }

        public void setCamposLlenos(boolean camposLlenos) {
            this.camposLlenos = camposLlenos;

            //Notificamos al observador
            setChanged();
            notifyObservers();
        }
    }
    
    /*Variable observable para saber cuando el trabajo ha sido finalizado*/
    public class TrabajoFinalizadoObservable extends Observable{

        private boolean trabajoFinalizado;

        public TrabajoFinalizadoObservable() {
        }

        public TrabajoFinalizadoObservable(boolean finalizado) {
            this.trabajoFinalizado = finalizado;
        }

        public boolean getTrabajoFinalizado() {
            return trabajoFinalizado;
        }

        public void setTrabajoFinalizado(boolean trabajoFinalizado) {
            this.trabajoFinalizado = trabajoFinalizado;

            //Notificamos al observador
            setChanged();
            notifyObservers();
        }

    }

}
