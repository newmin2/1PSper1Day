class Solution {
    public int solution(String dartResult) {
        int[][] arr = new int[2][3];
        int idx=0;
        for(int i=0;i<dartResult.length();i++){
            if(dartResult.charAt(i)=='S'||dartResult.charAt(i)=='D'
            ||dartResult.charAt(i)=='T'){
                arr[0][idx]=i;
                if(dartResult.charAt(i)=='S'){
                    arr[1][idx]=1;
                }else if(dartResult.charAt(i)=='D'){
                    arr[1][idx]=2;
                }else{
                    arr[1][idx]=3;
                }
                idx++;
            }
        }
        idx=0;
        int first= (int) Math.pow(Integer.parseInt(dartResult.substring(0,arr[0][0])),arr[1][0]);
        if(dartResult.charAt(arr[0][idx]+1)=='*'||dartResult.charAt(arr[0][idx]+1)=='#'){
            if(dartResult.charAt(arr[0][idx]+1)=='*'){
                first*=2;
            }else first*=-1;
            arr[0][idx]++;
        }
        idx=1;
        int second= (int) Math.pow(Integer.parseInt(dartResult.substring(arr[0][idx-1]+1,arr[0][idx])),arr[1][idx]);
        if(dartResult.charAt(arr[0][idx]+1)=='*'||dartResult.charAt(arr[0][idx]+1)=='#'){
            if(dartResult.charAt(arr[0][idx]+1)=='*'){
                first*=2;
                second*=2;
            }else {
                second*=-1;
            }
            arr[0][idx]++;
        }
        idx=2;
        int third= (int) Math.pow(Integer.parseInt(dartResult.substring(arr[0][idx-1]+1,arr[0][idx])),arr[1][idx]);
        if(dartResult.charAt(dartResult.length()-1)=='*'||dartResult.charAt(dartResult.length()-1)=='#'){
            if(dartResult.charAt(arr[0][idx]+1)=='*'){
                second*=2;
                third*=2;
            }else third*=-1;
            arr[0][idx]++;
        }
        return first+second+third;
    }
}