package chatserver;

public class PanelNombreCliente extends javax.swing.JDialog {

    private Cliente cliente;

    public PanelNombreCliente(java.awt.Frame parent, boolean modal, Cliente cliente) {
        super(parent, modal);
        initComponents();
        this.cliente = cliente;
        campoNombre.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNombre = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        btAceptar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 200));
        setName("nombreChat"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        labelNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/labelNombre.png"))); // NOI18N
        getContentPane().add(labelNombre);
        labelNombre.setBounds(30, 20, 340, 60);
        getContentPane().add(campoNombre);
        campoNombre.setBounds(20, 90, 360, 24);

        btAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptar.png"))); // NOI18N
        btAceptar.setBorder(null);
        btAceptar.setBorderPainted(false);
        btAceptar.setContentAreaFilled(false);
        btAceptar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aceptarPulsado.png"))); // NOI18N
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btAceptar);
        btAceptar.setBounds(130, 130, 50, 50);

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Cancelar.png"))); // NOI18N
        btCancelar.setBorder(null);
        btCancelar.setBorderPainted(false);
        btCancelar.setContentAreaFilled(false);
        btCancelar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelarPulsado.png"))); // NOI18N
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btCancelar);
        btCancelar.setBounds(220, 130, 50, 50);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoEntrada.png"))); // NOI18N
        fondo.setMaximumSize(new java.awt.Dimension(400, 200));
        fondo.setMinimumSize(new java.awt.Dimension(400, 200));
        fondo.setPreferredSize(new java.awt.Dimension(400, 200));
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 400, 200);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
         if (campoNombre.getText().compareTo("") != 0) {
            cliente.setNombre(campoNombre.getText());
            this.dispose();
        } 
    }//GEN-LAST:event_btAceptarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        cliente.setNombre(null);
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel labelNombre;
    // End of variables declaration//GEN-END:variables
}
