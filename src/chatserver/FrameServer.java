package chatserver;

public class FrameServer extends javax.swing.JFrame {

    private int x, y;
    private FrameCliente frameCliente;
    private Servidor chatserver;
    
    public FrameServer() {
        initComponents();
        chatserver = new Servidor(5000);
        chatserver.starService();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btChat = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        fondoServer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 300));
        setMinimumSize(new java.awt.Dimension(400, 300));
        setName("serverFrame"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(400, 300));
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

        btChat.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btChat.setForeground(new java.awt.Color(255, 255, 255));
        btChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/chat.png"))); // NOI18N
        btChat.setText("Nuevo Chat");
        btChat.setBorder(null);
        btChat.setBorderPainted(false);
        btChat.setContentAreaFilled(false);
        btChat.setFocusPainted(false);
        btChat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btChat.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/chatPulsado.png"))); // NOI18N
        btChat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChatActionPerformed(evt);
            }
        });
        getContentPane().add(btChat);
        btChat.setBounds(140, 90, 120, 140);

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
        btSalir.setBounds(330, 20, 50, 50);

        fondoServer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoEntrada.png"))); // NOI18N
        fondoServer.setMaximumSize(new java.awt.Dimension(400, 600));
        fondoServer.setMinimumSize(new java.awt.Dimension(400, 600));
        fondoServer.setPreferredSize(new java.awt.Dimension(400, 600));
        getContentPane().add(fondoServer);
        fondoServer.setBounds(0, 0, 400, 380);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int xAux = evt.getXOnScreen();
        int yAux = evt.getYOnScreen();
        this.setLocation(xAux - this.x, yAux - this.y);
    }//GEN-LAST:event_formMouseDragged

    private void btSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btSalirActionPerformed

    private void btChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChatActionPerformed
        frameCliente = new FrameCliente(chatserver);
        frameCliente.startClient("localhost", 5000);
    }//GEN-LAST:event_btChatActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameServer().setVisible(true);
 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btChat;
    private javax.swing.JButton btSalir;
    private javax.swing.JLabel fondoServer;
    // End of variables declaration//GEN-END:variables

   
}
