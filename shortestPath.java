import java.util.*;

public class shortestPath {

	public int[] dijkstras(int[][] adjacency, int source)
	{
		int verticesCount = adjacency.length;
		int [] distance = new int[verticesCount];
		boolean visited[] = new boolean[verticesCount];
		
		Queue<Integer> Q = new PriorityQueue<Integer>();
		Q.add(source);
		
		//initialize the distance and the visit arrays		
		for(int i=0; i<verticesCount; i++)
		{
			if(i==source)
				distance[i] = 0;
			else
				distance[i] = Integer.MAX_VALUE;
			
			visited[i] = false;
		}
		
		while(!Q.isEmpty())
		{
			//int i = Q.
		}
		
		return distance;
	}
	
	public static void main(String[] args) {
		

	}
}
