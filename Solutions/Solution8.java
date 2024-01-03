import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {

        long min = arr.get(2); //we get an element from array because if we say 0 and if there is no 0 in the array it is always min value as false value.
        long max = arr.get(0);
        long totalSum = 0;
        
        for(int i = 0; i < arr.size(); i++){
            totalSum += arr.get(i);
            if(max < arr.get(i)){
                max = arr.get(i);
            }
            if (min > arr.get(i)) {
                min = arr.get(i);
            }
        }
        System.out.println(totalSum - max + " " + (totalSum - min));

    }

}

public class Solution8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
