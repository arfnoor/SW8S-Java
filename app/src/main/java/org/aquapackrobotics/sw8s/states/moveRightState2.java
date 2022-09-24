package org.aquapackrobotics.sw8s.states;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.aquapackrobotics.sw8s.trainingsim.SimWindow;
public class moveRightState2 extends SimState{
    public moveRightState2(ScheduledThreadPoolExecutor pool, SimWindow window) {
        super(pool, window);
        onEnter();
     }
     @Override
     public void onEnter() {
        System.out.println("Beginning Second Right Movement (Final Step)");
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
         if (window.getXPos() <= (window.getfieldHeight()-50)) 
         {
            //Moves Right until roughly the right of the screen
             window.setRobotSpeed(1, 0, 0);
             return false;
         }
         window.setRobotSpeed(0, 0, 0);
         return true;
     }
     @Override
     public void onExit() {
         // Resets to beginning state (no movement) for imbetween States, I believe that's what was meant to be done
         if (window.getXPos() > (window.getfieldHeight() / 2))
         {
             window.setRobotSpeed(0, 0, 0);
             nextState();
         }
         
     }
     @Override
     public State nextState() {
        int x = 1;
        while (x==1)
        {
            //For some reason the robot would do the G twice, used this as a temporary (maybe) fix to prevent this
            window.setRobotSpeed(0, 0, 0);
        }
        return null;
 }
 }
 

