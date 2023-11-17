let ans = 0, v = [], globalM;
function solution(N, map) {
    globalM = map;
    for(let i = 0 ; i < N ; i ++) v[i] = false;
    for(let i = 0 ; i < N ; i ++){
        if(v[i]) continue;
        v[i] = true;
        // console.log(i);
        // console.log(v);
        play(i, N);
        ans++;
    }

    return ans;
}
function play(cur, N){
    for(let next = 0 ; next < N ; next ++){
        if(v[next]) continue;
        if(cur != next && globalM[cur][next] == 1){
            v[next] = true;
            play(next, N);
        }
    }
}