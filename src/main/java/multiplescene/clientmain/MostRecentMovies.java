package multiplescene.clientmain;

import java.util.ArrayList;
import java.util.List;

public class MostRecentMovies {
    public static List<Movie> mostRecentMovies(String p_company, List<Movie> movieList){
        List<Movie> temp_movie=new ArrayList();
        List<Movie> return_movie=new ArrayList();
        int checker =-1;
        for(int i=0;i<movieList.size();i++){
            if(p_company.equalsIgnoreCase(movieList.get(i).getProduction_company())){
                temp_movie.add(movieList.get(i));
                if(checker==-1) {
                    //System.out.println("Most recent movies from this production company:");
                    checker=1;
                }
            }
        }
        for(int j=0;j<temp_movie.size();j++){
            for(int k=j+1;k<temp_movie.size();k++){
                if(temp_movie.get(j).getRelease_year()<temp_movie.get(k).getRelease_year()) {
                    Movie temp = temp_movie.get(j);
                    temp_movie.set(j,temp_movie.get(k));
                    temp_movie.set(k,temp);
                }
            }
        }
        for(int i=0;i<temp_movie.size();i++){
            if(i==0) {
                return_movie.add(temp_movie.get(i));
            }
            else if(temp_movie.get(i).getRelease_year()==temp_movie.get(0).getRelease_year()){
                return_movie.add(temp_movie.get(i));
            }
        }
        if(checker==-1){
            return null;
        }
        else {
            return return_movie;
        }
    }
}
