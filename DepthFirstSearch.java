import java.util.*;

public class DepthFirstSearch {

	static class Node
	{
		int val;
		ArrayList<Node> neighbors;
		Node(int data)
		{
			this.val=data;
			this.neighbors = new ArrayList<Node>();
		}
	}
	
	//1. print all the nodes in the graph using dfs traversal	
	public static void dfs(ArrayList<Node> vertices)
	{
		HashSet<Integer> visited = new HashSet<Integer>();
		
		for(Node n:vertices)
		{
			if(!visited.contains(n.val))
			{
				//traverse(n,visited);
				dfs_iterative(n,visited);
			}
		}
	}
	
	public static void traverse(Node cur, HashSet<Integer> visited)
	{
		if(cur == null) return;
		visited.add(cur.val);
		System.out.println(cur.val);
		
		for(Node n:cur.neighbors)
		{
			if(!visited.contains(n.val))
				traverse(n,visited);				
		}
	}
	
	//2. dfs-iterative
	public static void dfs_iterative(Node v, HashSet<Integer> visited)
	{		
		Stack<Node> stack = new Stack<Node>();
		visited.add(v.val);
		stack.push(v);
		
		while(!stack.isEmpty())
		{
			Node current = stack.pop();
			System.out.println(current.val);
			
			for(Node neighbor: current.neighbors)
			{
				if(!visited.contains(neighbor.val))
				{
					visited.add(neighbor.val);
					stack.push(neighbor);
				}
			}
		}		
	}
	
	//3. Check if there is a path between a souce node and a destination node	
	public static boolean allNeighborsVisited(Node current, HashSet<Integer> visited)
	{
		if(current == null) return false;
		else
		{
			for(Node n:current.neighbors)
			{
				if(!visited.contains(n.val))
					return false;
			}
			return true;
		}
	}
	
	public static void main(String[] args)
	{
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		
		n1.neighbors.add(n2);
		n1.neighbors.add(n6);
		n2.neighbors.add(n1);
		n2.neighbors.add(n3);
		n2.neighbors.add(n5);
		n3.neighbors.add(n4);		
		n3.neighbors.add(n2);		
		n4.neighbors.add(n3);
		n5.neighbors.add(n2);		
		n5.neighbors.add(n7);
		n5.neighbors.add(n6);
		n7.neighbors.add(n5);
		n6.neighbors.add(n1);
		n6.neighbors.add(n5);
		
		
		ArrayList<Node> vertices = new ArrayList<Node>();
		vertices.add(n1);
		vertices.add(n2);
		vertices.add(n3);
		vertices.add(n4);
		vertices.add(n5);
		vertices.add(n6);
		vertices.add(n7);
		
		dfs(vertices);		
	}
}
