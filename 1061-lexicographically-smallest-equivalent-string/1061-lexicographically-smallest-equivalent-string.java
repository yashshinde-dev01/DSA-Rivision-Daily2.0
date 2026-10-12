import java.util.*;

class Solution {

    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        HashMap<Character, ArrayList<Character>> adj = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char u = s1.charAt(i);
            char v = s2.charAt(i);

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < baseStr.length(); i++) {

            char ch = baseStr.charAt(i);
            boolean[] visi = new boolean[26];

            char minChar = dfs(adj, ch, visi);

            ans.append(minChar);
        }

        return ans.toString();
    }

    char dfs(HashMap<Character, ArrayList<Character>> adj,
             char ch, boolean[] visi) {

        visi[ch - 'a'] = true;

        char minChar = ch;

        if (adj.containsKey(ch)) {
            for (char neighbour : adj.get(ch)) {

                if (!visi[neighbour - 'a']) {
                    char result = dfs(adj, neighbour, visi);

                    minChar = (char) Math.min(minChar, result);
                }
            }
        }

        return minChar;
    }
}