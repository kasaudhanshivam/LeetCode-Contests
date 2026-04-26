class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> loc = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                map.put(ch, map.getOrDefault(ch, 0)+1);
                loc.putIfAbsent(ch, i);
            }
        }

        Character[] vowels = new Character[5];
        vowels[0] = 'a';
        vowels[1] = 'e';
        vowels[2] = 'i';
        vowels[3] = 'o';
        vowels[4] = 'u';
        Arrays.sort(vowels, (a, b) -> {
            if(map.getOrDefault(b, 0).equals(map.getOrDefault(a, 0))) return loc.getOrDefault(a, n)-loc.getOrDefault(b, n);
            return map.getOrDefault(b, 0)-map.getOrDefault(a, 0);
        });

        int itr = 0;
        for(int i=0; i<5; i++){
            if(!map.containsKey(vowels[itr])) itr++;
            else break;
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                sb.append(vowels[itr]);
                map.put(vowels[itr], map.get(vowels[itr])-1);
                while(itr<5 && map.getOrDefault(vowels[itr], 0)==0){
                    itr++;
                }
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}