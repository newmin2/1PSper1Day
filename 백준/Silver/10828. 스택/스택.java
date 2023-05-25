import java.io.*;

public class Main {
    static class Stack{
        Stack(){

        }
        int[] arr = new int[10001];
        int cursor = -1;
        int limit = arr.length-1;

        void push(int x){
            if(cursor==limit) return;
            arr[++cursor]=x;
        }
        int pop(){
            if(isEmpty()) return -1;
            int tmp = arr[cursor];
            arr[cursor--]=0;
            return tmp;
        }
        int size(){
            return cursor+1;
        }
        int empty(){
            return isEmpty()? 1:0;
        }
        int top(){
            if(isEmpty()) return -1;
            return arr[cursor];
        }
        boolean isEmpty(){
            return cursor==-1;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        Stack stack = new Stack();
        for(int i=0;i<n;i++){
            String s = bf.readLine();
            if(s.equals("top")) bw.write(stack.top()+"\n");
            else if(s.equals("size")) bw.write(stack.size()+"\n");
            else if(s.equals("empty")) bw.write(stack.empty()+"\n");
            else if(s.equals("pop")) bw.write(stack.pop()+"\n");
            else{
                stack.push(Integer.parseInt(s.split(" ")[1]));
            }
        }
        bw.flush();
        bw.close();
    }
}
