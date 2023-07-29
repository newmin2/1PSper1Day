import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static void awab(StringBuilder sb){
        if(sb.length()==s.length()){
            if(sb.toString().equals(s))
                flag=true;
            return;
        }
        if(sb.charAt(sb.length()-1)=='A'){
            sb.deleteCharAt(sb.length()-1);
            awab(sb);
        }
        else{
            sb.deleteCharAt(sb.length()-1).reverse();
            awab(sb);
        }
    }
    static boolean flag;
    static String s;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        s = bf.readLine();
        sb.append(bf.readLine());
        awab(sb);
        if(flag) System.out.println(1);
        else System.out.println(0);
    }
}