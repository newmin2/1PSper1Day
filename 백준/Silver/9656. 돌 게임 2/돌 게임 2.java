import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Integer.parseInt(bf.readLine())%2==0?"SK":"CY");
    }
}