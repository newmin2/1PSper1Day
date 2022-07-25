import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int cnt = 0;
        String[] arr = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        for(int i=0; i<arr.length; i++){
            if(s.contains(arr[i]))
                s=s.replaceAll(arr[i],"a");
        }
        System.out.println(s.length()-cnt);
    }
}
