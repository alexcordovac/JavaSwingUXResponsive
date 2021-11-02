/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import controladores.ControladorGeneral;
import controladores.ControladorMenu;
import controladores.ControladorTrabajador;
import static formularios.TrabajadorTemporizador.multiplicador;
import static formularios.TrabajadorTemporizador.multiplicadorHora;
import static formularios.TrabajadorTemporizador.multiplicadorMinutos;
import static formularios.TrabajadorTemporizador.multiplicadorSegundos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import jiconfont.swing.IconFontSwing;
import modelos.Empleado;
import recursos.iconos.GoogleMaterialDesignIcons;
import utiles.Constantes;
import utiles.TextPrompt;

/**
 *
 * @author Alex
 */
public class FormTrabajador extends javax.swing.JPanel implements Runnable {

    //Id del formulario
    int IDFORM;

    //Timer
    public Timer timer;
    private long temporizador;
    private long tiempoFinal;
    private int timerLoop;
    private int random;
    private Empleado empleado;

    //Observable
    TrabajadorObservable trabajadorObservable;
    TrabajadorObserver observadores;
    
    //Variable para identificar cuando este formulario ya guardó el empleado creado
    private boolean empleadoGuardado = false;
    
    //Controlador general
    ControladorGeneral ctrlGeneral;

    /*Variable que es observada, a fin de que determine si ya este formulario
    está configurado (campos de texto llenados)*/
    /**
     * Creates new form FormTrabajador
     */
    public FormTrabajador(int IDFORM) {
        this.IDFORM = IDFORM;
        initComponents();
        pintarIconos();
        iniDocumentListener();
        trabajadorObservable = new TrabajadorObservable();
        observadores = new TrabajadorObserver(this);
        ctrlGeneral = new ControladorGeneral();
    }

