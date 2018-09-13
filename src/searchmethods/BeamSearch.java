package searchmethods;

import agent.State;
import java.util.List;
import utils.NodePriorityQueue;

public class BeamSearch extends AStarSearch {

    private int beamSize;

    public BeamSearch() {
        this(100);
    }

    public BeamSearch(int beamSize) {
        this.beamSize = beamSize;
    }

    @Override
    public void addSuccessorsToFrontier(List<State> successors, Node parent) {
        for(State s:successors){
            double g = parent.getG() + s.getAction().getCost();

            if(!frontier.containsState(s)){
                double f = g + heuristic.compute(s);

                Node node = new Node(s,parent,g,f);
                if(!node.isCycle())
                    frontier.add(node);

            } else if (frontier.getNode(s).getG() > g){
                frontier.removeNode(s);
                frontier.add(new Node(s,parent,g,g+heuristic.compute(s)));
            }


        }

        while (frontier.size() > beamSize){
            frontier.remove();
        }
    }

    public void setBeamSize(int beamSize) {
        this.beamSize = beamSize;
    }

    public int getBeamSize() {
        return beamSize;
    }

    @Override
    public String toString() {
        return "Beam search";
    }
}
