package lesson7;

import java.util.*;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final boolean[][] adjMat;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>();
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);
        for (String another : others) {
            result &= addEdge(startLabel, another);
        }
        return result;
    }

    private boolean addEdge(String startLabel, String endLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(endLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMat[startIndex][endIndex] = true;
        adjMat[endIndex][startIndex] = true;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            Vertex vertex = vertexList.get(i);
            if (vertex.getLabel().equals(label)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }

        resetVertexState();
    }

    private void resetVertexState() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex current) {
        int currentIndex = vertexList.indexOf(current);
        for (int i = 0; i < getSize(); i++) {
            if (adjMat[currentIndex][i] && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel());
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.println(vertex.getLabel());
        queue.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }

        resetVertexState();
    }

    public ArrayList<Vertex> getShortestPath(String startLabel, String finishLabel){
        ArrayList<Vertex> shortestPathArray = new ArrayList<>();
        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid start label: " + startLabel);
        }
        if (finishIndex == -1) {
            throw new IllegalArgumentException("Invalid finish label: " + finishLabel);
        }
        shortestPathArray.add(vertexList.get(finishIndex));
        return getShortestPath(vertexList.get(startIndex), shortestPathArray);
    }

    private ArrayList<Vertex> getShortestPath(Vertex startVertex, ArrayList<Vertex> shortestPathArray) {
        Vertex finishVertex = shortestPathArray.get(shortestPathArray.size()-1);
        if (startVertex == finishVertex || finishVertex == null) {
            return shortestPathArray;
        }
        Vertex nextPathVertex = null;
        Queue<Vertex> queue = new LinkedList<>();
        visitVertex(queue, startVertex);
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.peek();
            Vertex nextVertex = getNearUnvisitedVertex(currentVertex);
            if (finishVertex == nextVertex) {
                nextPathVertex = currentVertex;
                break;
            }
            if (nextVertex != null) {
                visitVertex(queue, nextVertex);
            } else {
                queue.remove();
            }
        }
        resetVertexState();
        shortestPathArray.add(nextPathVertex);
        return getShortestPath(startVertex, shortestPathArray);
    }

    public void printShortestPath(String startLabel, String finishLabel){
        ArrayList<Vertex> shortestPath = getShortestPath(startLabel, finishLabel);
        System.out.print("Shortest Path for " + startLabel + " -> " +  finishLabel + " : ");
        if (shortestPath.size() == 1) {
            System.out.println(shortestPath.get(0).toString());
        } else if (shortestPath.get(1) == null){
            System.out.println("vertexes do not have connections");
        } else {
            for (int i = shortestPath.size() - 1; i >= 0 ; i--) {

                if (i == 0) {
                    System.out.println(shortestPath.get(i).toString());
                } else {
                    System.out.print(shortestPath.get(i).toString() + " => ");
                }
            }
        }

    }
}
