package chatserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    private int id = -1;
    private String Nombre;
    private Socket socket;
    private DataInputStream flujoE;
    private DataOutputStream flujoS;

    public Cliente(String host, int port) {
        try {
            socket = new Socket(host, port);
            flujoE = new DataInputStream(socket.getInputStream());
            flujoS = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
        }
    }

    public Cliente(int id, String Nombre) {
        this.Nombre = Nombre;
        this.id = id;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public DataInputStream getFlujoE() {
        return flujoE;
    }

    public void setFlujoE(DataInputStream flujoE) {
        this.flujoE = flujoE;
    }

    public DataOutputStream getFlujoS() {
        return flujoS;
    }

    public void setFlujoS(DataOutputStream flujoS) {
        this.flujoS = flujoS;
    }

    public void cerrarFlujos() {
        try {
            flujoE.close();
            flujoS.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", Nombre=" + Nombre + ", socket=" + socket + ", flujoE=" + flujoE + ", flujoS=" + flujoS + '}';
    }

}
