import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        char[][] one = new char[3][3];
        char[][] two = new char[3][3];
        char[][] three = new char[3][3];
        char[][] four = new char[3][3];
        char[][] five = new char[3][3];
        char[][] six = new char[3][3];


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++){
            for(int i=0;i<3;i++){
                Arrays.fill(one[i],'w');//위
                Arrays.fill(two[i],'r');//앞
                Arrays.fill(three[i],'y');//아래
                Arrays.fill(four[i],'o');//뒤
                Arrays.fill(five[i],'g');//왼
                Arrays.fill(six[i],'b');//오
            }
            int n = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            for(int a=0;a<n;a++){
                String s = st.nextToken();
                //위돌리기
                if(s.charAt(0)=='U'){
                    if(s.charAt(1)=='+'){
                        char[][] tmp = new char[3][3];
                        //윗면
                        for(int i=0;i<3;i++){
                            for(int j=0;j<3;j++){
                                tmp[i][j]=one[2-j][i];
                            }
                        }
                        one=tmp;
                        //옆면들
                        char[] tmp2 = six[0].clone();
                        six[0]=four[0].clone();
                        four[0]=five[0].clone();
                        five[0]=two[0].clone();
                        two[0]=tmp2;
                    }else{
                        char[][] tmp = new char[3][3];
                        //윗면
                        for(int i=0;i<3;i++){
                            for(int j=0;j<3;j++){
                                tmp[i][j]=one[j][2-i];
                            }
                        }
                        one=tmp;
                        //옆면들
                        char[] tmp2 = six[0].clone();
                        six[0]=two[0].clone();
                        two[0]=five[0].clone();
                        five[0]=four[0].clone();
                        four[0]=tmp2;
                    }



                }else if(s.charAt(0)=='D'){
                    //아랫면 돌릴때
                    if(s.charAt(1)=='+'){
                        char[][] tmp = new char[3][3];
                        //아랫면
                        for(int i=0;i<3;i++){
                            for(int j=0;j<3;j++){
                                tmp[i][j]=three[2-j][i];

                            }
                        }
                        three=tmp;
                        //옆면들
                        char[] tmp2 = six[2].clone();
                        six[2]=two[2].clone();
                        two[2]=five[2].clone();
                        five[2]=four[2].clone();
                        four[2]=tmp2;
                    }else{
                        char[][] tmp = new char[3][3];
                        //아랫면
                        for(int i=0;i<3;i++){
                            for(int j=0;j<3;j++){
                                tmp[i][j]=three[j][2-i];
                            }
                        }
                        three=tmp;
                        //옆면들
                        char[] tmp2 = six[2].clone();
                        six[2]=four[2].clone();
                        four[2]=five[2].clone();
                        five[2]=two[2].clone();
                        two[2]=tmp2;
                    }


                }else if(s.charAt(0)=='F'){
                    //앞돌리기
                    if(s.charAt(1)=='+'){
                        char[][] tmp = new char[3][3];
                        //윗면
                        for(int i=0;i<3;i++){
                            for(int j=0;j<3;j++){
                                tmp[i][j]=two[2-j][i];
                            }
                        }
                        two=tmp;
                        //옆면들
                        for(int i=2;i>=0;i--){
                            char tmp2=six[i][0];
                            six[i][0]=one[2][i];
                            one[2][i]=five[2-i][2];
                            five[2-i][2]=three[0][2-i];
                            three[0][2-i]=tmp2;
                        }
                    }else{
                        char[][] tmp = new char[3][3];
                        //윗면
                        for(int i=0;i<3;i++){
                            for(int j=0;j<3;j++){
                                tmp[i][j]=two[j][2-i];
                            }
                        }
                        two=tmp;
                        //옆면들
                        for(int i=2;i>=0;i--){
                            char tmp2=six[i][0];
                            six[i][0]=three[0][2-i];
                            three[0][2-i]=five[2-i][2];
                            five[2-i][2]=one[2][i];
                            one[2][i]=tmp2;
                        }
                    }


                }else if(s.charAt(0)=='B'){
                    if(s.charAt(1)=='+'){
                        char[][] tmp = new char[3][3];
                        //아랫면
                        for(int i=0;i<3;i++){
                            for(int j=0;j<3;j++){
                                tmp[i][j]=four[2-j][i];
                            }
                        }
                        four=tmp;
                        //옆면들
                        for(int i=2;i>=0;i--){
                            char tmp2=six[i][2];
                            six[i][2]=three[2][2-i];
                            three[2][2-i]=five[2-i][0];
                            five[2-i][0]=one[0][i];
                            one[0][i]=tmp2;
                        }

                    }else{
                        char[][] tmp = new char[3][3];
                        //아랫면
                        for(int i=0;i<3;i++){
                            for(int j=0;j<3;j++){
                                tmp[i][j]=four[j][2-i];
                            }
                        }
                        four=tmp;
                        //옆면들
                        for(int i=2;i>=0;i--){
                            char tmp2=six[i][2];
                            six[i][2]=one[0][i];
                            one[0][i]=five[2-i][0];
                            five[2-i][0]=three[2][2-i];
                            three[2][2-i]=tmp2;
                        }
                    }


                    //왼
                }else if(s.charAt(0)=='L'){
                    if(s.charAt(1)=='+'){
                        char[][] tmp = new char[3][3];
                        //윗면
                        for(int i=0;i<3;i++){
                            for(int j=0;j<3;j++){
                                tmp[i][j]=five[2-j][i];
                            }
                        }
                        five=tmp;
                        //옆면들
                        for(int i=2;i>=0;i--){
                            char tmp2= one[i][0];
                            one[i][0]=four[2-i][2];
                            four[2-i][2]=three[i][0];
                            three[i][0]=two[i][0];
                            two[i][0]=tmp2;
                        }
                    }else{
                        char[][] tmp = new char[3][3];
                        //윗면
                        for(int i=0;i<3;i++){
                            for(int j=0;j<3;j++){
                                tmp[i][j]=five[j][2-i];
                            }
                        }
                        five=tmp;
                        //옆면들
                        for(int i=2;i>=0;i--){
                            char tmp2= one[i][0];
                            one[i][0]=two[i][0];
                            two[i][0]=three[i][0];
                            three[i][0]=four[2-i][2];
                            four[2-i][2]=tmp2;
                        }
                    }

                }else{
                    if(s.charAt(1)=='+'){
                        char[][] tmp = new char[3][3];
                        //윗면
                        for(int i=0;i<3;i++){
                            for(int j=0;j<3;j++){
                                tmp[i][j]=six[2-j][i];
                            }
                        }
                        six=tmp;
                        //옆면들
                        for(int i=2;i>=0;i--){
                            char tmp2= one[i][2];
                            one[i][2]=two[i][2];
                            two[i][2]=three[i][2];
                            three[i][2]=four[2-i][0];
                            four[2-i][0]=tmp2;
                        }
                    }else {
                        char[][] tmp = new char[3][3];
                        //윗면
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                tmp[i][j] = six[j][2 - i];
                            }
                        }
                        six = tmp;
                        //옆면들
                        for (int i = 2; i >= 0; i--) {
                            char tmp2 = one[i][2];
                            one[i][2] = four[2 - i][0];
                            four[2 - i][0] = three[i][2];
                            three[i][2] = two[i][2];
                            two[i][2] = tmp2;
                        }
                    }
                }
            }
            for(char[] i:one){
                for(char j :i){
                    sb.append(j);
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}