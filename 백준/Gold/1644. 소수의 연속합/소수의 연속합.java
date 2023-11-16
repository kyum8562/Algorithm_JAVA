import java.io.*;
import java.util.*;
 
public class Main {
 
    static List<Integer> list;
    static boolean[] isPrime;
    static int N;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
 
		isPrime = new boolean[N+1];
        list = new ArrayList<>();
       
        eratos();
        
        for (int i = 1; i <=N ; i++)
            if(!isPrime[i]) list.add(i);
 
        int s = 0;
        int e = 0;
        int sum = 0;
        int count = 0;
        while (true){
            if(sum >= N) sum -= list.get(s++);
            else if(e == list.size()) break;
            else sum += list.get(e++);
            
            if(N==sum) count++;
        }
 
        System.out.println(count);
    }
    
	private static void eratos() {
        isPrime[0] = isPrime[1] = true;
        
		for(int i = 2 ; i*i <= N ; i ++) {
			if(!isPrime[i]) {
				for(int j=i*i; j<=N; j+=i)
					isPrime[j]=true;      
			}
		}
	}
}