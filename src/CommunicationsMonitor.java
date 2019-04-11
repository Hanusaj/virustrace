import java.util.HashMap;
import java.util.List;

class CommunicationsMonitor {

    CommunicationsMonitor() {

    }

    void addCommunication(int c1, int c2, int timestamp) {
        System.out.println("Need to implement adding communications.");
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

    public static void main(String[] args) {
        CommunicationsMonitor cm = new CommunicationsMonitor();
        cm.addCommunication(1, 2, 5);
    }

}