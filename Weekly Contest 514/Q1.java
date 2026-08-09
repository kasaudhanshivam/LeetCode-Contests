class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        int n = prices.length;
        int m = discounts.length;

        Arrays.sort(prices);
        Arrays.sort(discounts);
        double sum = 0;
        int i=n-1;
        int j=m-1;
        while(i>=0 && j>=0){
            double p = prices[i];
            double d = discounts[j];

            double newP = (p * (100 - d)) / 100;
            sum += newP;

            i--;
            j--;
        }

        while(i>=0){
            sum += (double)prices[i];
            i--;
        }
        return sum;
    }
}