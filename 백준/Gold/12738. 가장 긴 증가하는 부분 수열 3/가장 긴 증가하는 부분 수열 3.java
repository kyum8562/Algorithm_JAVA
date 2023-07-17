import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * LIS(가장 긴 증가하는 부분 수열 5) - [이분탐색]
 * 해당 문제는 기본 LIS만 사용해서 풀 경우, 입력값이 최대 1,000,000의 큰 값이기 때문에 시간초과가 발생하는 문제이다.
 * 또한 [가장 긴 증가하는 부분 수열 2]에서 수열 A를 이루고 있는 Ai의 범위가 100만 이었지만 10억으로 증가했다. (-1,000,000,000 ≤ Ai ≤ 1,000,000,000)
 *
 * 먼저 N만큼 순회하면서, target이 list의 마지막 값보다 클 경우 list에 값을 넣어주고
 * 그렇지 않을 경우, 이분 탐색을 통해 찾은 mid을 이용하여 list.set(mid, target)와 같이 값을 대치하는 방식으로 진행을 한다.
 * 또한
 *
 * https://www.acmicpc.net/problem/14003
 */
public class Main {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        list.add(Integer.MIN_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
            binarySearch(arr[i]);
        }

        System.out.println(list.size()-1);
    }
    private static void binarySearch(int target){
        if(target > list.get(list.size()-1)) list.add(target);
        else{
            int left = 0;
            int right = list.size()-1;

            while(left < right){
                int mid = (left + right) / 2;

                if(list.get(mid) < target) left = mid + 1;
                else right = mid;
            }
            list.set(right, target);
        }
    }
}