package multiplescene.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketWrapper {
    private final Socket socket;
    private final ObjectOutputStream oos;
    private final ObjectInputStream ois;

    public SocketWrapper(String s, int port) throws IOException {
        this.socket = new Socket(s, port);
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
    }

    public SocketWrapper(Socket s) throws IOException {
        this.socket = s;
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
    }

    public Object read() throws IOException, ClassNotFoundException {
        return ois.readUnshared();
    }

    public void write(Object o) throws IOException {
        oos.writeUnshared(o);
    }

    public void closeConnection() throws IOException {
        ois.close();
        oos.close();
    }
}

