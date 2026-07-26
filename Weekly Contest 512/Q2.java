class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> res = new ArrayList<>();

        int i=0;
        int j=0;
        while(i<series1.length && j<series2.length){
            List<Integer> list = new ArrayList<>();
            if(series1[i][0]<series2[j][0]){
                list.add(series1[i][0]);
                list.add(series1[i][1]+series2[j][1]);
                i++;
            }else if(series1[i][0]>series2[j][0]){
                list.add(series2[j][0]);
                list.add(series1[i][1]+series2[j][1]);
                j++;
            }else{ // equal
                list.add(series1[i][0]);
                list.add(series1[i][1] + series2[j][1]);
                i++;
                j++;
            }
            res.add(list);
        }

        while(i<series1.length){
            List<Integer> list = new ArrayList<>();
            list.add(series1[i][0]);
            list.add(series1[i][1]);
            i++;
            res.add(list);
        }
        while(j<series2.length){
            List<Integer> list = new ArrayList<>();
            list.add(series2[j][0]);
            list.add(series2[j][1]);
            j++;
            res.add(list);
        }
        return res;
    }
}