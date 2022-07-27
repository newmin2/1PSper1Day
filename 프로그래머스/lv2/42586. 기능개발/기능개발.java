import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer>stack = new Stack<>();
        ArrayList<Integer>list = new ArrayList<>();
        // Queue <Integer> q = new LinkedList<>();
        for(int i= speeds.length-1; i>=0;i--){
            if((100-progresses[i])%speeds[i]==0)
                stack.push((100-progresses[i])/speeds[i]);
            else
                stack.push((100-progresses[i])/speeds[i]+1);
        }
        while(!stack.isEmpty()){
            int cnt=1;
            int a = stack.pop();
            
            while(!stack.isEmpty() && a>=stack.peek()){
                
                stack.pop();
                cnt++;
            }

            list.add(cnt);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i]=list.get(i);
        return answer;
    }
}