import java.util.*;

public class StringTransformation {

	static String[] string_transformation(String[] words, String start, String stop) 
    {
        Queue<String> queue = new LinkedList<String>();
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        HashSet<String> visited = new HashSet<String>();
        queue.add(start);
        ArrayList<String> path = new ArrayList<String>();
        path.add(start);
        map.put(start, path);
        
        while(!queue.isEmpty())
        {
            String temp = queue.poll();
            if(temp.equals(stop))
                return  getResult(map.get(temp));
            if(visited.contains(temp))
                continue;
                
            visited.add(temp);
            
            if(!map.containsKey(temp))
            {
                ArrayList<String> temp_path = new ArrayList<String>();
                map.put(temp,temp_path);
            }
                
            for(String s : fetchNeighbors(temp,words))
            {
                if(!visited.contains(s))
                {
                    queue.add(s);
                    System.out.println(s);
                    ArrayList<String> tempPath = new ArrayList<String>();
                    tempPath = (ArrayList<String>) map.get(temp).clone();
                    tempPath.add(s);
                    map.put(s, tempPath);
                }
            }
        }
        String[] result = new String[0];
        return result;
    }
    
    static String[] getResult(ArrayList<String> input)
    {
        String[] result = new String[input.size()];
        int i=0;
        for(i=0; i<input.size(); i++)
        {        	
            result[i] = input.get(i);
        }
        
        return result;
    }
    
    static ArrayList<String> fetchNeighbors(String word, String[] input)
    {
        ArrayList<String> neighbors = new ArrayList<String>();
        for(String s:input)
        {        	
            if(areNeighbors(word,s))
                neighbors.add(s);
        }
        return neighbors;
    }

    static boolean areNeighbors(String s1, String s2)
    {
        boolean flag = false;
        for(int i=0; i<s1.length(); i++)
        {
            if(s1.charAt(i) != s2.charAt(i))
            {
                if(flag) return false;
                flag = true;
            }
        }
        return true;
    }
    
	public static void main(String[] args)
	{
		String[] input = {"bad", "had", "hat", "cat"};
		String[] output = string_transformation(input,"bat","had");
		System.out.println("output");
		for(String s:output)
			System.out.println(s);
	}
}
