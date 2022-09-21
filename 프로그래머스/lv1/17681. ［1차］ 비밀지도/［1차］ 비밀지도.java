class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[] arr3 = new int[n];
        StringBuilder sb = new StringBuilder();
        String[] answer = new String[n];
        for(int i=0; i<n;i++){
            arr3[i] = arr1[i]|arr2[i];
            for(int j=0; j<n;j++){
                if((arr3[i]&((1<<n-1)>>j))>0)
                    sb.append("#");
                else sb.append(" ");
            }
            answer[i]=sb.toString();
            sb.setLength(0);
        }
        return answer;
    }
}