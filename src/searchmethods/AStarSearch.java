package searchmethods;

import agent.State;
import java.util.List;

public class AStarSearch extends InformedSearch {

    //f = g + h
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
    }

    @Override
    public String toString() {
        return "A* search";
    }
}
