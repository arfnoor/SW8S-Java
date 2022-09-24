package org.aquapackrobotics.sw8s.states;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.aquapackrobotics.sw8s.trainingsim.SimWindow;
public class moveUpState extends SimState {
    public moveUpState(ScheduledThreadPoolExecutor pool, SimWindow window) {
       super(pool, window);
       onEnter();
    }
    @Override
    public void onEnter() {
        window.setRobotSpeed(0, 0, 0);
        System.out.println("Beginning Setup Movement (Step Zero)");
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
        if (window.getYPos() >= (window.getfieldHeight() / 2)) 
        {
            //Moves Up until roughly half of the screen
            window.setRobotSpeed(0, -1, 0);
            return false;
        }
        window.setRobotSpeed(0, 0, 0);
        return true;
    }
    @Override
    public void onExit() {
        // Resets to beginning state (no movement) for imbetween States, I believe that's what was meant to be done
            window.setRobotSpeed(0, 0, 0);
            nextState();
        
    }
    @Override
    public State nextState() {
        //Clearly not the best way to do this, but it got the job done...
        moveRightState1 start = new moveRightState1(pool, window);
        return null;
}
}
