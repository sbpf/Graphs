import java.util.*;
public class KnightProblem extends Node {

	/*Given a square chessboard of N x N size, the position of Knight and position of a target are given.
	We need to find out minimum steps a Knight will take to reach the target position.

	function getKnightMinStep(N, source, dest) {
	   ...
	}*/
	
	
	public KnightProblem(int a, int b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}
	
	public static int getKnightMinStep(int N, Node source, Node dest) 
    {
        int minSteps=0;
        Queue<Node> q = new LinkedList<Node>();
        HashSet<Node> set = new HashSet<Node>();
        q.add(source);
        while(!q.isEmpty())
        {
            Node current = q.remove();
            for(Node n: getAdjacentNodes(current,N))
            {
                if(set.contains(n))
                    continue;
                if(source == n)
                    return minSteps;
                set.add(n);
                q.add(n);
                minSteps++;
            }           
        }          
        return -1;
    }
    
    public static ArrayList<Node> getAdjacentNodes(Node source, int N)
    {
        ArrayList<Node> result = new ArrayList<Node>();
        
        //top right1
        if(source.x+1 <= N && source.y+2 <= N)
            result.add(new Node(source.x+1,source.y+2));
        
        //top right2
        if(source.x+2 <=N && source.y+1 <=N)
            result.add(new Node(source.x+2,source.y+1));
        
        //top left1
        if(source.x-1 > 0 && source.y+2 <= N)
            result.add(new Node(source.x-1,source.y+2));
        
        //top left2
        if(source.x-2 > 0 && source.y+1 <=N)
            result.add(new Node(source.x-2,source.y+1));
        
        //bottom right1
        if(source.x+1 <= N && source.y-2 > 0)
            result.add(new Node(source.x+1,source.y-2));
        
        //bottom right2
        if(source.x+2 <=N && source.y-1 > 0)
            result.add(new Node(source.x+2,source.y-1));
        
        //bottom left1
        if(source.x-1 > 0 && source.y-2 > 0)
            result.add(new Node(source.x-1,source.y-2));
        
        //bottom left2
        if(source.x-2 > 0 && source.y-1 > 0)
            result.add(new Node(source.x-2,source.y-1));
        
        return result;  
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node source = new Node(2,2);
		Node dest = new Node(4,3);
		
		int x = getKnightMinStep(4,source,dest);
		System.out.println("The minimum number of steps:" + x);
	}

}
