import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n,max;
    static Egg[] eggs;
    static class Egg{
        int s,w;
        Egg(int s, int w){
            this.s=s;
            this.w=w;
        }
    }
    static void hitEgg(int order){
        if(order==n){

            int cnt=0;
            for(int i=0;i<n;i++){
                if(eggs[i].s<=0)cnt++;
            }
            max = Math.max(cnt,max);
            return;
        }
        if(eggs[order].s<=0) {
            hitEgg(order+1);
            return;
        }
        boolean flag = false;
        for(int i=0;i<n;i++){
            if(eggs[i].s<=0||i==order)continue;
            eggs[order].s-=eggs[i].w;
            eggs[i].s-=eggs[order].w;
            hitEgg(order+1);
            flag=true;
            eggs[order].s+=eggs[i].w;
            eggs[i].s+=eggs[order].w;
        }
        if(!flag)hitEgg(order+1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        eggs = new Egg[n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(bf.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        hitEgg(0);
        System.out.println(max);
    }
}