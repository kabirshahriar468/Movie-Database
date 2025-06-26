package multiplescene.clientmain;

//import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class MovieDatabase {

    private static final String INPUT_FILE_NAME = "movies.txt";
    private static final String OUTPUT_FILE_NAME = "out.txt";
    public static void SearchByTitle(String title,List<Movie> movielist){
        int checker=-1;
        for(int i=0;i<movielist.size();i++){
            if(title.equalsIgnoreCase(movielist.get(i).getTitle())){
                if(checker==-1) {
                    System.out.println("Matching results with given title:");
                }
                movielist.get(i).showMovieInfo();
                checker=1;
            }
        }
        if(checker==-1) {
            System.out.println("No such movie with this title.");
        }
    }
    public static void SearchByReleaseYear(int r_year,List<Movie> movielist){
        int checker =-1;
        for(int i=0;i<movielist.size();i++){
            if(r_year==movielist.get(i).getRelease_year()){
                if(checker==-1) {
                    System.out.println("Matching results with given release year:");
                }
                movielist.get(i).showMovieInfo();
                System.out.println();
                checker=1;
            }
        }

        if(checker==-1) {
            System.out.println("No such movie with this release year.");
        }
    }
    public static void SearchByGenre(String genre,List<Movie> movielist){
        int checker =-1;
        for(int i=0;i<movielist.size();i++){
            if(genre.equalsIgnoreCase(movielist.get(i).getGenre()[0])){
                if(checker==-1){
                    System.out.println("Matching results with given genre: ");
                }
                movielist.get(i).showMovieInfo();
                System.out.println();
                checker=1;
                continue;
            }
            else if(genre.equalsIgnoreCase(movielist.get(i).getGenre()[1])){
                if(checker==-1){
                    System.out.println("Matching results with given genre: ");
                }
                movielist.get(i).showMovieInfo();
                System.out.println();
                checker=1;
                continue;
            }
            else if(genre.equalsIgnoreCase(movielist.get(i).getGenre()[2])){
                if(checker==-1){
                    System.out.println("Matching results with given genre: ");
                }
                movielist.get(i).showMovieInfo();
                System.out.println();
                checker=1;
                continue;
            }
        }
        if(checker==-1){
            System.out.println("No such movie with this genre.");
        }
    }
    public static void SearchByProductionCompany(String p_company,List<Movie> movielist){
        List<Movie> temp= SearchProductionCompany.SearchByProductionCompany(p_company,movielist);
        for(int i=0;i<temp.size();i++){
            temp.get(i).showMovieInfo();
        }
    }
    public static void SearchByRunningTime(int r_time,List<Movie> movielist){
        int checker =-1;
        for(int i=0;i<movielist.size();i++){
            if(r_time==movielist.get(i).getRunning_time()){
                if(checker==-1) {
                    System.out.println("Matching results with given running time:");
                }
                movielist.get(i).showMovieInfo();
                System.out.println();
                checker=1;
            }
        }

        if(checker==-1) {
            System.out.println("No such movie with this release year.");
        }
    }
    public static void TopTenMoviesByProfit(List<Movie> movieList){
        for(int i=0;i<movieList.size();i++){
            for(int j=i+1;j<movieList.size();j++){
                if(movieList.get(i).profit()<movieList.get(j).profit()){
                    Movie temp=movieList.get(i);
                    movieList.set(i,movieList.get(j));
                    movieList.set(j,temp);
                }
            }
        }
        System.out.println("Displaying top ten movies based on profit: ");
        for(int i=0;i<10;i++){
            System.out.println("Movie "+(i+1));
            movieList.get(i).showMovieInfo();
        }
    }
