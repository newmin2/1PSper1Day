//배열x+buffered
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        int max = -1000000;
        int min = 1000000;
        
        while(st.hasMoreTokens()){
            int val = Integer.parseInt(st.nextToken());
            if(val>max){
                max = val;
            }
            if(val<min){
                min = val;
            }
        }
        System.out.print(min+" "+max);
        
    }
}