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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {

        // simplifying the string as part is easier to work with
        String start = s.substring(0, 2); // 12
        String end = s.substring(2, 8); //:00:00PM or :00:00AM
        int hour = Integer.parseInt(start); //We parse the string to int to be able to work with it

        if (s.contains("PM") && hour < 12){
            hour += 12;
            start = String.valueOf(hour);
            
        } else if (s.contains("AM") && hour == 12){
            start = "00";

        }
        s = start+ end;
        return s;
    }


        }
public class Solution10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
