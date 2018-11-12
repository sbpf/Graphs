import java.util.*;

public class TopologicalSortPractice {

	public static class Edge
	{
		String start;
		String end;
		public Edge(String start, String end)
		{
			this.start = start;
			this.end = end;
		}
	}
	
	public static List<String> topologicalSort(List<Edge> courseDependencies)
	{
		HashMap<String,Integer> indegrees = new HashMap<String,Integer>();
		HashMap<String,List<String>> adjacency = new HashMap<String,List<String>>();
		ArrayList<String> result = new ArrayList<String>();
		
		//Calculate the dependencies
		getAdjacencyAndIndegrees(courseDependencies, indegrees, adjacency);
		
		Queue<String> q = new LinkedList<String>();
		
		//initialize the queue with all the nodes with indegrees 0
		for(Map.Entry<String,Integer> entry: indegrees.entrySet())
		{
			if(entry.getValue() == 0)
			{
				q.add(entry.getKey());
			}
		}
		
		//while queue is not empty, poll from queue and decrement the in-degrees of all it's neighbors		
		while(!q.isEmpty()) {
			String cur = q.poll();
			result.add(cur);
			
			if(adjacency.containsKey(cur))
			for(String s: adjacency.get(cur))
			{
				int inCur = indegrees.get(s);
				inCur--;
				
				if(inCur == 0)
				{
					q.add(s);					
				}
				
				indegrees.put(s, inCur); // updating indegrees map				
			}
		}
		
		return result;
	}
	
	public static void getAdjacencyAndIndegrees(List<Edge> dependencies, HashMap<String,Integer> indegrees, HashMap<String, List<String>> adjacency)
	{
		for(Edge e: dependencies)
		{
			if(!indegrees.containsKey(e.end))
			{
				indegrees.put(e.end, 1);
			}
			else
			{
				indegrees.put(e.end, indegrees.get(e.end)+1);
			}
			
			if(!indegrees.containsKey(e.start)) {
				indegrees.put(e.start, 0);
			}
			
			if(!adjacency.containsKey(e.start))
			{
				ArrayList<String> neighbors = new ArrayList<String>();
				neighbors.add(e.end);
				adjacency.put(e.start,neighbors);
			}
			else
			{
				adjacency.get(e.start).add(e.end);
			}
		}
	}
	
	
	
	public static void main(String[] args)
	{
		List<Edge> input = new ArrayList<Edge>();
		Edge e1 = new Edge("A", "B");
		Edge e2 = new Edge("B", "C");
		Edge e3 = new Edge("B","D");
		Edge e4 = new Edge("A", "C");
		Edge e5 = new Edge("C", "D");
		
		input.addAll(Arrays.asList(e1,e2,e3,e4,e5));
		System.out.println(topologicalSort(input));
	}

}
