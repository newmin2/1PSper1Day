import java.util.*;
import java.io.*;


public class Main {
    static class Building{
        int height, idx;

        Building(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N + 2];
        int[][] storage = new int[N+1][2];
        String[] info = bf.readLine().split(" ");
        Stack<Building>stack = new Stack<>();
        stack.push(new Building(0,0));
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(info[i-1]);
            while(!stack.isEmpty()) {
                if (stack.peek().height<=arr[i]){
                    stack.pop();
                }else break;
            }
            storage[i][0]= stack.size();
            if(!stack.isEmpty()){
                storage[i][1]=stack.peek().idx;
            }
            stack.push(new Building(arr[i],i));
        }
        stack.clear();
        stack.push(new Building(0,N+1));
        for(int i=N;i>=1;i--){
            while(!stack.isEmpty()) {
                if (stack.peek().height<=arr[i]){
                    stack.pop();
                }else break;
            }
            storage[i][0]+= stack.size();
            if(!stack.isEmpty()){
                if(storage[i][1]!=0)
                    storage[i][1]=Math.abs(storage[i][1]-i)<=Math.abs(stack.peek().idx-i)?storage[i][1]:stack.peek().idx;
                else storage[i][1]=stack.peek().idx;
            }
            stack.push(new Building(arr[i],i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++){
            if(storage[i][0]==0) {
                sb.append(0).append('\n');
                continue;
            }
            sb.append(storage[i][0]).append(" ").append(storage[i][1]).append('\n');
        }
        System.out.println(sb);
    }
}