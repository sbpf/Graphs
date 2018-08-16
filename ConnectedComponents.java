import java.util.*;


public class ConnectedComponents {

	static class Node
	{
		int val;
		ArrayList<Node> adj;
		Node(int data)
		{
			this.val = data;
			this.adj = new ArrayList<Node>();
		}
	}
	
	public static void printConnectedComponents(ArrayList<Node> vertices)
	{
		HashSet<Integer> visited = new HashSet<Integer>();
		
		for(Node vertex:vertices)
		{
			if(!visited.contains(vertex.val))
			{
				ArrayList<Integer> components = new ArrayList<Integer>();
				getComponents(vertex,visited,components);
				System.out.println("");
				for(int i:components)
				{
					System.out.print(i + "  ");
				}
			}
		}
	}
	
	public static void getComponents(Node current, HashSet<Integer> visited, ArrayList<Integer> components)
	{
		visited.add(current.val);
		components.add(current.val);
		
		for(Node neighbor:current.adj)
		{
			if(!visited.contains(neighbor.val))
				getComponents(neighbor,visited,components);
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
		Node n8 = new Node(80);
		
		n1.adj.add(n2);
		n1.adj.add(n3);
		n2.adj.add(n1);
		n2.adj.add(n4);
		n3.adj.add(n1);
		n3.adj.add(n5);
		n3.adj.add(n4);		
		n4.adj.add(n2);
		n4.adj.add(n3);		
		n5.adj.add(n3);
		n6.adj.add(n7);
		n7.adj.add(n6);
		
		ArrayList<Node> vertices = new ArrayList<Node>();
		vertices.add(n1);
		vertices.add(n2);
		vertices.add(n3);
		vertices.add(n4);
		vertices.add(n5);
		vertices.add(n6);
		vertices.add(n7);
		vertices.add(n8);
		
		printConnectedComponents(vertices);
	}

}
