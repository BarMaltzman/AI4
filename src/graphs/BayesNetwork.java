package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BayesNetwork {
	List<BayesNode> topologicalNodes;
	private BRCNode brc;
	private Map<Pair<Integer,Integer>,VertexKeyNode> vertexKeys;
	private Map<Pair<Integer,Integer>,VertexBlockageNode> vertexBlocks;
	
	public BayesNetwork(double brc, List<Vertex> vertexList, int blockageNumber)
	{
		topologicalNodes = new ArrayList<BayesNode>();
		this.brc = new BRCNode(brc);
		topologicalNodes.add(this.brc);
		for(Vertex v: vertexList){
			for(int i=0 ; i < blockageNumber ; i++){
				VertexKeyNode node = new VertexKeyNode(v.getId(), i, v.getKeyProbability(i));
				vertexKeys.put(new Pair<Integer,Integer>(node.getVertexId(),node.getKeyId()),node);
				topologicalNodes.add(node);
			}
		}
		for(Vertex v: vertexList){
			for(int i=0 ; i < blockageNumber ; i++){
				List<VertexKeyNode> parents = new ArrayList<VertexKeyNode>();
				for(Vertex neighbor : v.getNeighbors()){
					parents.add(vertexKeys.get(new Pair<Integer,Integer>(neighbor.getId(),i)));
				}
				VertexBlockageNode node = new VertexBlockageNode(v.getId(),i,this.brc,parents);
				vertexBlocks.put(new Pair<Integer,Integer>(v.getId(),i), node);
			}
		}
		
		
	}
}
