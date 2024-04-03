import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        if(n==1){
            System.out.println("good puzzle");
            return;
        }
        int tmp = Integer.parseInt(st.nextToken());
        int first=0;
        for(int i =0;i<n;i++){
            if(arr[i]==tmp){
                first=i;
                break;
            }
        }
        tmp = Integer.parseInt(st.nextToken());
        boolean direc;
        if(tmp==arr[(first - 1 + n) % n]){
            first%=n;
            --first;
            direc=false;
        }else if(tmp==arr[(first + 1 + n) % n]){
            first%=n;
            ++first;
            direc =true;
        }else{
            System.out.println("bad puzzle");
            return;
        }
        for(int i=2;i<n;i++){
            tmp = Integer.parseInt(st.nextToken());
            if(!direc){
                if(tmp!=arr[(first - 1 + n) % n]){
                    System.out.println("bad puzzle");
                    return;
                }else{
                    first%=n;
                    --first;
                }
            }else{
                if(tmp!=arr[(first + 1 + n) % n]){
                    System.out.println("bad puzzle");
                    return;
                }else{
                    first%=n;
                    ++first;
                }
            }
        }
        System.out.println("good puzzle");
    }
}