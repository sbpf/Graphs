import java.util.*;

public class TopologicalSort {
	
	static class Vertex
	{
		char val;
		ArrayList<Vertex> neighbors;
		Vertex(char data)
		{
			this.val = data;
			this.neighbors = new ArrayList<Vertex>();
		}		
	}
	
	public static void topologicalSort (ArrayList<Vertex> vertices)
	{
		HashMap<Vertex,Integer> inDegrees = new HashMap<Vertex,Integer>();
		Queue<Vertex> q = new LinkedList<Vertex>();
		
		for(int i = 0; i<vertices.size(); i++)
		{
			inDegrees.put(vertices.get(i),0);
		}
		
		//compute in degrees		
		for(Vertex v: vertices)
		{
			for(Vertex n:v.neighbors)
			{
				int ind = inDegrees.get(n);
				inDegrees.put(n,ind+1);
			}
		}
		
		for(Map.Entry<Vertex,Integer> entry : inDegrees.entrySet())
		{
			if(entry.getValue() == 0)
				q.add(entry.getKey());
		}
		
		while(!q.isEmpty())
		{
			Vertex cur = q.poll();
			for(Vertex neighbor : cur.neighbors)
			{
				int ind = inDegrees.get(neighbor);
				inDegrees.put(neighbor,ind-1);
				if(ind==1)
					q.add(neighbor);				
			}
			System.out.println(cur.val);
		}
	}

	public static void main(String[] args)
	{
		Vertex v1 = new Vertex('A');
		Vertex v2 = new Vertex('B');
		Vertex v3 = new Vertex('C');
		Vertex v4 = new Vertex('D');
		
		v1.neighbors.add(v2);
		v1.neighbors.add(v3);
		
		v2.neighbors.add(v3);
		v2.neighbors.add(v4);
		
		v3.neighbors.add(v4);
		
		ArrayList<Vertex> input = new ArrayList<Vertex>();
		input.add(v1);
		input.add(v2);
		input.add(v3);
		input.add(v4);
		
		topologicalSort(input);
	}

}
