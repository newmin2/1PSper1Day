import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        int a;
        while(true){
            a=bf.read();
            if(a==10) break;
            if(a<97) arr[a-65]++;
            else arr[a-97]++;
        }
        int ans = Integer.MIN_VALUE;
        int tmp=0;
        boolean flag=false;
        for(int i=0;i<26;i++){
            if(arr[i]==0)continue;
            if(ans<arr[i]) {
                ans=arr[i];
                flag = true;
                tmp=i;
            }
            else if(ans==arr[i]){
                flag=false;
                tmp=i;
            }
        }
        if(flag)
            System.out.println((char)(tmp+65));
        else
            System.out.println("?");
    }
}
