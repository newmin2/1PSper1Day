import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        int[] arr;
        int[] team;
        int[] point;
        int[] over;
        for(int t=0;t<T;t++){
            int n =Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            arr= new int[n+1];
            team = new int[201]; //팀 수
            point = new int[201]; //점수
            over = new int[201];
            for(int i=1;i<n+1;i++){
                arr[i]=Integer.parseInt(st.nextToken());
                team[arr[i]]++;
            }
            int grade=1;
            for(int i=1;i<n+1;i++){
                if(team[arr[i]]<6) continue;
                if(over[arr[i]]>=4){
                    if(over[arr[i]]==4){
                        over[arr[i]]=grade;
                    }
                    grade++;
                    continue;
                }
                point[arr[i]] += grade++;
                over[arr[i]]++;
            }
            int flag=Integer.MAX_VALUE;
            int ans=0;
            for(int i=1;i<n+1;i++){
                if(point[arr[i]]==0) continue;
                if(flag==point[arr[i]]){
                    if(over[ans]>over[arr[i]]){
                        flag=point[arr[i]];
                        ans=arr[i];
                    }
                }
                else if(flag>point[arr[i]]){
                    ans=arr[i];
                    flag=point[arr[i]];
                }
            }

//            System.out.println(Arrays.toString(team));
//            System.out.println(Arrays.toString(point));
//            System.out.println(Arrays.toString(over));
            System.out.println(ans);
//            System.out.println(arr[]);
        }

    }
}