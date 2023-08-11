import java.util.*;
import java.io.*;


public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            String s= bf.readLine();
            if(s.equals("0 0"))break;
            st = new StringTokenizer(s);
            sb.append(Integer.parseInt(st.nextToken())-Integer.parseInt(st.nextToken())>0?"Yes":"No").append('\n');
        }
        System.out.println(sb);
    }
}