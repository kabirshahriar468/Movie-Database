package multiplescene;

import javafx.application.Platform;
import multiplescene.clientmain.Movie;
import multiplescene.util.IntegerPlusString;
import multiplescene.util.ListPlusString;
import multiplescene.util.MoviePlusString;

import java.io.IOException;
import java.util.List;

public class ReadThread   implements Runnable{
    private final Thread thr;
    private final Main main;

    public ReadThread(Main main) {
        this.main = main;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = main.getSocketWrapper().read();
                if (o != null) {
                    if (o instanceof List<?>) {
//                        LoginDTO loginDTO = (LoginDTO) o;
//                        System.out.println(loginDTO.getUserName());
//                        System.out.println(loginDTO.isStatus());
                        // the following is necessary to update JavaFX UI components from user created threads
                        List<Movie> movieListOfCompany=(List<Movie>) o;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                //if (loginDTO.isStatus()) {
                                if(movieListOfCompany.size()!=0){
                                    try {
                                        main.showHomePage(movieListOfCompany.get(0).getProduction_company());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    main.showAlert();
                                }

                            }
                        });
                    } else if (o instanceof MoviePlusString) {

                        MoviePlusString temp=(MoviePlusString) o;
                        if(temp.actionName.equalsIgnoreCase("MaxRevenueMovie")){
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        main.showMaxRevenuePage(temp.movie.getProduction_company(),temp.movie);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            });
                        } else if (temp.actionName.equalsIgnoreCase("MostRecentMovie")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        main.showMostRecentPage(temp.movie.getProduction_company(),temp.movie);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            });
                        }

                    } else if (o instanceof IntegerPlusString) {
                        IntegerPlusString temp=(IntegerPlusString) o;
                        String str[]=temp.actionName.split(",");
                        if (str[0].equalsIgnoreCase("TotalProfit")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        main.showTotalProfit(str[1],temp.profit);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            });
                        }

                    } else if (o instanceof ListPlusString) {
                        ListPlusString temp=(ListPlusString) o;
                        if(temp.actionName.equalsIgnoreCase("ShowMovie")){
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        main.showAllMovie(temp.movieList.get(0).getProduction_company(),temp.movieList);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            });
                        }

                    } else if (o instanceof String) {
                        String temp=(String) o;
                        if(temp.equalsIgnoreCase("AddMovie")){
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        //
                                        main.showAddMovie(main.p_company);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            });
                        } else if (temp.equalsIgnoreCase("Transfer")) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        //
                                        main.showTransferMovie(main.p_company);
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            });
                        }

                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                main.getSocketWrapper().closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



