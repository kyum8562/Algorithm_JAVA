1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
function solution(number, limit, power) {
    var answer = 0;
    for (let n = 1; n <= number; n++)
    {
        let count = 0;
        for (let j = 1; j * j <= n; j++)
        {
            if (j * j == n) count++;
            else if (n % j == 0) count += 2;
        }
        if (count > limit) count = power;
        answer += count;
    }
    return answer;
}