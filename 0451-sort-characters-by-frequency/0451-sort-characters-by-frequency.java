class Solution {
    public String frequencySort(String s) {
         HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        ArrayList<Character>lst=new ArrayList<>(map.keySet());
        Collections.sort(lst,(a,b)->map.get(b)-map.get(a));

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<lst.size();i++){
            char ch=lst.get(i);
            int freq=map.get(ch);

            for(int j=0;j<freq;j++){
                sb.append(ch);
            }
    
        }
        return sb.toString();

    }
}