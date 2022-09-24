package org.aquapackrobotics.sw8s.missions;

import java.util.concurrent.ScheduledThreadPoolExecutor;

import org.aquapackrobotics.sw8s.states.State;
import org.aquapackrobotics.sw8s.states.moveUpState;
import org.aquapackrobotics.sw8s.trainingsim.SimWindow;


/**
 * Competition mission, fully autonomous.
 */

public class TrainingMission extends Mission {
     SimWindow sim;

    public TrainingMission(ScheduledThreadPoolExecutor pool) {
        super(pool);
        sim = new SimWindow();
        initialState();
        
    }
    
    // TODO: implement
    // Gets robot to center of the field, then rotated to the direction it needs to be
    int counter = 0;
    @Override
    protected State initialState() {
        moveUpState start = new moveUpState(pool, sim);
        return null;
    }

    // TODO: implement
    @Override
    protected void executeState(State state) {
    }

    // TODO: implement
    @Override
    protected State nextState(State state) {
        return null;
    }
}
