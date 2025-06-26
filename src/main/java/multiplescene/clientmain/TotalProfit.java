package multiplescene.clientmain;

import java.util.List;

public class TotalProfit {
    public static Object totalProfit(String p_company, List<Movie> movieList){
        long total_profit=0;
        int c=-1;
        for(int i=0;i<movieList.size();i++){
            if(p_company.equalsIgnoreCase(movieList.get(i).getProduction_company())){
                total_profit+=movieList.get(i).profit();
                c=1;
            }
        }
        if(c==1)return  total_profit;
        else return null;
    }
}
