class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occInt, int freeStart, int freeEnd) {
        int n = occInt.length;
        Arrays.sort(occInt, (a, b) -> {
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });

        List<List<Integer>> merged = new ArrayList<>();
        int prevX = occInt[0][0];
        int prevY = occInt[0][1];
        for(int i=1; i<n; i++){
            int x = occInt[i][0];
            int y = occInt[i][1];
            if(x>prevY+1){
                List<Integer> list = new ArrayList<>();
                list.add(prevX);
                list.add(prevY);
                merged.add(list);
                prevX = x;
                prevY = y;
            }else{
                prevY = Math.max(prevY, y);
            }
        }
        List<Integer> l = new ArrayList<>();
        l.add(prevX);
        l.add(prevY);
        merged.add(l);

        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> list : merged){
            int x = list.get(0);
            int y = list.get(1);
            if(y<freeStart || x>freeEnd){
                res.add(list);
            }else if(freeStart<=x && y<=freeEnd){
                continue;
            }else{
                if(x<freeStart){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(x);
                    temp.add(freeStart-1);
                    res.add(temp);
                }
                if(y>freeEnd){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(freeEnd+1);
                    temp.add(y);
                    res.add(temp);
                }
            }
        }
        
        return res;
    }
}