package multiplescene.util;

import java.io.Serializable;

public class MultipleString implements Serializable {
    //this class is for transfering a movie
    public String movieName;
    public String p_companyName;
    public MultipleString(){
        movieName=new String();
        p_companyName=new String();
    }
    public MultipleString(String s1,String s2){
        movieName=s1;
        p_companyName=s2;
    }

}
