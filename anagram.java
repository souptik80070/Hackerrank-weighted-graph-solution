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
     * Complete the 'anagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
public static int anagram(String s) {
    int n = s.length();

    if (n % 2 != 0) {
        return -1;
    }

    char[] a1 = s.substring(0, n / 2).toCharArray();
    char[] a2 = s.substring(n / 2).toCharArray();

    java.util.Arrays.sort(a1);
    java.util.Arrays.sort(a2);

    int i = 0;
    int j = 0;
    int changes = 0;

    while (i < a1.length && j < a2.length) {
        if (a1[i] == a2[j]) {
            i++;
            j++;
        } else if (a1[i] < a2[j]) {
            changes++;
            i++;
        } else {
            j++;
        }
    }

    

    return changes;
}





}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.anagram(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
