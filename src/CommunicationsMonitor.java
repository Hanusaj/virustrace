
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Jordan Cowen, Brett Peterson, AJ Hanus
 *
 */
class CommunicationsMonitor {

	HashMap<Integer, List<ComputerNode>> computers;
	ArrayList<int[]> triples;
	boolean graphCreated;

	public CommunicationsMonitor() {
		this.computers = new HashMap<Integer, List<ComputerNode>>();
		this.triples = new ArrayList<>();
		this.graphCreated = false;
	}

	void addCommunication(int c1, int c2, int timestamp) {
		if (!graphCreated) {
			int[] triple = { c1, c2, timestamp };
			triples.add(triple);
		}
	}

	public ArrayList<int[]> getCommunicationList() {
		return triples;
	}

	public void createGraph() {
		graphCreated = true;
		triples.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				return arg0[2] - arg1[2];
			}
		});
		for (int[] currentTriple : triples) {
			List<ComputerNode> cn1list = computers.get(currentTriple[0]);
			List<ComputerNode> cn2list = computers.get(currentTriple[1]);
			ComputerNode cn1 = null;
			ComputerNode cn2 = null;
			if (cn1list != null) {
				for (ComputerNode c : cn1list) {
					if (c.getTimestamp() == currentTriple[2]) {
						cn1 = c;
						break;
					}
				}
			} else {
				cn1list = new LinkedList<ComputerNode>();
				computers.put(currentTriple[0], cn1list);
			}
			if (cn1 == null) {
				cn1 = new ComputerNode(currentTriple[0], currentTriple[2]);
				if (cn1list.size() > 0) {
					((LinkedList<ComputerNode>) cn1list).getLast().addEdge(cn1);
				}
				cn1list.add(cn1);
			}
			if (cn2list != null) {
				for (ComputerNode c : cn2list) {
					if (c.getTimestamp() == currentTriple[2]) {
						cn2 = c;
						break;
					}
				}
			} else {
				cn2list = new LinkedList<ComputerNode>();
				computers.put(currentTriple[1], cn2list);
			}
			if (cn2 == null) {
				cn2 = new ComputerNode(currentTriple[1], currentTriple[2]);
				if (cn2list.size() > 0) {
					((LinkedList<ComputerNode>) cn2list).getLast().addEdge(cn2);
				}
				cn2list.add(cn2);
			}
			cn1.addEdge(cn2);
			cn2.addEdge(cn1);
		}
	}

	public List<ComputerNode> queryInfection(int c1, int c2, int x, int y) {
		ComputerNode source = null;
		ComputerNode target = null;
		for (ComputerNode c1Node : computers.get(c1)) {
			if (c1Node.timestamp >= x) {
				source = c1Node;
				break;
			}
		}
		if (source != null) {
			target = BFSQuery(source, c2, y);
			if (target != null) {
				LinkedList<ComputerNode> ret = new LinkedList<>();
				while (target != null) {
					ret.addFirst(target);
					target = target.getPred();
				}
				return ret;
			}
		}
		return null;
	}

	public HashMap<Integer, List<ComputerNode>> getComputerMapping() {
		return computers;
	}

	public List<ComputerNode> getComputerMapping(int c) {
		return computers.get(c);
	}

	public ComputerNode BFSQuery(ComputerNode source, int targetComp, int deadline) {
		LinkedList<ComputerNode> Q = new LinkedList<ComputerNode>();

		for (int c : computers.keySet()) {
			for (ComputerNode cn : computers.get(c)) {
				if (cn != source) {
					if (cn.getTimestamp() > deadline)
						cn.setColor(Color.BLACK);
					else
						cn.setColor(Color.WHITE);
					cn.setPred(null);
				}
			}
		}
		source.setColor(Color.GRAY);
		source.setPred(null);
		Q.addLast(source);
		ComputerNode u;
		while (Q.size() > 0) {
			u = Q.peek();
			for (ComputerNode v : u.getOutNeighbors()) {
				if (v.getColor() == Color.WHITE) {
					v.setColor(Color.GRAY);
					v.setPred(u);
					Q.addLast(v);
					if (v.getID() == targetComp)
						return v;
				}
			}
			Q.pop();
			u.setColor(Color.BLACK);
		}

		return null;
	}

	public void addNode(ComputerNode cn) {
		if (this.computers.get(cn.getID()) == null) {
			List<ComputerNode> l = new LinkedList<ComputerNode>();
			l.add(cn);
			this.computers.put(cn.getID(), l);
		} else {
			this.computers.get(cn.getID()).add(cn);
		}
	}

}