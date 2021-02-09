package chatserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServidorThreads extends Thread {

    private int id;
    private final Socket socketServidor;
    private Servidor servidor;
    private boolean run = true;
    private String nombreServidorCliente = "";
    private DataInputStream flujoE;
    private DataOutputStream flujoS;
    private char separador = ':';

    public ServidorThreads(Socket sokectServidor, Servidor server) {
        this.servidor = server;
        this.socketServidor = sokectServidor;
        try {
            flujoE = new DataInputStream(socketServidor.getInputStream());
            flujoS = new DataOutputStream(socketServidor.getOutputStream());
        } catch (IOException ex) {
            System.out.println("ChatServerThread constructor " + ex.getLocalizedMessage());
        }
    }

    @Override
    public void run() {
        String text;
        while (run) {
            try {
                text = flujoE.readUTF();
                if (nombreServidorCliente.isEmpty()) {
                    setNombreServidorCliente(text);
                    send(String.valueOf(getIdCliente()));
                    servidor.broadcast("Boot de la sala: " + getNombreServidorCliente() + " se ha unido a la sala \n");
                } else if (compruebaListaClientes(text)) {
                    devuelveListaClientes();
                } else if (!analizaCadena(text)) {
                    servidor.broadcast(nombreServidorCliente + ": " + text + "\n");
                } else {
                    servidor.sacaNombre(text, nombreServidorCliente);
                }
            } catch (IOException ex) {
                System.out.println("ChatServerThread run " + ex.getLocalizedMessage());
                servidor.broadcast("Boot de la sala: alguien ha abandonado la sala \n");
                setNombreServidorCliente("");
                closeServerThread();
            }
        }
    }

    private boolean compruebaListaClientes(String text) {
        return text.equals("+");
    }

    private void devuelveListaClientes() {
        String cad = ":";
        for (ServidorThreads servidorThreads : servidor.getListaSocketsServidor()) {
            cad += servidorThreads.getNombreServidorCliente() + separador;
        }
        send(cad);
    }

    private boolean analizaCadena(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == separador) {
                return true;
            }
        }
        return false;
    }

    void send(String text) {
        try {
            flujoS.writeUTF(text);
            flujoS.flush();//Siempre por el write. Garantiza que se escribe toda la cadena
        } catch (IOException ex) {
            System.out.println("ChatServerThread send " + ex.getLocalizedMessage());
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return id;
    }

    public String getNombreServidorCliente() {
        return nombreServidorCliente;
    }

    public void setNombreServidorCliente(String nombreServidorCliente) {
        this.nombreServidorCliente = nombreServidorCliente;
    }

    private void closeServerThread() {
        try {
            run = false;
            flujoE.close();
            flujoS.close();
            socketServidor.close();
        } catch (IOException ex) {
        }
    }
}
