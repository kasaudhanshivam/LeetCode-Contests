class Solution {
    public int[] scoreValidator(String[] events) {
        int n = events.length;

        // Just Simulation
        int i=0;
        int ctr = 0;
        int score = 0;
        while(i<n && ctr!=10){ // condition given
            if(events[i].equals("0") || events[i].equals("1") || events[i].equals("2") || events[i].equals("3") || events[i].equals("4") || events[i].equals("6")){
                score += Integer.parseInt(events[i]); // add to score
            }else if(events[i].equals("W")){
                ctr++; // increment counter
            }else if(events[i].equals("WD") || events[i].equals("NB")){
                score++; // increment score
            }
            i++;
        }

        return new int[]{score, ctr};
    }
}