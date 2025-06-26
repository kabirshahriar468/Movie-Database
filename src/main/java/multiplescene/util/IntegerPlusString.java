package multiplescene.util;

import java.io.Serializable;

public class IntegerPlusString implements Serializable {
    public long profit;
    public String actionName;
    public  IntegerPlusString(){
        actionName=new String();
    }
    public IntegerPlusString(long p,String s){
        profit=p;
        actionName=s;
    }
}
