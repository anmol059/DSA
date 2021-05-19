package graphsPack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class graphsImpl {
	// Assumptions for implement Graph as a data structure 
	// 1. All the vertices start from 0 and are like 0,1,2,3,4 and so on
	// It means all vertices are numeric of type integer
	// secondly these are sequential
	public static void dfTraversal(int [][]adjMatrix, int currentVertex, boolean[] visited) {
		visited[currentVertex] = true;
		System.out.print(currentVertex + " ");
		for(int i = 0; i < adjMatrix.length; i++)
		{
			if(adjMatrix[currentVertex][i] == 1 && visited[i] == false)
			{
				dfTraversal(adjMatrix, i, visited);
			}
		}
	}
	public static void dfTraversal(int [][]adjMatrix) {
		boolean visited[] = new boolean[adjMatrix.length];
		for(int i = 0; i < adjMatrix.length; i++)
		{
			if(!visited[i])
			{
				dfTraversal(adjMatrix, i, visited);
				System.out.println();
			}
		}
	}
	
	public static void bfs(int [][]adjMatrix) {
        Queue<Integer> pendingVertices = new LinkedList<>();
        boolean visited[] = new boolean[adjMatrix.length];
        visited[0] = true;
        pendingVertices.add(0);
        for(int i = 0; i < adjMatrix.length; i++)
        {
        	if(!visited[i])
        	{
        		pendingVertices.add(i);
        		while(!pendingVertices.isEmpty())
        		{
                    int currentVertex = pendingVertices.poll();
                    System.out.print(currentVertex + " ");
                    for(int j = 0; i < adjMatrix.length; j++)
                    {
                        if(adjMatrix[currentVertex][j] == 1 && !visited[j])
                        {
                            pendingVertices.add(j);
                            visited[j] = true;
                        }
                    }
                }
        	}
        	System.out.println();
        }
    }
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		// enter number of vertices
		int n = sc.nextInt();
		// enter number of edges
		int e = sc.nextInt();
		// If you get the vertices then you can surely make adjacency matrix
		int adjMatrix[][] = new int[n][n];

		// start entering edges of graph
		for(int i = 0; i < e; i++)
		{
			// Enter 1st vertex of edge
			int v1 = sc.nextInt();
			// Enter 2nd vertex of edge
			int v2 = sc.nextInt();
			adjMatrix[v1][v2] = 1;
			adjMatrix[v2][v1] = 1;
		}

		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
//		dfTraversal(adjMatrix);
//		System.out.println();
//		bfs(adjMatrix);
//		sc.close();
	}
}
