//// A Java program for Bellman-Ford's single source shortest
//// path algorithm.
//
//import java.io.*;
//import java.lang.*;
//import java.util.*;
//
//// A class to represent a connected, directed and weighted
//// graph
//class Graph {
//	
//	// A class to represent a weighted edge in graph
//	class Edge {
//		int src, dest, weight;
//		Edge() { src = dest = weight = 0; }
//	};
//
//	int V, E;
//	Edge edge[];
//
//	// Creates a graph with V vertices and E edges
//	Graph(int v, int e)
//	{
//		V = v;
//		E = e;
//		edge = new Edge[e];
//		for (int i = 0; i < e; ++i)
//			edge[i] = new Edge();
//	}
//
//	// The main function that finds shortest distances from
//	// src to all other vertices using Bellman-Ford
//	// algorithm. The function also detects negative weight
//	// cycle
//	void BellmanFord(Graph graph, int src)
//	{
//		int V = graph.V, E = graph.E;
//		int dist[] = new int[V];
//
//		// Step 1: Initialize distances from src to all
//		// other vertices as INFINITE
//		for (int i = 0; i < V; ++i)
//			dist[i] = Integer.MAX_VALUE;
//		dist[src] = 0;
//
//		// Step 2: Relax all edges |V| - 1 times. A simple
//		// shortest path from src to any other vertex can
//		// have at-most |V| - 1 edges
//		for (int i = 1; i < V; ++i) {
//			for (int j = 0; j < E; ++j) {
//				int u = graph.edge[j].src;
//				int v = graph.edge[j].dest;
//				int weight = graph.edge[j].weight;
//				if (dist[u] != Integer.MAX_VALUE
//					&& dist[u] + weight < dist[v])
//					dist[v] = dist[u] + weight;
//			}
//		}
//
//		// Step 3: check for negative-weight cycles. The
//		// above step guarantees shortest distances if graph
//		// doesn't contain negative weight cycle. If we get
//		// a shorter path, then there is a cycle.
//		for (int j = 0; j < E; ++j) {
//			int u = graph.edge[j].src;
//			int v = graph.edge[j].dest;
//			int weight = graph.edge[j].weight;
//			if (dist[u] != Integer.MAX_VALUE
//				&& dist[u] + weight < dist[v]) {
//				System.out.println(
//					"Graph contains negative weight cycle");
//				return;
//			}
//		}
//		printArr(dist, V);
//	}
//
//	// A utility function used to print the solution
//	void printArr(int dist[], int V)
//	{
//		System.out.println("Vertex Distance from Source");
//		for (int i = 0; i < V; ++i)
//			System.out.println(i + "\t\t" + dist[i]);
//	}
//
//	// Driver's code
//	public static void main(String[] args)
//	{
//		int V = 6; // Number of vertices in graph
//		int E = 10; // Number of edges in graph
//
//		Graph graph = new Graph(V, E);
//
//		// add edge 0-1 (or A-B in above figure)
//		graph.edge[0].src = 0;
//		graph.edge[0].dest = 1;
//		graph.edge[0].weight = 1;
//
//		// add edge 0-2 (or A-C in above figure)
//		graph.edge[1].src = 1;
//		graph.edge[1].dest = 3;
//		graph.edge[1].weight = 3;
//		
//		graph.edge[2].src = 1;
//		graph.edge[2].dest = 4;
//		graph.edge[2].weight = -1;
//
//		// add edge 1-2 (or B-C in above figure)
//		graph.edge[3].src = 2;
//		graph.edge[3].dest = 1;
//		graph.edge[3].weight = 5;
//
//		// add edge 1-3 (or B-D in above figure)
//		graph.edge[4].src = 2;
//		graph.edge[4].dest = 4;
//		graph.edge[4].weight = 3;
//
//		// add edge 1-4 (or B-E in above figure)
//		graph.edge[5].src = 2;
//		graph.edge[5].dest = 5;
//		graph.edge[5].weight = 8;
//
//		// add edge 3-2 (or D-C in above figure)
//		graph.edge[6].src = 3;
//		graph.edge[6].dest = 4;
//		graph.edge[6].weight = 2;
//
//		// add edge 3-1 (or D-B in above figure)
//		graph.edge[7].src = 4;
//		graph.edge[7].dest = 0;
//		graph.edge[7].weight = 0;
//
//		// add edge 4-3 (or E-D in above figure)
//		graph.edge[8].src = 4;
//		graph.edge[8].dest = 1;
//		graph.edge[8].weight = 8;
//		
//		graph.edge[9].src = 5;
//		graph.edge[9].dest = 4;
//		graph.edge[9].weight = 3;
//		
//		// Function call
//		graph.BellmanFord(graph, 0);
//	}
//}
//// Contributed by Aakash Hasija


