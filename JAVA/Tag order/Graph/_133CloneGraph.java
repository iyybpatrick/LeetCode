import java.util.*;
public class _133CloneGraph {

	static class UndirectedGraphNode {
		      int label;
		      List<UndirectedGraphNode> neighbors;
		      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
		  };
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		        if (node == null) return null;
		        ArrayList<UndirectedGraphNode> nodes = new ArrayList<>();
		        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
		        map.put(node, copyNode);
		        nodes.add(node);
		        int start = 0;
		        while (start < nodes.size()){
		        	UndirectedGraphNode root =nodes.get(start++);
		        	
		        	for (UndirectedGraphNode neighbor : root.neighbors){
		        		if (!map.containsKey(neighbor)){
		        			UndirectedGraphNode newCopy = new UndirectedGraphNode(neighbor.label);
		        			map.put(neighbor, newCopy);
		        			nodes.add(neighbor);
		        		}
		        	}//for
		        }//while
		        
		        for (UndirectedGraphNode OldNode : nodes){
		        	UndirectedGraphNode OldCopy = map.get(OldNode);
		        	for (UndirectedGraphNode neighbor : OldNode.neighbors){
		        		OldCopy.neighbors.add(map.get(neighbor));
		        	}//for
		        }//for
		        return map.get(node);  
		    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//question:
	//Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
	//
	//
	//OJ's undirected graph serialization:
	//Nodes are labeled uniquely.
	//
	//We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
	//As an example, consider the serialized graph {0,1,2#1,2#2,2}.
	//
	//The graph has a total of three nodes, and therefore contains three parts as separated by #.
	//
	//First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
	//Second node is labeled as 1. Connect node 1 to node 2.
	//Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
	//Visually, the graph looks like the following:
	//
	//       1
	//      / \
	//     /   \
	//    0 --- 2
	//         / \
	//         \_/