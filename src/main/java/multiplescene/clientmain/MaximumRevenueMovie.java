package multiplescene.clientmain;

import java.util.ArrayList;
import java.util.List;

public class MaximumRevenueMovie {
    public static Movie maximumRevenueMovies(String p_company, List<Movie> movieList){
        List<Movie> temp_movie=new ArrayList();
        int checker =-1;
        for(int i=0;i<movieList.size();i++){
            if(p_company.equalsIgnoreCase(movieList.get(i).getProduction_company())){
                temp_movie.add(movieList.get(i));
                if(checker==-1) {
                    //System.out.println("Movies with maximum revenue from this production company:");
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
//        for(int i=0;i<temp_movie.size();i++){
//
//            if(i==0) {
//                temp_movie.get(i).showMovieInfo();
//            }
//            else if(temp_movie.get(0).getRevenue()==temp_movie.get(i).getRevenue()){
//                temp_movie.get(i).showMovieInfo();
//            }
//        }
//        if(checker==-1){
//            System.out.println("No such production company with this name.");
//        }
        return temp_movie.get(0);
    }
}
