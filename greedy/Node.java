package greedy;

public class Node implements Comparable<Node>{

    private int index;
    private int distance;

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        if (this.distance < o.distance) {
            return -1;
        }
        return 1;
    }
}