//    public static void test(){
//        TopTenMoviesByProfit(movieList);
//    }
//Production Company Searching Options:
//            1) Most Recent Movies
//2) Movies with the Maximum Revenue
//3) Total Profit
//4) List of Production Companies and the Count of their Produced Movies
//5) Back to Main Menu
    public static void mostRecentMovies(String p_company,List<Movie> movieList){
        List<Movie> temp=MostRecentMovies.mostRecentMovies(p_company,movieList);
        for(int i=0;i<temp.size();i++){
            temp.get(i).showMovieInfo();
        }
    }
    public static void maximumRevenueMovies(String p_company,List<Movie> movieList){
        List<Movie> temp_movie=new ArrayList();
        int checker =-1;
        for(int i=0;i<movieList.size();i++){
            if(p_company.equalsIgnoreCase(movieList.get(i).getProduction_company())){
                temp_movie.add(movieList.get(i));
                if(checker==-1) {
                    System.out.println("Movies with maximum revenue from this production company:");
                    checker=1;
                }
            }
        }
        for(int j=0;j<temp_movie.size();j++){
            for(int k=j+1;k<temp_movie.size();k++){
                if(temp_movie.get(j).getRevenue()<temp_movie.get(k).getRevenue()) {
                    Movie temp = temp_movie.get(j);
                    temp_movie.set(j,temp_movie.get(k));
                    temp_movie.set(k,temp);
                }
            }
        }
        for(int i=0;i<temp_movie.size();i++){

            if(i==0) {
                temp_movie.get(i).showMovieInfo();
            }
            else if(temp_movie.get(0).getRevenue()==temp_movie.get(i).getRevenue()){
                temp_movie.get(i).showMovieInfo();
            }
        }
        if(checker==-1){
            System.out.println("No such production company with this name.");
        }
    }

    public static void totalProfit(String p_company,List<Movie> movieList){
//        long total_profit=0;
//        int c=-1;
//        for(int i=0;i<movieList.size();i++){
//            if(p_company.equalsIgnoreCase(movieList.get(i).getProduction_company())){
//                total_profit+=movieList.get(i).profit();
//                c=1;
//            }
//        }
//        if(c==1){
//            System.out.println("Total profit from this production company ="+total_profit);
//        }
//        else{
//            System.out.println("No such production company with this name.");
//        }
        //TotalProfit.totalProfit(p_company,movieList);
        System.out.println("Total profit from this production company ="+ TotalProfit.totalProfit(p_company,movieList));
    }
    public static void MovieListOfProductionCompany(List<Movie> movieList){
        class movieOfCompany{
            public String p_company;
            public int totalMovie;
            public movieOfCompany(){
                //p_company=new String();
                totalMovie=0;
            }
        }
        //System.out.println("inside");
        List<movieOfCompany> collection=new ArrayList<movieOfCompany>();
        int j,c=-1;
        for(int i=0;i<movieList.size();i++){

            if(i==0){
                movieOfCompany temp=new movieOfCompany();
                temp.p_company=movieList.get(i).getProduction_company();
                temp.totalMovie++;

                collection.add(temp);

            }
            else{
                for(j=0;j<collection.size();j++){
                    if(collection.get(j).p_company.equalsIgnoreCase(movieList.get(i).getProduction_company())){
                        c=j;
                        break;
//                        System.out.println(" "+collection.get(j).p_company+"   "+collection.get(j).totalMovie);
                    }
                }
                if(c!=-1){
                    collection.get(c).totalMovie++;
                    c=-1;
                }
                else{
                    movieOfCompany temp=new movieOfCompany();
                    temp.p_company=movieList.get(i).getProduction_company();
                    temp.totalMovie++;
                    collection.add(temp);
                }
            }
        }
        System.out.println("List of production companies and the number of movies they produced: ");
        for(int i=0;i<collection.size();i++){
            System.out.println("  "+(i+1)+". Company Name:"+collection.get(i).p_company);
            System.out.println("      Total Produced Movies:"+collection.get(i).totalMovie);
        }
    }
    public static void mainMenu(List<Movie> movieList,int choice) throws Exception {
//        Main Menu:
//        1) Search Movies
//        2) Search Production Companies
//        3) Add Movie
//        4) Exit System
        while(choice!=4) {
            cls();
            System.out.println("Main Menu:");
            System.out.println("1) Search Movies ");
            System.out.println("2) Search Production Companies");
            System.out.println("3) Add Movie");
            System.out.println("4) Exit System");
            Scanner scn = new Scanner(System.in);
            System.out.printf("\n  Enter your choice ");
            choice = scn.nextInt();
            switch (choice){
                case 1:
                    movieSearchingOptions(movieList,3);
                    break;
                case 2:
                    p_companySearchingOptions(movieList,3);
                    break;
                case 3:
                    addMovie(movieList);
                    break;
                case 4:
                    break;

            }
        }

    }
    public static void movieSearchingOptions(List<Movie> movieList,int choice){
//        Movie Searching Options:
//        1) By Movie Title
//        2) By Release Year
//        3) By Genre
//        4) By Production Company
//        5) By Running Time
//        6) Top 10 Movies
//        7) Back to Main Menu
        while(choice!=7){
            //cls();
            System.out.println("Movie Searching Options:");
            System.out.println(" 1) By Movie Title");
            System.out.println(" 2) By Release Year");
            System.out.println(" 3) By Genre");
            System.out.println(" 4) By Production Company");
            System.out.println(" 5) By Running Time");
            System.out.println(" 6) Top 10 Movies");
            System.out.println(" 7) Back to Main Menu");
            Scanner scn = new Scanner(System.in);
            System.out.printf("\n  Enter your choice ");
            choice = scn.nextInt();
            Scanner sc = new Scanner(System.in);
            switch (choice){
                case 1:
                    System.out.printf("\nGive movie title:");
                    String title=sc.nextLine();
                    SearchByTitle(title,movieList);
                    break;
                case 2:
                    System.out.printf("\nGive release year:");
                    int year=scn.nextInt();
                    SearchByReleaseYear(year,movieList);
                    break;
                case 3:
                    System.out.printf("\nGive genre:");
                    String genre=sc.nextLine();
                    SearchByGenre(genre,movieList);
                    break;
                case 4:
                    System.out.printf("\nGive production company:");
                    String p_company=sc.nextLine();
                    SearchByProductionCompany(p_company,movieList);
                    break;
                case 5:
                    System.out.printf("\nGive running time:");
                    int r_time=scn.nextInt();
                    SearchByRunningTime(r_time,movieList);
                    break;
                case 6:
                    System.out.printf("\n");
                    TopTenMoviesByProfit(movieList);
                    break;
                case 7:
                    break;

            }
        }

    }
    public static void p_companySearchingOptions(List<Movie> movieList,int choice){
//        Production Company Searching
////        1) Most Recent MoviesOptions:
//        2) Movies with the Maximum Revenue
//        3) Total Profit
//        4) List of Production Companies and the Count of their Produced Movies
//        5) Back to Main Menu
        while(choice!=5){
            //cls();
            System.out.println(" Production Company Searching Options:");
            System.out.println(" 1) Most Recent Movies");
            System.out.println(" 2) Movies with the Maximum Revenue");
            System.out.println(" 3) Total Profit");
            System.out.println(" 4) List of Production Companies and the Count of their Produced Movies");
            System.out.println(" 5) Back to Main Menu");
            Scanner scn = new Scanner(System.in);
            System.out.printf("\n  Enter your choice ");
            choice = scn.nextInt();
            Scanner sc = new Scanner(System.in);
            String p_company;
            switch (choice){
                case 1:
                    System.out.printf("\nGive production company:");
                    p_company=sc.nextLine();
                    mostRecentMovies(p_company,movieList);
                    break;
                case 2:
                    System.out.printf("\nGive production company:");
                    p_company=sc.nextLine();
                    maximumRevenueMovies(p_company,movieList);
                    break;
                case 3:
                    System.out.printf("\nGive production company:");
                    p_company=sc.nextLine();
                    totalProfit(p_company,movieList);
                    break;
                case 4:

                    MovieListOfProductionCompany(movieList);
                    break;
                case 5:
                    break;
            }
        }
    }
    public static void addMovie(List<Movie> movieList) throws Exception{
        final String OUTPUT_FILE_NAME = "movies.txt";
        //BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        FileWriter bw = new FileWriter(OUTPUT_FILE_NAME,true);
        //bw.write(text);
//        o Title
//        o Year of Release
//        o Genre (A movie can have up to three different genres)
//        o Running Time (in minutes)
//        o Production Company
//        o Budget
//        o Revenu
        Movie n_movie=new Movie();
        Scanner sc = new Scanner(System.in);
        Scanner scn = new Scanner(System.in);
        System.out.printf("\nGive movie title:");
        String temp=sc.nextLine();
        n_movie.setTitle(temp);
        bw.write(temp+",");
        System.out.printf("\nGive year of release:");
        int tmp=scn.nextInt();
        bw.write(String.valueOf(tmp));
        bw.write(",");
        n_movie.setRelease_year(tmp);
        System.out.printf("\nGive genre1:");
        String[] gnr=new String[3];
        temp=sc.nextLine();
        bw.write(temp);
        bw.write(",");
        gnr[0]=temp;
        System.out.printf("\nGive genre2:");
        temp=sc.nextLine();
        bw.write(temp);
        bw.write(",");
        gnr[1]=temp;
        System.out.printf("\nGive genre3:");
        temp=sc.nextLine();
        bw.write(temp);
        bw.write(",");
        gnr[2]=temp;
        n_movie.setGenre(gnr);
        System.out.printf("\nGive running time:");
        tmp=scn.nextInt();
        bw.write(String.valueOf(tmp));
        bw.write(",");
        n_movie.setRunning_time(tmp);
        System.out.printf("\nGive production company:");
        temp=sc.nextLine();
        bw.write(temp);
        bw.write(",");
        n_movie.setProduction_company(temp);
        System.out.printf("\nGive budget:");
        tmp=scn.nextInt();
        bw.write(String.valueOf(tmp));
        bw.write(",");
        n_movie.setBudget(tmp);
        System.out.printf("\nGive revenue:");
        tmp=scn.nextInt();
        bw.write(String.valueOf(tmp));
        //bw.write(",");
        n_movie.setRevenue(tmp);
        movieList.add(n_movie);
        bw.write(System.lineSeparator());
        bw.close();

    }
    public static void cls(){
        try{
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();

        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) throws Exception {
        List<Movie> allMovieList = new ArrayList();
        //Movie tempMovie=new Movie();
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
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
            allMovieList.add(tempMovie);

        }
        br.close();
        mainMenu(allMovieList,2);
        //test(allMovieList);
        //TopTenMoviesByProfit(allMovieList);
        //SearchByGenre("crime",allMovieList);
        //SearchByProductionCompany("Paramount picTuRES",allMovieList);
        //SearchByTitle("titanic",allMovieList);
        //MovieListOfProductionCompany(allMovieList);
        //mostRecentMovies("Miramax films",allMovieList);
        //maximumRevenueMovies("paramountjk pictures",allMovieList);
        //totalProfit("paramount pictures",allMovieList);

    }
}