package chatserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {

    private ServerSocket serverSocket;
    private boolean run = true;
    private List<ServidorThreads> listaSocketsServidor = new ArrayList();

    public Servidor(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) {
            System.out.println("Constructor " + ex.getLocalizedMessage());
        }
    }

    public void starService() {
        Thread hprincipal = new Thread() {
            @Override
            public void run() {
                while (run) {
                    ServidorThreads serverThread;
                    Socket servidor;
                    try {
                        servidor = serverSocket.accept();
                        serverThread = new ServidorThreads(servidor, Servidor.this);
                        listaSocketsServidor.add(serverThread);
                        serverThread.setId(listaSocketsServidor.indexOf(serverThread));
                        serverThread.start();
                    } catch (IOException ex) {
                        System.out.println("StarService " + ex.getLocalizedMessage());
                    }
                }
            }
        };
        hprincipal.start();
    }

    public void broadcast(String text) {
        for (ServidorThreads socketCliente : listaSocketsServidor) {
            socketCliente.send(text);
        }
    }
    
    public void sacaNombre(String text,String nombreEmisor){
        String[] parts = text.split(":");
        String nombreAux = parts[0];
        String cad = parts[1];
        mandaPrivado(nombreAux, cad, nombreEmisor);
    }

    private void mandaPrivado(String nombreAux, String cad, String nombreEmisor) {
        for (ServidorThreads socketCliente : listaSocketsServidor) {
            if (socketCliente.getNombreServidorCliente().equals(nombreAux)) {
                socketCliente.send("(Privado de "+nombreEmisor+"): "+cad+"\n");
            }
        }
    }
 
    public List<ServidorThreads> getListaSocketsServidor() {
        return listaSocketsServidor;
    }
}
