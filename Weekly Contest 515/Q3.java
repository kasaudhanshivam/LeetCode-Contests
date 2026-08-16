class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length();
        int[] leftmost = new int[n];
        int[] rightmost = new int[n];

        int i = 0;
        int j = 0;
        while(i<n){
            char ch = skill.charAt(i);
            if(station.charAt(j)==ch){
                leftmost[i] = j;
                i++;
                j++;
            }else{
                j++;
            }
        }
        
        i = n-1;
        j = station.length()-1;
        while(i>=0){
            char ch = skill.charAt(i);
            if(station.charAt(j)==ch){
                rightmost[i] = j;
                i--;
                j--;
            }else{
                j--;
            }
        }

        int max = 0;
        for(int k=1; k<n; k++){
            int gap = rightmost[k] - leftmost[k-1];
            max = Math.max(max, gap);
        }
        return max;
    }
}