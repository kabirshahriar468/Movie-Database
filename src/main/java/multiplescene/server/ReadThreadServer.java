package multiplescene.server;

import multiplescene.Main;
import multiplescene.clientmain.*;
import multiplescene.util.*;
import multiplescene.util.SocketWrapper;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReadThreadServer extends NotSerializableException implements Runnable {
    private final Thread thr;
    private final SocketWrapper socketWrapper;
    public HashMap<String, String> userMap;
    public static List<Movie> allMovieList;
    public String p_company;

    public static void setAllMovieList(Movie m) {
        //allMovieList.add(m);
    }

    public ReadThreadServer(HashMap<String, String> map, SocketWrapper socketWrapper, List<Movie> allMovieList) {
        this.userMap = map;
        this.socketWrapper = socketWrapper;
        this.allMovieList=allMovieList;
        this.thr = new Thread(this);
        thr.start();
    }

    public void  run() {
        try {
            while (true) {
                ///DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("movies.txt")));

                Object o = socketWrapper.read();
                System.out.println("server reads  ");
                if(allMovieList!=null) {
                    allMovieList.removeAll(allMovieList);
                }
                BufferedReader br = new BufferedReader(new FileReader("movies.txt"));
                //DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("movies.txt")));
                int c=0;
                //allMovieList.removeAll(allMovieList);
                while (true) {
                    //allMovieList.clear();
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
                        continue;
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
                br.close();
                if (o != null) {
                    if (o instanceof MultipleString) {
                        //LoginDTO loginDTO = (LoginDTO) o;
//                        String password = userMap.get(loginDTO.getUserName());
//                        loginDTO.setStatus(loginDTO.getPassword().equals(password));
//                        socketWrapper.write(loginDTO);
                        MultipleString str=(MultipleString) o;
                        if(str.movieName.equalsIgnoreCase("login")){
                            System.out.println("instance");
                            System.out.println(allMovieList.size());

                            this.p_company=str.p_companyName;
                            List<Movie> listFromServer=new ArrayList<>();
                            for(int i=0;i<allMovieList.size();i++){
                                if(p_company.equalsIgnoreCase(allMovieList.get(i).getProduction_company())){
                                    System.out.println(p_company);
                                    listFromServer=SearchProductionCompany.SearchByProductionCompany(p_company,allMovieList);
                                    //break;
                                }
                            }
                            socketWrapper.write(listFromServer);
                            System.out.println(listFromServer.size());
                            System.out.println("sent successfully.");
                        }
                    } else if (o instanceof String) {
                        String str=(String) o;
                        if(str.equalsIgnoreCase("ShowMovie")){
                            List<Movie> listFromServer=new ArrayList<>();
                            System.out.println(allMovieList.size());
                            for(int i=0;i<allMovieList.size();i++){
                                if(p_company.equalsIgnoreCase(allMovieList.get(i).getProduction_company())){
                                    listFromServer=SearchProductionCompany.SearchByProductionCompany(p_company,allMovieList);
                                    break;
                                }
                            }
                            ListPlusString ret=new ListPlusString(listFromServer,"ShowMovie");
                            socketWrapper.write(ret);

                        } else if (str.equalsIgnoreCase("MaxRevenueMovie")) {
                            Movie maxRevenue=MaximumRevenueMovie.maximumRevenueMovies(p_company,allMovieList);
                            MoviePlusString ret=new MoviePlusString(maxRevenue,"MaxRevenueMovie");
                            socketWrapper.write(ret);
                        } else if (str.equalsIgnoreCase("MostRecentMovie")) {
                            Movie mostRecent= MostRecentMovies.mostRecentMovies(p_company, allMovieList).get(0);
                            MoviePlusString ret=new MoviePlusString(mostRecent,"MostRecentMovie");
                            socketWrapper.write(ret);

                        } else if (str.equalsIgnoreCase("TotalProfit")) {
                            long totalProfit= (long) TotalProfit.totalProfit(p_company,allMovieList);
                            IntegerPlusString ret=new IntegerPlusString(totalProfit,"TotalProfit,"+p_company);
                            socketWrapper.write(ret);
                        } else if (str.equalsIgnoreCase("AddMovie")) {
                            socketWrapper.write("AddMovie");
                        } else if (str.equalsIgnoreCase("Transfer")) {
                            socketWrapper.write("Transfer");
                        }

                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                socketWrapper.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



