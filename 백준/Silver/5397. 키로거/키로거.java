import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static double distance(int a, int b,int c,int d){
        return Math.sqrt(Math.pow(a-b,2)+Math.pow(c-d,2));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        LinkedList<Character> list;
        for(int t=0;t<T;t++) {
            list = new LinkedList<>();
            String s =bf.readLine();
            int cursor=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='<'){
                    if(cursor!=0) cursor--;
                }else if(s.charAt(i)=='>'){
                    if(cursor!=list.size()) cursor++;
                }else if(s.charAt(i)=='-'){
                    if(cursor!=0) {
                        cursor--;
                        list.remove(cursor);
                    }
                }else{
                    list.add(cursor++,s.charAt(i));
                }
//                System.out.println(Arrays.toString(list.toArray()));
            }
//            if(cursor!=list.size()){
//                list.add(cursor,' ');
//            }
            for(char i:list){
                sb.append(i);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
