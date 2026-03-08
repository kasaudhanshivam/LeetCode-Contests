class Solution {
    char[] copy;
    public void merge(char[] str, int l, int mid, int r){
        int i = l;
        int j = mid+1;

        int itr = l;
        
        while(i<=mid && j<=r){
            if(str[i]<=str[j]){
                copy[itr++] = str[i];
                i++;
            }else{
                copy[itr++] = str[j];
                j++;
            }
        }

        while(i<=mid) copy[itr++] = str[i++];
        while(j<=r) copy[itr++] = str[j++];

        itr = l;
        while(itr<=r){
            str[itr] = copy[itr];
            itr++;
        }
    }
    public void mergeSort(char[] str, int l, int r){
        if(l==r) return;

        int mid = l+(r-l)/2;
        mergeSort(str, l, mid);
        mergeSort(str, mid+1, r);
        merge(str, l, mid, r);
    }
    public boolean isSorted(char[] str){
        for(int i=0; i<str.length-1; i++){
            if(str[i]>str[i+1]){
                return false;
            }
        }
        return true;
    }
    public int minOperations(String s) {
        int n = s.length();
        char[] str = s.toCharArray();
        copy = new char[n];
        if(isSorted(str)) return 0;
        if(s.length()<2) return 0;
        if(n==2) return -1;

        int op = 0;
        mergeSort(str, 0, n-2);
        if(isSorted(str)) return 1;
        op = 1;

        char[] str1 = s.toCharArray();
        mergeSort(str1, 1, n-1);
        if(isSorted(str1)) return 1;
        op = 1;

        mergeSort(str, 1, n-1);
        if(isSorted(str)) return 2;

        mergeSort(str1, 0, n-2);
        if(isSorted(str1)) return 2;
        
        return 3;
    }
}