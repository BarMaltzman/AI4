package graphs;

import java.util.List;

public interface BayesNode {
	double getProbability(List<Pair<BayesNode,Boolean>> evidance);
}
