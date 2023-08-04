import java.io.*;
import java.util.*;

public class Main {
	static int N, L, R;
	static int[][] map;
	static boolean[][] isVisited;
	static List<Coords> list;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		L = stoi(st.nextToken());
		R = stoi(st.nextToken());
		isVisited = new boolean[N][N];
		map = new int[N][N];
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j ++) {
				map[i][j] = stoi(st.nextToken());
			}
		}

		System.out.println(move());
	}

	static int move() {
		int ans = 0;
		while(true) {
			isVisited = new boolean[N][N];
			boolean isMove = false;
			for(int i = 0 ; i < N ; i ++) {
				for(int j = 0 ; j < N ; j ++) {
					if(!isVisited[i][j]) {
						int sum = bfs(i, j);
						if(list.size() > 1) {
							changePopulation(sum);
							isMove = true;
						}
					}
				}
			}
			if(!isMove)
				return ans;
			ans++;
		}
	}

	static void changePopulation(int sum) {
		int avg = sum / list.size();
		for(int i = 0 ; i < list.size() ; i ++) {
			int r = list.get(i).r;
			int c = list.get(i).c;
			map[r][c] = avg;
			
		}
	}

	static int bfs(int x, int y) {
		Queue<Coords> q = new ArrayDeque<>();
		list = new ArrayList<>();
		q.offer(new Coords(x, y));
		list.add(new Coords(x, y));
		isVisited[x][y] = true;
		int sum = map[x][y];
		while(!q.isEmpty()) {

			Coords curr = q.poll();

			for(int d = 0 ; d < 4 ; d ++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				if(isVaild(nr,nc)) {
					if(!isVisited[nr][nc]) {
						int tmpp = Math.abs(map[nr][nc] - map[curr.r][curr.c]);
						if(tmpp >= L && tmpp <= R) {
							sum += map[nr][nc];
							isVisited[nr][nc] = true;
							list.add(new Coords(nr, nc));
							q.offer(new Coords(nr, nc));
						}
					}
				}
			}
		}
		return sum;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static boolean isVaild(int nr, int nc) {
		return (nr>=0 && nr<N && nc>=0 && nc<N);
	}

	static class Coords{
		int r;
		int c;

		public Coords(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}