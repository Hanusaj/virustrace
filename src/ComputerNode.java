
import java.util.List;
import java.util.LinkedList;

enum Color {
	WHITE, GRAY, BLACK;
}

/**
 * 
 * @author Jordan Cowen, Brett Peterson, AJ Hanus
 *
 */
class ComputerNode {

	int ID;
	int timestamp;

	Color color;
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public ComputerNode getPred() {
		return pred;
	}

	public void setPred(ComputerNode pred) {
		this.pred = pred;
	}

	ComputerNode pred;

	List<ComputerNode> outNodes;

	public ComputerNode(int id, int time) {
		this.ID = id;
		this.timestamp = time;
		this.outNodes = new LinkedList<ComputerNode>();
	}

	public int getID() {
		return this.ID;
	}

	public int getTimestamp() {
		return this.timestamp;
	}

	public void addEdge(ComputerNode cn) {
		this.outNodes.add(cn);
	}

	public List<ComputerNode> getOutNeighbors() {
		return this.outNodes;
	}
	
	public String toString(){
		return "(" + String.valueOf(ID) + ", " + String.valueOf(timestamp) + ")";
	}
}