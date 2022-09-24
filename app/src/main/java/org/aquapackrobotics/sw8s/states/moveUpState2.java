package org.aquapackrobotics.sw8s.states;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.aquapackrobotics.sw8s.trainingsim.SimWindow;
public class moveUpState2 extends SimState {
    public moveUpState2(ScheduledThreadPoolExecutor pool, SimWindow window) {
       super(pool, window);
       onEnter();
    }
    @Override
    public void onEnter() {
        System.out.println("Beginning Second Up Movement (Step 4)");
        window.setRobotSpeed(0, 0, 0);
        
        while (onPeriodic() == false)
        {
            //Runs repeatedly until the if in onPeriodic() returns false
            onPeriodic();
        }
        onExit();
    }
    @Override
    public boolean onPeriodic() {
        // TODO Auto-generated method stub
        if (window.getYPos() > 50) 
        {
            //Moves Up until roughly the top of the screen
            //System.out.println(window.getYPos());                 /**Used for debugging */
            window.setRobotSpeed(0, -1, 0);
            return false;
        }
        window.setRobotSpeed(0, 0, 0);
        return true;
    }
    @Override
    public void onExit() {
        //Resets to beginning state (no movement) for imbetween States, I believe that's what was meant to be done
            window.setRobotSpeed(0, 0, 0);
            nextState();
        
    }
    @Override
    public State nextState() {
        //Clearly not the best way to do this, but it got the job done...
        moveRightState2 start = new moveRightState2(pool, window);
        return null;
}
}
