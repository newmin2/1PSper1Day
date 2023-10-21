import java.util.*;

class Solution {
    class carRecords{
        int time;
        int state;
        int finalFee;
        carRecords(int time, int state,int finalFee){
            this.time=time;
            this.state=state;
            this.finalFee=finalFee;
        }
    }
    public int[] solution(int[] fees, String[] records) {
        carRecords[] numbers = new carRecords[10000];
        String[] tmp;
        int[] timeTmp;
        int finalFee;
        for(String s : records){
            tmp = s.split(" ");
            int idx = Integer.parseInt(tmp[1]);
            timeTmp = Arrays.stream(tmp[0].split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
            if(numbers[idx]!=null){
                if(numbers[idx].state==1){
                   numbers[idx].state=0;
                    numbers[idx].time=timeTmp[0]*60+timeTmp[1];
                }else{
                    numbers[idx].state=1;
                    int stackTime = timeTmp[0]*60+timeTmp[1]-numbers[idx].time;                  
                    numbers[idx].finalFee+=stackTime;
                }
            }else{
                numbers[idx]=new carRecords(timeTmp[0]*60+timeTmp[1],0,0);
            }
        }
        List<Integer>list = new ArrayList<>();
        for(carRecords cr:numbers){
            if(cr==null)continue;
            if(cr.state==0){
                cr.finalFee+=1439-cr.time;
            }
            if(cr.finalFee>fees[0]){
            cr.finalFee = fees[1]+(cr.finalFee-fees[0]+fees[2]-1)/fees[2]*fees[3];}else{
                cr.finalFee=fees[1];
            }
            list.add(cr.finalFee);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}