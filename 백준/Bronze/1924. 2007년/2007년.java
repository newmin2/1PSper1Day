import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] day= {"MON","TUE","WED","THU","FRI","SAT","SUN"};
        int[] dayCnt = {0,31,59,90,120,151,181,212,243,273,304,334,365};
        int[] input = Stream.of(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        System.out.println(day[(dayCnt[input[0]-1]+input[1]-1)%7]);
    }
}