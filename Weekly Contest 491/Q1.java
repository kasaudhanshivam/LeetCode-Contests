class Solution {
    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') return true;
        return false;
    }
    public String trimTrailingVowels(String s) {
        StringBuilder sb = new StringBuilder(s);

        while(sb.length()>0 && isVowel(sb.charAt(sb.length()-1))){ // until last char != vowel
            sb.deleteCharAt(sb.length()-1); // pop
        }
        return sb.toString();
    }
}