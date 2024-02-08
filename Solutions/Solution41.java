import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {

        int commonLength = 0;
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                break;
            }
            commonLength++;
        }

        int minOperations = (s.length() - commonLength) + (t.length() - commonLength);
        if (k >= s.length() + t.length() || (k >= minOperations && (k - minOperations) % 2 == 0)) {
            return "Yes";
        } else {
            return "No";
        }

    }

}

public class Solution41 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
