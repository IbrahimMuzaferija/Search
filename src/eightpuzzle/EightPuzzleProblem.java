package eightpuzzle;

import agent.Action;
import agent.Problem;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EightPuzzleProblem extends Problem<EightPuzzleState> {

    private EightPuzzleState goalState;

    public EightPuzzleProblem(EightPuzzleState initialState) {
        super(initialState, new ArrayList<>());
        actions.add(new ActionUp());
        actions.add(new ActionLeft());
        actions.add(new ActionDown());
        actions.add(new ActionRight());
        this.goalState = new EightPuzzleState( EightPuzzleState.GOAL_MATRIX);

    }

    @Override
    public List<EightPuzzleState> executeActions(EightPuzzleState state) {

        List<EightPuzzleState> successors = new LinkedList<EightPuzzleState>();

        for (Action a: actions)
            if (a.isValid(state)) {
                EightPuzzleState successor = (EightPuzzleState) state.clone();
                a.execute (successor);
                successors.add(successor);
            }
        return successors;
    }

    @Override
    public boolean isGoal(EightPuzzleState state) {
        return state.equals(goalState);
    }

    public EightPuzzleState getGoalState() {
        return goalState;
    }

    @Override
    public double computePathCost(List<Action> path) {
        return path.size();
    }
}
