import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        boolean[] prime = new boolean[10000000];
        prime[0]=prime[1]=true;

        for(int i=2; i*i<10000000; i++){
            if(!prime[i]){
                for(int j=i*i; j<10000000; j+=i){
                    prime[j]=true;
                }
            }
        }
        boolean flag;
        for(int i=n; i<10000000; i++){
            flag=true;
            if(!prime[i]){
                String s= Integer.toString(i);
                for(int j=0; j<s.length()/2; j++){
                    if(s.charAt(j)!=s.charAt(s.length()-1-j)){
                        flag =false;
                        break;
                    }
                }
                if(flag) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}
