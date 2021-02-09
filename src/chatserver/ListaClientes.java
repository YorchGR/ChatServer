package chatserver;

public class ListaClientes extends javax.swing.JDialog {

    private Servidor chatserver;
    private Cliente cliente;
    private int x, y;

    public ListaClientes(java.awt.Frame parent, boolean modal, Servidor chatserver, Cliente cliente) {
        super(parent, modal);
        initComponents();
        this.chatserver = chatserver;
        this.cliente = cliente;
        limpiaClientes();
        muestraClientes();
    }

    private void muestraClientes() {
        for (int i = 0; i < chatserver.getListaSocketsServidor().size(); i++) {
            if (!cliente.getNombre().equals(chatserver.getListaSocketsServidor().get(i).getNombreServidorCliente())) {
                taText.append("Usuario: "+chatserver.getListaSocketsServidor().get(i).getNombreServidorCliente()+"\n");
            }  
        }   
    }

    private void limpiaClientes() {
        for (int i = 0; i < chatserver.getListaSocketsServidor().size(); i++) {
            if (chatserver.getListaSocketsServidor().get(i).getNombreServidorCliente().equals("")) {
                chatserver.getListaSocketsServidor().remove(i);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelChat = new javax.swing.JScrollPane();
        taText = new javax.swing.JTextArea();
        btSalir = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 390));
        setMinimumSize(new java.awt.Dimension(400, 390));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(400, 390));
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

        panelChat.setAutoscrolls(true);

        taText.setEditable(false);
        taText.setColumns(20);
        taText.setRows(5);
        panelChat.setViewportView(taText);

        getContentPane().add(panelChat);
        panelChat.setBounds(5, 130, 390, 249);

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

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondolista.png"))); // NOI18N
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 400, 600);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int xAux = evt.getXOnScreen();
        int yAux = evt.getYOnScreen();
        this.setLocation(xAux - this.x, yAux - this.y);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalir;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane panelChat;
    private javax.swing.JTextArea taText;
    // End of variables declaration//GEN-END:variables
}
