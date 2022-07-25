import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        int cnt=0;
        for(int i=0; i<t; i++){
            String s = sc.next();
            for(int j=0;j<s.length();j++){
                StringBuilder sb = new StringBuilder();
                if(s.indexOf(s.charAt(j))==s.lastIndexOf(s.charAt(j)))
                    continue;
                String a= s.substring(s.indexOf(s.charAt(j)),s.lastIndexOf(s.charAt(j)));
                for(int k=0; k<s.lastIndexOf(s.charAt(j))-s.indexOf(s.charAt(j));k++)
                    sb.append(s.charAt(j));
                if(!a.equals(sb.toString())){
                    cnt++;
                    break;}
            }
        }
        System.out.println(t-cnt);
    }
}
