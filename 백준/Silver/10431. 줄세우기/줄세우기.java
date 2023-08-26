import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[])throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        int caseNum,cnt, height;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer>list;
        boolean flag;
        for(int t=0;t<T;t++){
            list = new LinkedList<>();
            cnt=0;
            st = new StringTokenizer(bf.readLine());
            caseNum = Integer.parseInt(st.nextToken());
            int idx;
            for(int i=0;i<20;i++){
                height = Integer.parseInt(st.nextToken());
                flag=false;
                idx=0;
                for(int a:list){
                    if(height< a) {
                        cnt+=list.size()-idx;
                        list.add(idx,height);
                        flag=true;
                        break;
                    }
                    idx++;
                }
                if(!flag) list.add(height);
            }
            sb.append(caseNum).append(" ").append(cnt).append('\n');
        }
        System.out.print(sb);
    }
}