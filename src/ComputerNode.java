import java.util.List;
import java.util.LinkedList;

class ComputerNode {

    int ID;
    int timestamp;

    List<ComputerNode> outNodes;

    ComputerNode(int id, int time) {
        this.ID = id;
        this.timestamp = time;
        this.outNodes = new LinkedList<ComputerNode>();
    }

    int getID() {
        return this.ID;
    }

    int getTimestamp() {
        return this.timestamp;
    }

    void addEdge(ComputerNode cn) {
        this.outNodes.add(cn);
    }

    List<ComputerNode> getOutNeighbors() {
        return null;
    }
}