package multiplescene.clientmain;

import java.util.ArrayList;
import java.util.List;

public class SearchProductionCompany {
    public static List<Movie> SearchByProductionCompany(String p_company, List<Movie> movielist){
        int checker=-1;
        List<Movie> return_movie=new ArrayList<Movie>();
        int c=0;
        for(int i=0;i<movielist.size();i++){
            if(p_company.equalsIgnoreCase(movielist.get(i).getProduction_company())){
               // if(c==0){
                    return_movie.add(movielist.get(i));
//                    c=1;
//                    continue;
//                }
//                int m=0;
//                for(int ij=0;ij<return_movie.size();ij++){
//                    if(return_movie.get(ij).getTitle().equalsIgnoreCase(movielist.get(i).getTitle())) {
//                        m=1;break;
//                    }
//
//                }
//                if(m==0){return_movie.add(movielist.get(i));}
                //return_movie.add(movielist.get(i));
                checker=1;
            }
        }
        if(checker==-1) {
            return  null;
        }
        else {
            return return_movie;
        }
    }
}
