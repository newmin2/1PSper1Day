import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, Integer>trans = new HashMap<>();
        for(int i=0;i<friends.length;i++){
            trans.put(friends[i],i);
        }
        int[][] arr = new int[friends.length][friends.length];
        int[][] point = new int[friends.length][2];
        
        for(String s : gifts){
            String[] tmp = s.split(" ");
            int send = trans.get(tmp[0]);
            int take = trans.get(tmp[1]);
            
            arr[send][take]++;
            point[send][0]++;
            point[take][1]++;
        }
        
        int[] predic = new int[friends.length];
        
        for(int i=0;i<friends.length;i++){
            for(int j=0;j<friends.length;j++){
                if(arr[i][j]>arr[j][i]){
                    predic[i]++;
                }else if(arr[i][j]<arr[j][i]){
                    predic[j]++;
                }else{
                    if(point[i][0]-point[i][1]>point[j][0]-point[j][1]){
                        predic[i]++;
                    }else if(point[i][0]-point[i][1]<point[j][0]-point[j][1]){
                        predic[j]++;
                    }
                }
            }
        }
        Arrays.sort(predic);

        return predic[friends.length-1]/2;
    }
}