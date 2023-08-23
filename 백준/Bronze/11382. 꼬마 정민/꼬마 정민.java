import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        System.out.println(Long.parseLong(st.nextToken())+Long.parseLong(st.nextToken())+Long.parseLong(st.nextToken()));
    }
}