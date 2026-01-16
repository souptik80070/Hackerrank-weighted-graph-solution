import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'weightedUniformStrings' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY queries
     */

    public static List<String> weightedUniformStrings(String s, List<Integer> queries) {
    int a[]=new int[s.length()];
    char c =0;
    for(int i =0;i<s.length();i++){
        a[i]=s.charAt(i)-96;
        if(s.charAt(i)==c){
            a[i]=a[i]+a[i-1];
        }
        c=s.charAt(i);
    }
    
    String st[]=new String[queries.size()];
    for(int i=0;i<quires.size();i++){
        st[i]="No";
        for(int j =0;j<a.length;j++){
            if(quires[i]==a[j]){
                st[i]="Yes";
                break;
            }
        }
    }
    return st;
    

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> queries = new ArrayList<>();

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = Integer.parseInt(bufferedReader.readLine().trim());
            queries.add(queriesItem);
        }

        List<String> result = Result.weightedUniformStrings(s, queries);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
