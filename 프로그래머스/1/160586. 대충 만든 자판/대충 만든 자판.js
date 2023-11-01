let map = {};
let arr = [];
function solution(keymap, targets) {
    for(let i = 0 ; i < keymap.length; i ++){
        let len = keymap[i].length;
        let curr = keymap[i];
        for(let j = 0 ; j < len ; j ++){
            let tmp = curr.charAt(j);
            if(map[tmp]){
                if(map[tmp] > j) map[tmp] = j+1;
            }
            else map[tmp] = j+1;
        }
    }
    for(let i = 0 ; i < targets.length; i ++){
        let len = targets[i].length;
        let curr = targets[i];
        let cnt = 0;
        for(let j = 0 ; j < len ; j ++){
            let tmp = curr.charAt(j);
            
            if(map[tmp]) cnt += map[tmp];
            else{
                cnt = -1;
                break;
            }
        }
        arr.push(cnt);
    }

    return arr;
}