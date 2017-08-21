package graphs;

import java.util.List;

public class BRCNode implements BayesNode{
	
	private double probability;

	public BRCNode(double probability){
		this.setProbability(probability);
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	@Override
	public double getProbability(List<Pair<BayesNode,Boolean>> evidance) {
		return probability;
	}

}
