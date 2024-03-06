import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer ="";
        String[] strs = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
        Arrays.sort(strs,(o1,o2)-> (o2+o1).compareTo(o1+o2));
        
        if(strs[0].equals("0")) return "0";
        for(String str:strs){
            answer+=str;
        }
        return answer;
    }
}