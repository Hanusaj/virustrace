import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

class CommunicationsMonitor {

    HashMap<Integer, List<ComputerNode>> computers;

    CommunicationsMonitor() {
        this.computers = new HashMap<Integer, List<ComputerNode>>();
    }

    void addCommunication(int c1, int c2, int timestamp) {
        ComputerNode cn1 = new ComputerNode(c1, timestamp);
        ComputerNode cn2 = new ComputerNode(c2, timestamp);
        cn1.addEdge(cn2);
        cn2.addEdge(cn1);
        return;
    }

    void createGraph() {

    }

    List<ComputerNode> queryInfection(int c1, int c2, int x, int y) {
        return null;
    }

    HashMap<Integer, List<ComputerNode>> getComputerMapping() {
        return null;
    }

    List<ComputerNode> getComputerMapping(int c) {
        return null;
    }

    void addNode(ComputerNode cn) {
        if(this.computers.get(cn.getID()) == null) {
            List<ComputerNode> l = new LinkedList<ComputerNode>();
            l.add(cn);
            this.computers.put(cn.getID(), l);
        } else {
            this.computers.get(cn.getID()).add(cn);
        }
    }

    public static void main(String[] args) {
        CommunicationsMonitor cm = new CommunicationsMonitor();
        cm.addCommunication(1, 2, 5);
    }

}