    private void pintarIconos() {
        jLabel1.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.FACE, 70, Constantes.COLOR_LIGERO));
    }

    /*DocumentListener utilizado para detectar cuando el usuario escribe o borra texto,
        en los jtextfields, lanza el evento update a los observadores a través del método actualizarCamposLlenos*/
    private void iniDocumentListener() {
        DocumentListener dcListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                //Provocamos el evento del observable
                actualizarCamposLlenos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarCamposLlenos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        };

        txtNombreTrabajador.getDocument().addDocumentListener(dcListener);
        txtNombreCliente.getDocument().addDocumentListener(dcListener);
    }

    private void actualizarCamposLlenos() {
        if (!txtNombreCliente.getText().isEmpty()
                && !txtNombreTrabajador.getText().isEmpty()) {
            //Al cambiar la variable de se dispara el evento de que los campos están llenos o no
            trabajadorObservable.getCamposObservables().setCamposLlenos(true);
        } else {
            trabajadorObservable.getCamposObservables().setCamposLlenos(false);
        }
    }

    //Hilo
    @Override
    public void run() {
        //Ponemos en falso la variable trabajoFinalizadas, ya que es observada
        trabajadorObservable.getTrabajoFinalizadoObservable().setTrabajoFinalizado(false);

        //Numero random y calculo del tiempo final
        random = numeroAleatorio();
        this.tiempoFinal = ((TrabajadorTemporizador.jornada - 3) * TrabajadorTemporizador.multiplicador) + (random * TrabajadorTemporizador.multiplicador);

        //Actualizar la barra de progreso usando el Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                iniBarraProgreso();
                lblRelojIcono.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.SCHEDULE, 20, Color.WHITE));
                lblTiempoFinal.setText(TrabajadorTemporizador.format(tiempoFinal));
            }
        });

        iniTimer();
    }

    private int numeroAleatorio() {
        int min = -3;
        int max = 3;
        Random rand = new Random();
        int aleotorio = rand.nextInt((max - min) + 1) + min;
        return aleotorio;
    }

    private void iniTimer() {
        //El timer se repite cada 
        temporizador = 0;
        timerLoop = (multiplicador == multiplicadorHora) ? multiplicadorMinutos
                : (multiplicador == multiplicadorMinutos) ? multiplicadorMinutos
                        : (multiplicador == multiplicadorSegundos) ? multiplicadorSegundos : multiplicadorSegundos;

        timer = new Timer(timerLoop, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                temporizador += timerLoop; //se le suma el timerLoop (el tiempo en ms que tiene que ciclar el timerLoop)
                //Actualizar la barra de progreso
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        barraProgreso.setValue((int) temporizador);
                    }
                });

                if (temporizador >= tiempoFinal) {
                    trabajadorObservable.getTrabajoFinalizadoObservable().setTrabajoFinalizado(true);
                    lblMensaje.setForeground(Constantes.COLOR_LIGERO);
                    lblMensaje.setText("Finalicé mi jornada");
                    timer.stop();
                }
            }
        });
        timer.start();
    }
    
    //Función para inicializar la barra de progreso
    private void iniBarraProgreso() {
        barraProgreso.setStringPainted(true);
        barraProgreso.setValue(0);
        barraProgreso.setMaximum((int) this.tiempoFinal);
    }
    
    //Función para habilitar escribir en los campos de texto
    public void habilitarCampos() {
        txtNombreTrabajador.setEditable(true);
        txtNombreTrabajador.requestFocus(true);
        txtNombreCliente.setEditable(true);
        txtNombreCliente.requestFocus(true);
    }
    
    //Función para deshabilitar escribir en los campos de texto
    public void deshabilitarCampos() {
        txtNombreTrabajador.setEditable(false);
        txtNombreTrabajador.requestFocus(false);
        txtNombreCliente.setEditable(false);
        txtNombreCliente.requestFocus(false);
    }

    //Función para inicializar un empleado 
    public void crearEmpleado() {
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");;
        String fecha = sdf.format(PanelTrabajadorLayout.fecha);
        String nombre_trabajador = getTxtNombreTrabajador().getText();
        String nombre_cliente = getTxtNombreCliente().getText();
        int tiempo_trabajado =  (TrabajadorTemporizador.jornada -3) + random ;
        int comision_obtenida = (random == 0) ? 200 : 0;
        int descuentos_realizados = (random == 0) ? 0
                : (random > 0) ? 50 * random : (100 * random) * -1;
        int sueldo_total = 500 + comision_obtenida - descuentos_realizados;

        empleado = new Empleado(fecha, nombre_trabajador, nombre_cliente, tiempo_trabajado, comision_obtenida, descuentos_realizados, sueldo_total);
    }
    
    //Función para guardar un empleado
    public void guardarEmpleado() {
        crearEmpleado();
        try {
            ControladorTrabajador ctrlEmpleado = new ControladorTrabajador();
            int resultado = ctrlEmpleado.guardarEmpleado(empleado);
            if(resultado >0 ){
                empleadoGuardado = true;
                Thread.sleep(1000);
                ctrlGeneral.notificarMensaje(lblMensaje, 10000, "Guardado correctamente", Constantes.COLOR_LIGERO);
            }
            else{
                ctrlGeneral.notificarMensaje(lblMensaje, 10000, "Error guardando :(", Constantes.COLOR_LIGERO);
            }
        } catch (InterruptedException e) {
            ctrlGeneral.notificarMensaje(lblMensaje, 10000, "Error guardando :(", Constantes.COLOR_LIGERO);
        }

    }

    /*GETTER y SETTERS*/
    public TrabajadorObservable getTrabajadorObservable() {
        return trabajadorObservable;
    }

    public void setTrabajadorObservable(TrabajadorObservable trabajadorObservable) {
        this.trabajadorObservable = trabajadorObservable;
    }

    public JTextField getTxtNombreCliente() {
        return txtNombreCliente;
    }

    public void setTxtNombreCliente(JTextField txtNombreCliente) {
        this.txtNombreCliente = txtNombreCliente;
    }

    public JTextField getTxtNombreTrabajador() {
        return txtNombreTrabajador;
    }

    public void setTxtNombreTrabajador(JTextField txtNombreTrabajador) {
        this.txtNombreTrabajador = txtNombreTrabajador;
    }

    public int getIDFORM() {
        return IDFORM;
    }

    public JLabel getLblMensaje() {
        return lblMensaje;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public boolean getEmpleadoGuardado() {
        return empleadoGuardado;
    }
    
    public void setEmpleadoGuardado(boolean empleadoGuardado) {
        this.empleadoGuardado = empleadoGuardado;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(50, 50);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics.setColor(getBackground());
                graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); //paint background
                graphics.setColor(getForeground());
            }

        };
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreTrabajador = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        barraProgreso = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        lblTiempoFinal = new javax.swing.JLabel();
        lblRelojIcono = new javax.swing.JLabel();

        setBackground(Constantes.COLOR_BEIGE);
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        setPreferredSize(new java.awt.Dimension(216, 300));
        setLayout(new java.awt.CardLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(250, 350));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(Constantes.COLOR_PRIMARIO);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre del trabajador "+IDFORM+":");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtNombreTrabajador.setBackground(new java.awt.Color(255, 255, 255, 0));
        txtNombreTrabajador.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreTrabajador.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txtNombreTrabajador.setOpaque(false);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre del cliente "+IDFORM+":");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtNombreCliente.setBackground(new java.awt.Color(255, 255, 255, 0));
        txtNombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblMensaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblTiempoFinal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTiempoFinal.setForeground(new java.awt.Color(255, 255, 255));

        lblRelojIcono.setForeground(new java.awt.Color(255, 255, 255));
        lblRelojIcono.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRelojIcono.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(48, 48, 48))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNombreTrabajador)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNombreCliente)
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 62, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRelojIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTiempoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(barraProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTiempoFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(lblRelojIcono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        TextPrompt phNombreTrabajador = new TextPrompt("Nombre del trabajador "+IDFORM, txtNombreTrabajador);
        phNombreTrabajador.changeAlpha(0.75f);
        phNombreTrabajador.changeStyle(Font.ITALIC);
        TextPrompt phNombreCliente = new TextPrompt("Nombre del cliente "+IDFORM, txtNombreCliente);
        phNombreCliente.changeAlpha(0.75f);
        phNombreCliente.changeStyle(Font.ITALIC);

        jPanel1.add(jPanel2, new java.awt.GridBagConstraints());

        jPanel1.setBackground(Constantes.COLOR_PRIMARIO);
        jPanel1.setOpaque(false);

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblRelojIcono;
    private javax.swing.JLabel lblTiempoFinal;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreTrabajador;
    // End of variables declaration//GEN-END:variables
}
