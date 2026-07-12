class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        int s_hr = Integer.parseInt(startTime.substring(0, 2));
        int e_hr = Integer.parseInt(endTime.substring(0, 2));

        int s_min = Integer.parseInt(startTime.substring(3, 5));
        int e_min = Integer.parseInt(endTime.substring(3, 5));

        int s_sec = Integer.parseInt(startTime.substring(6, 8));
        int e_sec = Integer.parseInt(endTime.substring(6, 8));

        int start = (s_hr*3600) + (s_min*60) + s_sec;
        int end = (e_hr*3600) + (e_min*60) + e_sec;

        return end-start;
    }
}