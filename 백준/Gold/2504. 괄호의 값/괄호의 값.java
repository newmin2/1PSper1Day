import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] bracket = {'(','[',')',']'};

        String s =bf.readLine();
        int sum = 0;
        int tmp = 0;

        Stack<Character>stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                tmp=0;
                if(s.charAt(i)==bracket[2]||s.charAt(i)==bracket[3]){
                    System.out.println(0);
                    return;
                }else{
                    if(s.charAt(i)==bracket[0]){
                        tmp+=2;
                    }else{
                        tmp+=3;
                    }
                    stack.push(s.charAt(i));
                }
            }else{
                if(s.charAt(i)==bracket[0]){
                    tmp*=2;
                    stack.push(s.charAt(i));
                }else if(s.charAt(i)==bracket[1]){
                    tmp*=3;
                    stack.push(s.charAt(i));
                }else if(s.charAt(i)==bracket[2]){
                    char c = stack.pop();
                    if(c!=bracket[0]){
                        System.out.println(0);
                        return;
                    }
                    if(s.charAt(i-1)!=bracket[2]&&s.charAt(i-1)!=bracket[3]){
                        sum+=tmp;
                    }
                    tmp/=2;
                }else{
                    char c = stack.pop();
                    if(c!=bracket[1]){
                        System.out.println(0);
                        return;
                    }
                    if(s.charAt(i-1)!=bracket[2]&&s.charAt(i-1)!=bracket[3]){
                        sum+=tmp;
                    }
                    tmp/=3;
                }
            }
        }
        if(!stack.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(sum);
        }
    }
}