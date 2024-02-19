import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {

        int maxTopics = 0;
        int maxTeams = 0;
        int n = topic.size();
        int m = topic.get(0).length();

        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                int count = 0;
                for(int k = 0; k < m; k++){
                    if(topic.get(i).charAt(k) == '1' || topic.get(j).charAt(k) == '1'){
                        count++;
                    }
                }
                if(count > maxTopics){
                    maxTopics = count;
                    maxTeams = 1;
                }else if(count == maxTopics){
                    maxTeams++;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(maxTopics);
        result.add(maxTeams);

        return result;

    }

}

public class Solution49 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String topicItem = bufferedReader.readLine();
            topic.add(topicItem);
        }

        List<Integer> result = Result.acmTeam(topic);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
