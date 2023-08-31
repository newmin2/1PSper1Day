import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        double[] arr= new double[26];
        int n = Integer.parseInt(bf.readLine());
        String s = bf.readLine();
        Stack<Double>stack = new Stack<>();
        for(int i=0;i<n;i++){
            arr[i]=Double.parseDouble(bf.readLine());
        }
        double a,b;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                stack.push(stack.pop()*stack.pop());
            }else if(s.charAt(i)=='+'){
                stack.push(stack.pop()+stack.pop());
            }else if(s.charAt(i)=='-'){
                a=stack.pop();
                b=stack.pop();
                stack.push(b-a);
            }else if(s.charAt(i)=='/'){
                a=stack.pop();
                b=stack.pop();
                stack.push(b/a);
            }else{
                stack.push(arr[s.charAt(i)-65]);
            }
        }
        System.out.printf("%.2f",stack.pop());
    }
}