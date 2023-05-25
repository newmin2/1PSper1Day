import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String ori = bf.readLine();
        String boom = bf.readLine();
        StringBuilder stack = new StringBuilder();
        StringBuilder remain = new StringBuilder();
        int boomCursor = boom.length()-1;
        int i=0;
        while(i<ori.length()){
            remain.setLength(0);
            stack.append(ori.charAt(i));
            while(stack.charAt(stack.length()-1)==boom.charAt(boomCursor)){
                remain.append(stack.charAt(stack.length()-1));
                stack.deleteCharAt(stack.length()-1);
                boomCursor--;
                if(boomCursor==-1){
                    remain.setLength(0);
                    break;
                }
                if(stack.length()==0) break;
            }
            stack.append(remain.reverse());
            boomCursor=boom.length()-1;
            i++;
        }
        if(stack.length()==0) System.out.println("FRULA");
        else System.out.println(stack);
    }
}
