package graphs;

import java.util.List;

import program.Simulator3;

public class VertexBlockageNode implements BayesNode {
	private BRCNode brc;
	private List<VertexKeyNode> parents;
	private int vertexID;
	private int blockageID;

	public VertexBlockageNode(int vertexID,int blockageID,BRCNode brc,List<VertexKeyNode> parents){
		this.setParents(parents);
		this.setVertexID(vertexID);
		this.setBlockageID(blockageID);
		this.setBrc(brc);
	}

	public BRCNode getBrc() {
		return brc;
	}

	public void setBrc(BRCNode brc) {
		this.brc = brc;
	}

	public List<VertexKeyNode> getParents() {
		return parents;
	}

	public void setParents(List<VertexKeyNode> parents) {
		this.parents = parents;
	}

	public int getVertexID() {
		return vertexID;
	}

	public void setVertexID(int vertexID) {
		this.vertexID = vertexID;
	}

	public int getBlockageID() {
		return blockageID;
	}

	public void setBlockageID(int blockageID) {
		this.blockageID = blockageID;
	}
/*
 * change because the bsc(non-Javadoc)
 * @see graphs.BayesNode#getProbability(java.util.List)
 */
	@Override
	public double getProbability(List<Pair<BayesNode, Boolean>> evidances) {
		evidances.removeIf((Pair<BayesNode, Boolean> evidance) -> {return !evidance.getRight();});
		if(evidances.isEmpty())
			return Simulator3.LEAKAGE;
		double res = 1;
		for(Pair<BayesNode, Boolean> evidance: evidances){
			res*= evidance.getLeft().getProbability(evidances);
		}
		return res;
	}


	
}
