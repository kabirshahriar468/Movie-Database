package multiplescene.server;

import multiplescene.util.SocketWrapper;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import multiplescene.clientmain.Movie;

public class Server {

    private ServerSocket serverSocket;
    public HashMap<String, String> userMap;
    public static List<Movie> allMovieList;
    private static final String INPUT_FILE_NAME = "movies.txt";


    Server(List<Movie> allMovieList) {
        userMap = new HashMap<>();
        //allMovie=allMovieList;
        System.out.println("server is waiting to response..");
        try {
            serverSocket = new ServerSocket(1759);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket,allMovieList);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }
    public static void setAllMovieList(Movie m){
        allMovieList.add(m);
    }

    public void serve(Socket clientSocket,List<Movie> allMovieList) throws IOException {
        SocketWrapper socketWrapper = new SocketWrapper(clientSocket);
        new ReadThreadServer(userMap, socketWrapper,allMovieList);
    }

    public static void main(String[] args) throws IOException {
        allMovieList = new ArrayList<>();
        //Movie tempMovie=new Movie();
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("movies.txt")));
        int c=0;
        while (in.available()>0) {
            Movie tempMovie=new Movie();
            String line = br.readLine();
            if (line == null) break;
            String[] movieInfo=line.split(",");
            //System.out.println(line);
            //System.out.println(movieInfo[8]);
            tempMovie.setTitle(movieInfo[0]);
            tempMovie.setRelease_year(Integer.parseInt(movieInfo[1]));
            String[] tempGenre={movieInfo[2],movieInfo[3],movieInfo[4]};
            tempMovie.setGenre(tempGenre);
            tempMovie.setRunning_time(Integer.parseInt(movieInfo[5]));
            tempMovie.setProduction_company(movieInfo[6]);
            tempMovie.setBudget(Integer.parseInt(movieInfo[7]));
            tempMovie.setRevenue(Integer.parseInt(movieInfo[8]));
            //allMovieList.add(tempMovie);
            if(c==0){
                allMovieList.add(tempMovie);
                c=1;
            }
            int m=0;
            for(int i=0;i<allMovieList.size();i++){
                if(tempMovie.getTitle().equalsIgnoreCase(allMovieList.get(i).getTitle())){
                    allMovieList.set(i,tempMovie);
                    m=1;
                    break;

                }
            }
            if(m==0){
                allMovieList.add(tempMovie);
            }

        }
        System.out.println(allMovieList.size());
        br.close();
        new Server(allMovieList);
    }
}
