package multiplescene.clientmain;

import java.io.NotSerializableException;
import java.io.Serializable;

public class Movie  implements Serializable {

    private String title;
    private int release_year;
    private String[] genre;

    public String getGenre1() {
        return genre1;
    }

    private String genre1;

    public String getGenre2() {
        return genre2;
    }

    private String genre2;

    public String getGenre3() {
        return genre3;
    }

    private String genre3;

    private int running_time;
    private String production_company;
    private long  budget;
    private long revenue;

    public Movie(){
        genre=new String[3];
        genre1=genre[0];
        genre2=genre[1];
        genre3=genre[2];
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
        genre1=this.genre[0];
        genre2=this.genre[1];
        genre3=this.genre[2];
    }

    public String[] getGenre() {
        return genre;
    }


    public void setRunning_time(int running_time) {
        this.running_time = running_time;
    }

    public int getRunning_time() {
        return running_time;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getProduction_company() {
        return production_company;
    }

    public void setProduction_company(String production_company) {
        this.production_company = production_company;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public long getRevenue() {
        return revenue;
    }

    public long getBudget() {
        return budget;
    }
    public void showMovieInfo(){
        System.out.println("  Movie Title       : "+title);
        System.out.println("  Release year      : "+release_year);
        System.out.println("  Genre             : "+genre[0]+","+genre[1]+","+genre[2]);
        System.out.println("  Running time      : "+running_time);
        System.out.println("  Production company: "+production_company);
        System.out.println("  Budget            : "+budget);
        System.out.println("  Revenue           : "+revenue);
    }
    public String[] getMovieInfo(){
        String[] str=new String[6];
        str[0]=" Movie Title      : "+title;
        str[1]=" Release year    : "+String.valueOf(release_year);
        str[2]=" Genre              : "+genre[0]+","+genre[1]+","+genre[2];

        str[3]=" Running time  : "+String.valueOf(running_time);
        str[4]=" Budget            : "+String.valueOf(budget);
        str[5]=" Revenue          : "+String.valueOf(revenue);
        return str;
    }
    public long profit(){
        return revenue-budget;
    }

}
