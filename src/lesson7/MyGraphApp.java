package lesson7;

import java.util.ArrayList;

public class MyGraphApp {
    public static void main(String[] args) {
        GraphImpl graph = new GraphImpl(11);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        graph.addVertex("J");
        graph.addVertex("K");

        graph.addEdge("A", "B", "C", "E", "F");
        graph.addEdge("B", "C", "H");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E", "J");
        graph.addEdge("E", "F", "J");
        graph.addEdge("F", "G");
        graph.addEdge("G", "H", "I");
        graph.addEdge("H", "I");
        graph.addEdge("I", "J");

        graph.printShortestPath("A", "I");
        graph.printShortestPath("H", "J");
        graph.printShortestPath("F", "K");
        graph.printShortestPath("F", "F");
    }
}
