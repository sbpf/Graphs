import java.util.*;

public class Graph 
{
	HashMap<Integer, Node> nodesMap = new HashMap<Integer,Node>();
	
	class Node{
		Integer id;
		Integer val;
		LinkedList<Node> adjacency = new LinkedList<Node>();		
		
		Node(Integer id, Integer val){
			this.id = id;
			this.val = val;			
		}
	}
		
	public Node getNode(Integer id)
	{
		if(nodesMap.containsKey(id))
		{
			return nodesMap.get(id);
		}
		return null;
	}
	
	public void addEdge(int source, int destination)
	{
		Node src = getNode(source);
		Node dest = getNode(destination);
		if(dest !=null)
		src.adjacency.add(dest);			
	}
	

	public void printAdjacency(Node n)
	{
		System.out.println("printing adjacency for"+ n.val);
		for(Node adj:n.adjacency)
		{
			System.out.println("--"+adj.val+"---");
		}
	}
	
	public boolean hasPathDFS(Integer source, Integer destination)
	{
		HashSet<Integer> visited = new HashSet<Integer>();
		Node src = getNode(source);
		Node dest = getNode(destination);
		
		if(src!=null && dest!=null)
		return hasPathDFS(src,dest,visited);
		
		return false;
	}
	
	private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited)
	{
		if(visited.contains(source.id)) 
		{
			return false;
		}
		
		visited.add(source.id);
		
		if (source == destination)
		{
			return true;
		}
				
		for(Node child:source.adjacency)
		{
			if(hasPathDFS(child,destination,visited))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean hasPathBFS(Integer source, Integer destination)
	{
		HashSet<Integer> visited = new HashSet<Integer>();
		Queue<Node> Q = new LinkedList<Node>();
		Node src = getNode(source);
		Node dest = getNode(destination);
		Q.add(src);
		
		while(!Q.isEmpty())
		{
			Node temp = Q.remove();
			
			if(temp == dest)
				return true;
			
			if(visited.contains(temp.id))
				continue;
			
			visited.add(temp.id);
			
			for(Node child: temp.adjacency)
			{
				Q.add(child);
			}
		}
		
		return false;
	}
	
	public static void main(String[] args)
	{
		Graph g = new Graph();
		Node n1 = g.new Node(1,10);
		Node n2 = g.new Node(2,20);
		Node n3 = g.new Node(3,30);
		Node n4 = g.new Node(4,40);
		Node n5 = g.new Node(5,50);
		
		g.nodesMap.put(1,n1);
		g.nodesMap.put(2,n2);
		g.nodesMap.put(3,n3);
		g.nodesMap.put(4,n4);
		g.nodesMap.put(5,n5);
		
		g.addEdge(1, 2);		
		g.addEdge(1, 3);		
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		
		System.out.println("printing adjacency");
		g.printAdjacency(n1);
		g.printAdjacency(n2);
		g.printAdjacency(n3);
		g.printAdjacency(n4);
		g.printAdjacency(n5);

		System.out.println("DFS---------------");
		System.out.println(g.hasPathDFS(1,5));
		
		System.out.println("BFS---------------");
		System.out.println(g.hasPathBFS(1,4));
	}
}
