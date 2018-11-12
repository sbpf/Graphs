
public class EditDistance {

    static String find_order(String[] words)
    {
        HashMap<Character,List<Character>> map = new HashMap<Character,List<Character>>();
        buildAdjacency(words,map);
        for(Map.Entry entry : map.entrySet())
        {
            System.out.println("key: " + entry.getKey() + "    Value:" + entry.getValue());
        }
        return topologicalSort(map);
    }
    
    static String topologicalSort(HashMap<Character,List<Character>> map)
    {
        HashSet visited = new HashSet<Character>();
        HashSet pathSoFar = new HashSet<Character>();
        StringBuilder result = new StringBuilder();
        for(Map.Entry entry : map.entrySet())
        {
            System.out.println("key: " + entry.getKey() + "    Value:" + entry.getValue());
        }
        
        for(Map.Entry entry : map.entrySet())
        {
            char c = entry.getKey();
            if(visited.contains(c))
                continue;
            dfs(c, map, visited, pathSoFar, result);
        }
        return result.reverse().toString();
    }
    
    static void dfs(char c, HashMap map, HashSet visited, HashSet pathSoFar, StringBuilder result)
    {
        if(pathSoFar.contains(c) || visited.contains(c))
            return;
        pathSoFar.add(c);
        visited.add(c);
        
        for(char neighbor: map.get(c))
        {
            dfs(neighbor,map,visited,pathSoFar,result);
        }
        
        pathSoFar.remove(c);
        result.append(c);
    }
    
    static void buildAdjacency(String[] words, HashMap<Character,List<Character>> map)
    {
        for(int currentWord=0; currentWord<words.length-1; currentWord++)
        {
            if(words[currentWord].equals(words[currentWord+1]))
                continue;
                
            int currentAlphabetIndex = 0;
            
            /*while(currentAlphabetIndex < words[currentWord].length() && currentAlphabetIndex < words[currentWord+1].length() &&*/
            while(words[currentWord].charAt(currentAlphabetIndex) == words[currentWord+1].charAt(currentAlphabetIndex))
            {
                currentAlphabetIndex++;
            }
            
            if(currentAlphabetIndex == words[currentWord].length() || currentAlphabetIndex == words[currentWord+1].length())
                continue;
                
            char currentAlphabet = words[currentWord].charAt(currentAlphabetIndex);
            char nextAlphabet = words[currentWord+1].charAt(currentAlphabetIndex);
            
            if(!map.containsKey(currentAlphabet))
            {
                List neighbors = new ArrayList<Character>();
                map.put(currentAlphabet, neighbors);
            }
            List neighborAlphabets = map.get(currentAlphabet);
            neighborAlphabets.add(nextAlphabet);
            map.put(currentAlphabet, neighborAlphabets);
        }
        
        for(Map.Entry entry : map.entrySet())
        {
            System.out.println("key: " + entry.getKey() + "    Value:" + entry.getValue());
        }
    }
    
    


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
