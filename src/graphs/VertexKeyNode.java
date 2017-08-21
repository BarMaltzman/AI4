package graphs;

import java.util.List;

public class VertexKeyNode implements BayesNode {
	
	private int vertexId;
	private int keyId;
	private double probability;

	public VertexKeyNode(int vertexId,int keyId,double probability){
		this.setVertexId(vertexId);
		this.setKeyId(keyId);
		this.setProbability(probability);
	
	}

	public int getVertexId() {
		return vertexId;
	}

	public void setVertexId(int vertexId) {
		this.vertexId = vertexId;
	}

	public int getKeyId() {
		return keyId;
	}

	public void setKeyId(int keyId) {
		this.keyId = keyId;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	@Override
	public double getProbability(List<Pair<BayesNode, Boolean>> evidance) {
		return probability;
	}

	
}
