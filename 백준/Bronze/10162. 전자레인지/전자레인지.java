import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			int cnt1=0;
			int cnt2=0;
			int cnt3=0;
			if (a%10!=0)
				System.out.println(-1);
			else {
			while(a/300>0) {
				a-=300;
				cnt1++;
			}
			while(a/60!=0) {
				a-=60;
				cnt2++;
			}
			while(a/10!=0) {
				a-=10;
				cnt3++;
			}

			System.out.println(cnt1+" "+cnt2+" "+cnt3);}
	}

}
