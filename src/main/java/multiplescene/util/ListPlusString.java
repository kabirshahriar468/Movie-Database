package multiplescene.util;

import multiplescene.clientmain.Movie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListPlusString implements Serializable {
    public List<Movie> movieList;
    public String actionName;
    public ListPlusString(){
        movieList=new ArrayList<>();
        actionName=new String();
    }
    public  ListPlusString(List<Movie> m,String s){
        movieList=m;
        actionName=s;
    }
}
