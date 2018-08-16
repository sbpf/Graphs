import java.util.*;

public class MinDistanceFromSrcToDest {

	static class Vertex
	{
		int val;
		ArrayList<Vertex> neighbors;
		Vertex(int data)
		{
			this.val = data;
			this.neighbors = new ArrayList<Vertex>();
		}		
	}
	
	//Given Source and Destination, compute the shortest distance between them
	public static int getMinDistance(Vertex source, Vertex destination)
	{
		Queue<Vertex> q = new LinkedList<Vertex>();
		HashSet<Integer> visited = new HashSet<Integer>();
		HashMap<Integer,Integer> distance = new HashMap<Integer,Integer>();
		q.add(source);
		distance.put(source.val,0);
		
		while(!q.isEmpty())
		{			
			Vertex temp = q.remove();
						
			visited.add(temp.val);
			int dist = distance.get(temp.val);
			
			if(temp == destination)
				return dist;
			
			for(Vertex v:temp.neighbors)
			{
				if(!visited.contains(v.val))
				{
					q.add(v);
					distance.put(v.val,dist+1);
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args)
	{
		Vertex n1 = new Vertex(10);
		Vertex n2 = new Vertex(20);
		Vertex n3 = new Vertex(30);
		Vertex n4 = new Vertex(40);
		Vertex n5 = new Vertex(50);
		Vertex n6 = new Vertex(60);
		Vertex n7 = new Vertex(70);
		
		n1.neighbors.add(n2);
		n1.neighbors.add(n6);
		n2.neighbors.add(n1);
		n2.neighbors.add(n3);
		n2.neighbors.add(n5);
		n3.neighbors.add(n4);		
		n3.neighbors.add(n2);
		n3.neighbors.add(n7);
		n4.neighbors.add(n3);
		n5.neighbors.add(n2);		
		n5.neighbors.add(n7);
		n5.neighbors.add(n6);
		n7.neighbors.add(n5);
		n7.neighbors.add(n3);
		n6.neighbors.add(n1);
		n6.neighbors.add(n5);
		
		System.out.println(getMinDistance(n1,n6));
	}

}
