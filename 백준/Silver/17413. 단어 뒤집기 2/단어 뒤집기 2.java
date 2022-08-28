import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String s = bf.readLine();
        StringBuilder sb= new StringBuilder();
        boolean flag = false;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='<'){
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                flag = true;
                sb.append(s.charAt(i));
            }
            else if(s.charAt(i)=='>') {
                flag=false;
                sb.append(s.charAt(i));
            }
            else if(flag) {
                sb.append(s.charAt(i));
            }
            else if(!flag){
                if(s.charAt(i)==' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(s.charAt(i));
                }
                else
                    stack.push(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
