import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 새로운 배열을 만들어서 여기다가 하나씩 넣게
public class Main {
	
	public static int[][] arr;
	public static int[][] answer1;
	
	public static int N;
	public static int M;
	public static int R;
	public static int new_N;
	
	// 델타 : {아래, 오른쪽, 위, 왼쪽}
	public static int[] delta_x = {0, 1, 0, -1};
	public static int[] delta_y = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		new_N = Math.max(N, M);
		
		arr = new int[new_N][new_N]; // 입력받은 배열
		
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < M ; j ++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int tcase = 1 ; tcase <= R ; tcase++) {
			int type = Integer.parseInt(st.nextToken());
			
			if(type == 1)
				type1();
			else if(type == 2)
				type2();
			else if(type == 3)
				type3();
			else if(type == 4)
				type4();
			else if(type == 5)
				type5();
			else if(type == 6)
				type6();
		}
		// 출력부
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M ; j ++) {
					sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	// type1: 상하 반전
	public static void type1() {
		answer1 = new int[new_N][new_N]; // 입력받은 배열
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M ; j ++) {
				answer1[N-1-i][j] = arr[i][j];
			}
		}
		arr = answer1;
	}
	
	// type2: 좌우 반전
	public static void type2() {
		answer1 = new int[new_N][new_N]; // 입력받은 배열
		
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M ; j ++) {
				answer1[i][M-1-j] = arr[i][j];
			}
		}
		
		arr = answer1;
	}
	
	// type3: 오른쪽 90도 회전
	public static void type3() {
		answer1 = new int[new_N][new_N]; // 입력받은 배열

		for(int i = 0 ; i < M ; i ++) {
			for(int j = 0 ; j < N ; j ++) {
				answer1[i][j] = arr[N-1-j][i];
			}
		}
		N^=M;
		M^=N;
		N^=M;
		
		arr = answer1;
	}
	
	// type4: 왼쪽 90도 회전
	public static void type4() {
		answer1 = new int[new_N][new_N]; // 입력받은 배열

		for(int i = 0 ; i < M ; i ++) {
			for(int j = 0 ; j < N ; j ++) {
				answer1[i][j] = arr[j][M-1-i];
			}
		}
		
		// swap
		N^=M;
		M^=N;
		N^=M;
		
		arr = answer1;
	}
	
	// type5: 4 분할 시계방향 이동
	public static void type5() {
		answer1 = new int[new_N][new_N]; // 입력받은 배열
		
		// 1 -> 2
		for(int i = 0 ; i < N/2 ; i ++) {
			for(int j = 0 ; j < M/2 ; j ++) {
				answer1[i][j+M/2] = arr[i][j];
			}
		}
		// 2 -> 3
		for(int i = 0 ; i < N/2 ; i ++) {
			for(int j = M/2 ; j < M ; j ++) {
					answer1[i+N/2][j] = arr[i][j];
			}
		}
		// 3 -> 4
		for(int i = N/2 ; i < N ; i ++) {
			for(int j = M/2 ; j < M ; j ++) {
					answer1[i][j-M/2] = arr[i][j];
			}
		}
		// 4 -> 1
		for(int i = N/2 ; i < N ; i ++) {
			for(int j = 0 ; j < M/2 ; j ++) {
					answer1[i-N/2][j] = arr[i][j];
			}
		}
		
		arr = answer1;
	}
	
	// type6: 4 분할 반시계방향 이동
	public static void type6() {
		answer1 = new int[new_N][new_N]; // 입력받은 배열
		
		// 1 -> 4
		for(int i = 0 ; i < N/2 ; i ++) {
			for(int j = 0 ; j < M/2 ; j ++) {
				answer1[i+ N/2][j] = arr[i][j];
			}
		}
		// 4 -> 3
		for(int i = N/2 ; i < N ; i ++) {
			for(int j = 0 ; j < M/2 ; j ++) {
				answer1[i][j+M/2] = arr[i][j];
			}
		}
		
		// 3 -> 2
		for(int i = N/2 ; i < N ; i ++) {
			for(int j = M/2 ; j < M ; j ++) {
				answer1[i-N/2][j] = arr[i][j];
			}
		}
		// 2 -> 1
		for(int i = 0 ; i < N/2 ; i ++) {
			for(int j = M/2 ; j < M ; j ++) {
				answer1[i][j-M/2] = arr[i][j];
			}
		}
		
		arr = answer1;
	}
}