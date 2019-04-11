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

    List<ComputerNode> queryInfection(int c1, int c2, int x, y) {
        
    }

    HashMap<Integer, List<ComputerNode>> getComputerMapping() {

    }

    List<ComputerNode> getComputerMapping(int c) {

    }

    public static void main(String[] args) {
        CommunicationsMonitor cm = new CommunicationsMonitor();
        cm.addCommunication(1, 2, 5);
    }

}