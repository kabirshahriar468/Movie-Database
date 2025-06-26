package multiplescene.util;

import multiplescene.clientmain.Movie;

import java.io.Serializable;

public class MoviePlusString implements Serializable {
    public Movie movie;
    public String actionName;
    public MoviePlusString(){
        movie=new Movie();
        actionName=new String();
    }
    public MoviePlusString(Movie movie,String s1){
        this.movie=movie;
        this.actionName=s1;
    }
}
