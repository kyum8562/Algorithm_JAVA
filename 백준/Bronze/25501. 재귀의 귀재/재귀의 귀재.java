import java.io.*;

public class Main {
    static int N, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String curr = br.readLine();

            cnt = 0;
            System.out.println(isPalindrome(curr) + " " + cnt);
        }
    }

    private static int isPalindrome(String curr) {
        return recursion(curr, 0, curr.length()-1);
    }

    private static int recursion(String curr, int l, int r) {
        cnt++;
        if(l >= r) return 1;
        else if(curr.charAt(l) != curr.charAt(r)) return 0;
        else return recursion(curr, l+1, r-1);
    }
}