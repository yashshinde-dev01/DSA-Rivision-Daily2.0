import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        // Graph: ingredient -> list of recipes depending on it
        Map<String, List<String>> graph = new HashMap<>();
        
        // Indegree: recipe -> how many ingredients still needed
        Map<String, Integer> indeg = new HashMap<>();
        
        // Initialize indegree
        for (String recipe : recipes) {
            indeg.put(recipe, 0);
        }
        
        // Build graph + indegree
        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            
            for (String ing : ingredients.get(i)) {
                graph.putIfAbsent(ing, new ArrayList<>());
                graph.get(ing).add(recipe);
                
                indeg.put(recipe, indeg.get(recipe) + 1);
            }
        }
        
        // Queue = available supplies
        Queue<String> q = new LinkedList<>();
        for (String s : supplies) {
            q.offer(s);
        }
        
        List<String> ans = new ArrayList<>();
        
        // BFS
        while (!q.isEmpty()) {
            String item = q.poll();
            
            if (!graph.containsKey(item)) continue;
            
            for (String recipe : graph.get(item)) {
                indeg.put(recipe, indeg.get(recipe) - 1);
                
                if (indeg.get(recipe) == 0) {
                    q.offer(recipe);
                    ans.add(recipe);
                }
            }
        }
        
        return ans;
    }
}