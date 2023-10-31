let R, C;
let map;
function solution(wallpaper) {
    R = wallpaper.length;
    C = wallpaper[0].length;
    map = new Array(R);
    for(let i = 0 ; i < R ; i ++) map[i] = new Array(C);
    
    for(let i = 0 ; i < R ; i ++){
        map[i] = wallpaper[i].split("");
    }
    let sr = 0;
    let sc = 0;
    outer: for(let i = 0 ; i < R ; i ++){
        for(let j = 0 ; j < C ; j ++){
            if(map[i][[j]] == '#'){
                sr = i;
                break outer;
            }
        }
    }
    outer: for(let i = 0 ; i < C ; i ++){
        for(let j = 0 ; j < R ; j ++){
            if(map[j][[i]] == '#'){
                sc = i;
                break outer;
            }
        }
    }
    let er, ec;
    outer: for(let i = R-1 ; i >= 0 ; i --){
        for(let j = C-1 ; j >= 0 ; j --){
            if(map[i][[j]] == '#'){
                er = i;
                break outer;
            }
        }
    }
    outer: for(let i = C-1 ; i >= 0 ; i --){
        for(let j = R-1 ; j >= 0 ; j --){
            if(map[j][i] == '#'){
                ec = i;
                break outer;
            }
        }
    }
    return [sr, sc, er+1, ec+1];
}