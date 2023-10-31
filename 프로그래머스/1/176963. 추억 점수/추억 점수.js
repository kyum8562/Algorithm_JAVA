function solution(name, yearning, photo) {
    let map = {};
    for(let i = 0 ; i < name.length ; i ++)
        map[name[i]] = yearning[i];
    
    return photo.map((arr) =>
    arr.reduce((acc, cur) => acc + (map[cur] || 0), 0));
}