package ftt.app.infra.controllers.stateMachine;

import ftt.app.infra.enums.AvailableStates;
import javafx.stage.Stage;

import java.io.IOException;

public class StateMachine {
	private static Stage state;
	private static StateFactory stateFactory;
	private static StateMachine stateMachine;
	
	private StateMachine() {
		state = null;
		stateMachine = new StateMachine();
		stateFactory = new StateFactory();
	}
	
	public static StateMachine getInstance() {
		return stateMachine;
	}
	
	public Stage getCurrentState() {
		return state;
	}
	
	public String getUrl(AvailableStates state) {
		return stateFactory.generateParentUrl(state);
	}
	
	public Stage getState(AvailableStates stateBuild) throws IOException {
		state = stateFactory.getStage(stateBuild);
		return getCurrentState();
	}
	
	
}
