class Solution {
    public int minGenerations(int[][] points, int[] target) {
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] p : points){
            list.add(p);
        }

        int k = 0;
        while(true){
            int n = list.size();
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(i==j) continue;

                    int cx = (int)Math.floor(((double)list.get(i)[0]+list.get(j)[0])/2);
                    int cy = (int)Math.floor(((double)list.get(i)[1]+list.get(j)[1])/2);
                    int cz = (int)Math.floor(((double)list.get(i)[2]+list.get(j)[2])/2);

                    if(cx==target[0] && cy==target[1] && cz==target[2]) return k;

                    list.add(new int[]{cx, cy, cz});
                }
            }
            k++;
        }
        // return -1;
    }
}