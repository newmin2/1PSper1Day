import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        int cnt=0;
        for(int i=0; i<t; i++){
            String s = sc.next();
            for(int j=0;j<s.length()-1;j++){
                if(s.charAt(j)==s.charAt(j+1))
                    continue;
                if(s.substring(j+1,s.length()).contains(s.substring(j,j+1))){
                    cnt++;
                    break;}
            }
        }
        System.out.println(t-cnt);
    }
}