// Bellman Ford Algorithm in Java

class CreateGraph {

  // CreateGraph - it consists of edges
  class CreateEdge {
    int s, d, w;

    CreateEdge() {
      s = d = w = 0;
    }
  };

  int V, E;
  CreateEdge edge[];

  // Creates a graph with V vertices and E edges
  CreateGraph(int v, int e) {
    V = v;
    E = e;
    edge = new CreateEdge[e];
    for (int i = 0; i < e; ++i)
      edge[i] = new CreateEdge();
  }

  void BellmanFord(CreateGraph graph, int s) {
    int V = graph.V, E = graph.E;
    int dist[] = new int[V];

    // Step 1: fill the distance array and predecessor array
    for (int i = 0; i < V; ++i)
      dist[i] = Integer.MAX_VALUE;

    // Mark the source vertex
    dist[s] = 0;

    // Step 2: relax edges |V| - 1 times
    for (int i = 1; i < V; ++i) {
      for (int j = 0; j < E; ++j) {
        // Get the edge data
        int u = graph.edge[j].s;
        int v = graph.edge[j].d;
        int w = graph.edge[j].w;
        if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
          dist[v] = dist[u] + w;
      }
    }

    // Step 3: detect negative cycle
    // if value changes then we have a negative cycle in the graph
    // and we cannot find the shortest distances
    for (int j = 0; j < E; ++j) {
      int u = graph.edge[j].s;
      int v = graph.edge[j].d;
      int w = graph.edge[j].w;
      if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
        System.out.println("CreateGraph contains negative w cycle");
        return;
      }
    }

    // No negative w cycle found!
    // Print the distance and predecessor array
    printSolution(dist, V);
  }

  // Print the solution
  void printSolution(int dist[], int V) {
    System.out.println("Vertex Distance from Source");
    for (int i = 0; i < V; ++i)
      System.out.println(i + "\t\t" + dist[i]);
  }

  public static void main(String[] args) {
    int V = 6; // Total vertices
    int E = 10; // Total Edges

    CreateGraph graph = new CreateGraph(V, E);

    // edge 0 --> 1
    graph.edge[0].s = 0;
    graph.edge[0].d = 1;
    graph.edge[0].w = 1;

    // edge 0 --> 2
    graph.edge[1].s = 1;
    graph.edge[1].d = 3;
    graph.edge[1].w = 3;

    // edge 1 --> 3
    graph.edge[2].s = 1;
    graph.edge[2].d = 4;
    graph.edge[2].w = -1;

    // edge 2 --> 1
    graph.edge[3].s = 2;
    graph.edge[3].d = 1;
    graph.edge[3].w = 5;

    // edge 3 --> 2
    graph.edge[4].s = 2;
    graph.edge[4].d = 4;
    graph.edge[4].w = 3;
    
    graph.edge[5].s = 2;
    graph.edge[5].d = 5;
    graph.edge[5].w = 8;
    
    graph.edge[6].s = 3;
    graph.edge[6].d = 4;
    graph.edge[6].w = 2;
    
    graph.edge[7].s = 4;
    graph.edge[7].d = 0;
    graph.edge[7].w = 0;
    
    graph.edge[8].s = 4;
    graph.edge[8].d = 1;
    graph.edge[8].w = 8;
    
    graph.edge[9].s = 5;
    graph.edge[9].d = 4;
    graph.edge[9].w = 4;

    graph.BellmanFord(graph, 2); // 0 is the source vertex
  }
}
