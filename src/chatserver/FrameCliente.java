package chatserver;

import java.io.IOException;

public class FrameCliente extends javax.swing.JFrame {

    private int x, y;
    private boolean run = true;
    private Thread hebraLecturaCliente;
    private Cliente cliente;
    private Servidor chatserver;

    public FrameCliente(Servidor chatserver) {
        initComponents();
        this.chatserver = chatserver;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tvm = new javax.swing.JTextField();
        nomUsuario = new javax.swing.JLabel();
        btEnviar = new javax.swing.JButton();
        panelChat = new javax.swing.JScrollPane();
        taText = new javax.swing.JTextArea();
        btSalir = new javax.swing.JButton();
        btPrivado = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 500));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(400, 500));
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(tvm);
        tvm.setBounds(5, 350, 390, 24);

        nomUsuario.setFont(new java.awt.Font("Raizen Anthem", 0, 24)); // NOI18N
        nomUsuario.setForeground(new java.awt.Color(255, 255, 255));
        nomUsuario.setToolTipText("");
        getContentPane().add(nomUsuario);
        nomUsuario.setBounds(10, 20, 120, 30);

        btEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Enviar.png"))); // NOI18N
        btEnviar.setBorder(null);
        btEnviar.setBorderPainted(false);
        btEnviar.setContentAreaFilled(false);
        btEnviar.setFocusPainted(false);
        btEnviar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/EnviarPulsado.png"))); // NOI18N
        btEnviar.setRequestFocusEnabled(false);
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(btEnviar);
        btEnviar.setBounds(240, 410, 70, 70);

        taText.setEditable(false);
        taText.setColumns(20);
        taText.setRows(5);
        panelChat.setViewportView(taText);

        getContentPane().add(panelChat);
        panelChat.setBounds(5, 70, 390, 270);

        btSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cerrar.png"))); // NOI18N
        btSalir.setBorder(null);
        btSalir.setContentAreaFilled(false);
        btSalir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/CerrarPulsado.png"))); // NOI18N
        btSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btSalir);
        btSalir.setBounds(340, 10, 50, 50);

        btPrivado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/privado.png"))); // NOI18N
        btPrivado.setBorder(null);
        btPrivado.setBorderPainted(false);
        btPrivado.setContentAreaFilled(false);
        btPrivado.setMaximumSize(new java.awt.Dimension(70, 70));
        btPrivado.setMinimumSize(new java.awt.Dimension(70, 70));
        btPrivado.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/privadoPulsado.png"))); // NOI18N
        btPrivado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrivadoActionPerformed(evt);
            }
        });
        getContentPane().add(btPrivado);
        btPrivado.setBounds(320, 410, 70, 70);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoChat.png"))); // NOI18N
        fondo.setPreferredSize(new java.awt.Dimension(400, 400));
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 400, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        escrituraCliente();
    }//GEN-LAST:event_btEnviarActionPerformed

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        taText.setText("Boot de la sala: " + cliente.getNombre() + " ha abandonado la sala \n");
        cierraCliente();
        cliente.cerrarFlujos();
        this.dispose();
    }//GEN-LAST:event_btSalirActionPerformed

    private void cierraCliente() {
        for (int i = 0; i < chatserver.getListaSocketsServidor().size(); i++) {
            if (cliente.getId() == chatserver.getListaSocketsServidor().get(i).getIdCliente()) {
                chatserver.getListaSocketsServidor().get(i).setNombreServidorCliente("");
            }
        }
    }

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int xAux = evt.getXOnScreen();
        int yAux = evt.getYOnScreen();
        this.setLocation(xAux - this.x, yAux - this.y);
    }//GEN-LAST:event_formMouseDragged

    private void btPrivadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrivadoActionPerformed
        ListaClientes listaClientes = new ListaClientes(this, true, chatserver, cliente);
        listaClientes.setVisible(true);
    }//GEN-LAST:event_btPrivadoActionPerformed

    private void escrituraCliente() {
        if (!tvm.getText().equals("")) {
            try {
                cliente.getFlujoS().writeUTF(tvm.getText());
            } catch (IOException ex) {
                System.out.println("btEnviar " + ex.getLocalizedMessage());
            }
            tvm.setText("");
        }
    }

    public void startClient(String host, int port) {
        cliente = new Cliente(host, port);
        creaNombre();
        mandaNombre();
        if (cliente.getNombre() != null) {
            obtenIdCliente();
            lecturaCliente();
            ponNombre();
            this.setVisible(true);
        } else {
            this.dispose();
        }
    }

    private void ponNombre() {
        nomUsuario.setText(cliente.getNombre());
    }

    private void mandaNombre() {
        tvm.setText(cliente.getNombre());
        escrituraCliente();
        tvm.setText("");

    }

    private void creaNombre() {
        PanelNombreCliente panelNombreCliente = new PanelNombreCliente(this, true, cliente);
        panelNombreCliente.setVisible(true);
        this.dispose();
    }

    private void obtenIdCliente() {
        String text;
        try {
            text = cliente.getFlujoE().readUTF();
            if (cliente.getId() == -1) {
                cliente.setId(Integer.parseInt(text));
            }
        } catch (IOException ex) {
            System.out.println("Obtener ID Cliente" + ex.getLocalizedMessage());
        }
    }

    private void lecturaCliente() {
        hebraLecturaCliente = new Thread() {
            @Override
            public void run() {
                String text;
                while (run) {
                    try {
                        text = cliente.getFlujoE().readUTF();
                        taText.append(text);
                    } catch (IOException ex) {
                        System.out.println("Lectura cliente" + ex.getLocalizedMessage());
                        run = false;
                    }
                }
            }
        };
        hebraLecturaCliente.start();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEnviar;
    private javax.swing.JButton btPrivado;
    private javax.swing.JButton btSalir;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel nomUsuario;
    private javax.swing.JScrollPane panelChat;
    private javax.swing.JTextArea taText;
    private javax.swing.JTextField tvm;
    // End of variables declaration//GEN-END:variables

}
