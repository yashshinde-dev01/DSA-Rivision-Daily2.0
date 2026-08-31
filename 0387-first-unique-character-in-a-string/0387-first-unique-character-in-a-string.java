class Solution {
    public int firstUniqChar(String s) {
     HashMap<Character,Integer>map=new HashMap<>();
     Queue<Character>que=new LinkedList<>();
     for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        map.put(ch,map.getOrDefault(ch,0)+1);
     }
     for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        if(map.get(ch)<2){
            return i;
        }
     }
     return -1;
     
    }
}