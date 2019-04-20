import java.util.List;
import java.util.LinkedList;

class ComputerNode {

	int ID;
	int timestamp;

	enum Color {
		WHITE, GRAY, BLACK;
	}

	Color color;
	int dist;
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getDist() {
		return dist;
	}

	public void setDist(int dist) {
		this.dist = dist;
	}

	public ComputerNode getPred() {
		return pred;
	}

	public void setPred(ComputerNode pred) {
		this.pred = pred;
	}

	ComputerNode pred;

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