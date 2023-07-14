import java.io.*;
import java.util.*;

public class Main {
    static int[][][] dp;
    static String resStr12 = "";
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        LCS2(str1, str2, str3);

        System.out.println(dp[str1.length()][str2.length()][str3.length()]);
    }

    static void LCS2(String str1, String str2, String str3) {
        int r = str1.length();
        int c = str2.length();
        int z = str3.length();

        dp = new int[r + 1][c + 1][z + 1];
        for (int i = 1; i < r + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                for (int k = 1; k < z + 1; k++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1) && str2.charAt(j - 1) == str3.charAt(k - 1)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    } else {
                        int tmp = Math.max(dp[i - 1][j][k], dp[i][j - 1][k]);
                        dp[i][j][k] = Math.max(tmp, dp[i][j][k -1]);
                    }
                }
            }
        }

    }

}