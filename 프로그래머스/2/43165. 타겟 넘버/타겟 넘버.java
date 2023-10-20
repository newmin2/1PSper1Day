class Solution {
    int cnt=0;
    
    void findTarget(int[] numbers, int sum,int depth,int target){
        if(depth == numbers.length){
            if(sum==target) cnt++;
            return;
        }
        findTarget(numbers, sum+numbers[depth],depth+1,target);
        findTarget(numbers, sum-numbers[depth],depth+1,target);
    }
    
    public int solution(int[] numbers, int target) {
        findTarget(numbers, 0,0,target);
        return cnt;     
    }
}