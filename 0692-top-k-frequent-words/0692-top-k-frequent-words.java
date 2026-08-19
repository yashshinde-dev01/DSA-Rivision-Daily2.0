class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer>map=new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<String>pq=new PriorityQueue<>(
           (a,b)->{
            if(map.get(a).equals(map.get(b))){
                return b.compareTo(a);
            }
            return map.get(a)-map.get(b);
           }
        );
        for(String key:map.keySet()){
            pq.add(key);
            if(pq.size()>k){
                pq.poll();
            }
        }
        ArrayList<String>lst=new ArrayList<>();
        for(int i=0;i<k;i++){
            lst.add(pq.poll());
        }
        Collections.reverse(lst);
        return lst;
    }
}