let map;
function solution(number, limit, power) {
    map = new Array(number+1);
    // 약수의 개수 구하기
    // 카운팅
    for(let i = 1 ; i <= number ; i ++){
        yaksu(i);
    }
    console.log(map);
    let ans = 0;
    for(let i = 1 ; i <= number ; i ++){
        if(limit >= map[i]) ans += map[i];
        else ans += power;
    }
    
    return ans;
}
function yaksu(n){
    let cnt = 0;
    for(let i = 1 ; i <= Math.sqrt(n) ; i ++){
        if(n%i == 0){
            if(i*i == n) cnt ++;
            else cnt += 2;
        }
    }
    map[n] = cnt;
    return;
}