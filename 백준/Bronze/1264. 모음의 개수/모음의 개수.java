import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String args[])throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String s = bf.readLine().toLowerCase();
            if(s.equals("#")){
                break;
            }
            int sum =0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u')
                    sum++;
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}