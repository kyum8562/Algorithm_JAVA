import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		int inp = Integer.parseInt(bf.readLine());
		int out = inp * (inp-1);
		System.out.println(out);

	}

}