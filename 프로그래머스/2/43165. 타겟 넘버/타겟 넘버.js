let N;
let T;
let arr;
let choice;
let answer = 0;
let numbs;
function solution(numbers, target) {
    N = numbers.length;
    arr = new Array(N);
    choice = new Array(N);
    numbs = numbers;
    T = target;
    for(let i = 0 ; i < N ; i ++) choice[i] = false;
    
    comb(0, 0);
    return answer;
}
function comb(depth){
    if(depth == N){
        let sum = 0;
        for(let i = 0 ; i < N ; i ++){
            if(choice[i]) sum += numbs[i];
            else sum += (-1)*numbs[i];
        }
        if(sum == T) answer++;
        return;
    }
    
    choice[depth] = true;
    comb(depth+1);
    
    choice[depth] = false;
    comb(depth+1);
}