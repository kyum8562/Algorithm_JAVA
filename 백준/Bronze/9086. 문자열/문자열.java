import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-- >0){
            char[] s = br.readLine().toCharArray();
            System.out.print(s[0]);
            System.out.print(s[s.length-1]);
            System.out.println();
        }
    }
}