import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static void baseball(){
        int cnt=0;
        int j=0;
        for(int i=0;i<n;i++){
            int outcnt=0;
            int state=0;//타석(홈)
            while(true){
                int swing =arr[i][taja[j%9]];
                state++;//타석에 올라선 선수
                if(swing==0){
                    outcnt++;
                    state--;//아웃이면 타석에서 빠져
                }else if(swing==1)
                    state<<=1;
                else if(swing==2)
                    state<<=2;
                else if(swing==3)
                    state<<=3;
                else state<<=4;
                j++;//다음 타자 입장
                if(outcnt==3) break;
                for(int k=0;k<4;k++){
                    if((state&(1<<4)<<k)!=0) {
                        cnt++;
                        state-=(1<<4)<<k;
                    }
                }
            }
        }
        max=Math.max(max,cnt);
    }
    static void swap(int a,int b){
        int tmp=taja[a];
        taja[a]=taja[b];
        taja[b]=tmp;
    }
    static void tajan(int cnt, int flag) {
        if (cnt == 9) {
            swap(0,3);
            baseball();
            swap(0,3);
            return;
        }
        for (int i = 0; i < 8; i++) {
            if ((flag & 1 << i) != 0) continue;
            taja[cnt] = i+1;
            tajan(cnt + 1, flag | 1 << i);
        }
    }

    static int[][] arr;
    static int[] taja;
    static int n;
    static int max=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][9];
        taja=new int[9];
        for (int j = 0; j < n; j++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < 9; i++) {
                arr[j][i]=Integer.parseInt(st.nextToken());
            }
        }
        tajan(1, 0);
        System.out.println(max);
    }
}
