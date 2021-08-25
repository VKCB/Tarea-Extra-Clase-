import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main (String[] args) throws IOException {


            ServerSocket servidor = null;
            Socket sc = null;
            DataInputStream in;
            DataOutputStream out;
            // Data"s son los que crean la coneccion cliente servidor
            final int PUERTO = 5000;

            try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");
            // Para que el servidor este siempre atento a los clientes el while

            while(true){
                sc = servidor.accept();

                System.out.println("Cliente conectado");

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

            //Espera que el cliente le mande algo
                String mensaje = in.readUTF();
                System.out.println(mensaje);

                out.writeUTF("Hola mundo desde el servidor");
             // cierra el cliente
                sc.close();
                System.out.println("Cliente desconectado");

        } catch (IOException ex;
                ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null, ex);
        }

    }
}
