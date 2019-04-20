import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class CommunicationsMonitor {

    HashMap<Integer, List<ComputerNode>> computers;
    ArrayList<int[]> triples;

    CommunicationsMonitor() {
        this.computers = new HashMap<Integer, List<ComputerNode>>();
    }

    void addCommunication(int c1, int c2, int timestamp) {
        int[] triple = {c1, c2, timestamp};
        triples.add(triple);
    }

    void createGraph() {
        triples.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				return arg0[2] - arg1[2];
			}
        });
        for(int[] currentTriple: triples) {
        	List<ComputerNode> cn1list = computers.get(currentTriple[0]);
        	List<ComputerNode> cn2list = computers.get(currentTriple[1]);
        	ComputerNode cn1 = null;
        	ComputerNode cn2 = null;
        	if(cn1list != null) {
        		for(ComputerNode c: cn1list) {
        			if(c.getID() == currentTriple[0] && c.getTimestamp() == currentTriple[2]) {
        				cn1 = c;
        				break;
        			}
        		}
        	} else {
        		cn1list = new LinkedList<ComputerNode>();
        		computers.put(currentTriple[0], cn1list);
        	}
        	if(cn1 == null) {
        		cn1 = new ComputerNode(currentTriple[0], currentTriple[2]);
        		cn1list.add(cn1);
        	}
        	if(cn2list != null) {
        		for(ComputerNode c: cn2list) {
        			if(c.getID() == currentTriple[1] && c.getTimestamp() == currentTriple[2]) {
        				cn2 = c;
        				break;
        			}
        		}
        	} else {
        		cn2list = new LinkedList<ComputerNode>();
        		computers.put(currentTriple[1], cn2list);
        	}
        	if(cn2 == null) {
        		cn2 = new ComputerNode(currentTriple[1], currentTriple[2]);
        		cn2list.add(cn2);
        	}
        }
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
		int compMap[][] = {{1, 4, 12}, {1, 2, 4}, {2, 4, 8}, {3, 4, 8}};
		CommunicationsMonitor cMon = new CommunicationsMonitor();
		for(int i = 0; i<compMap.length; i++) {
			cMon.addCommunication(compMap[i][0], compMap[i][1], compMap[i][2]);
        }
		cMon.createGraph();
		HashMap<Integer, List<ComputerNode>> compMapping = cMon.getComputerMapping();
		
		//Check Size
        System.out.println("Number nodes: " + compMapping.size());
		
		//Check for node 4
		// String msg = checkCNList(compMapping.get(4), new int[][]{{4, 8},{4, 12}});
		// if(!msg.equals("")) fail("Incorrect list in HashMap for key 4, "+msg);
    }

}