import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
0 빈칸 
1~6 칸에있는 물고기 크기
9 아기상어 위치

1. 입력을 받으면서 아기상어 위치 x ,y좌표 얻음
2. 입력을 받는데 물고기가 없다면 0출력후 종료
3. (입력을 받으면서) 물고기의 위치(x,y)를 저장하는 메소드 생성[ 물고기 위치 저장]
4. 물고기 위치에 따른 아기상어와의 거리 측정(가장 가까운 먹어야할 타겟 정하기)
5. bfs & 레벨별 탐색(시간 체크) & 사방탐색 후 먹고 다시 3번~4번 진행

 * 신경써야할 부분
- 벌크업하기 위한 카운트 생성(먹을때 ++)
- 먼저 먹어야 할 순서 정하기(먹을 수 있는 애 먼저)
- 못먹으면 종료조건발생
- 같은 물고기는 이동가능
 */
public class Main {
	static int INF = 987654321;
	static int N, time, miniSharkLevel, sharkExp;
	static int startX, startY;
	static int[][] map;
	static int[] tmpxxx; // 물고기 중 가장 먼저 & 가까이 먹어야 하는 인덱스 순서;
	final static int[] dx = {-1, 0, 1, 0};
	final static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		
		map = new int[20][20];// 지도(입력 행렬)

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = stoi(st.nextToken());
				if(map[i][j] == 9) {
					startX = i;
					startY = j;
					map[i][j] =0;
				}
			}
		}

		System.out.println(solution(startX, startY));
	}
	static int solution(int r, int c) {
		time = 0;
		sharkExp = 2;       // 상어 경험치
		miniSharkLevel = 2; // 상어 레벨
		Coords target = new Coords(r, c, 0);
		
		do{
			boolean[][] isVisited = new boolean[20][20];
			Queue<Coords> q = new ArrayDeque<>();
			isVisited[target.x][target.y] = true;
			q.offer(new Coords(target.x, target.y, 0));
			target.d = INF;
			
			while(!q.isEmpty()) {
				Coords curr = q.poll();
				
				if(target.d < curr.d) break;
				if(miniSharkLevel < map[curr.x][curr.y]) continue;
				if(map[curr.x][curr.y] != 0 && miniSharkLevel > map[curr.x][curr.y]) {
					if(target.d > curr.d) {
						target = curr;
					}
					else if(target.d == curr.d) {
						// 윗조건
						if(target.x > curr.x) {
							target = curr;
						}
						else if(target.x == curr.x && target.y > curr.y){
							target = curr;
						}
					}
					continue;
				}

				for(int d = 0 ; d < 4 ; d ++) {
					int nx = curr.x + dx[d];
					int ny = curr.y + dy[d];

					if(isValid(nx, ny)) {
						// 방문하지 않았을 경우
						if(!isVisited[nx][ny]) {
							isVisited[nx][ny] = true;
							q.offer(new Coords(nx, ny, curr.d+1));
						}
					}
				}
			}
			// 상어 먹방
			if(target.d != INF) {
				time += target.d;
				if(--sharkExp == 0) {
					miniSharkLevel++;
					sharkExp = miniSharkLevel;
				}
				map[target.x][target.y] = 0;
			}

		}while(target.d != INF);

		return time;

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static class Coords{
		int x;
		int y;
		int d;
		public Coords(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	static boolean isValid(int nx, int ny) {
		return (nx>=0 && ny>=0 && nx<N && ny<N);
	}
}