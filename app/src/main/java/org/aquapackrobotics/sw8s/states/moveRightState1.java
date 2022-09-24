package org.aquapackrobotics.sw8s.states;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.aquapackrobotics.sw8s.trainingsim.SimWindow;
public class moveRightState1 extends SimState{
    public moveRightState1(ScheduledThreadPoolExecutor pool, SimWindow window) {
        super(pool, window);
        onEnter();
     }
     @Override
     public void onEnter() {
         window.setRobotSpeed(0, 0, 0);
         System.out.println("Beginning First Right Movement (Step One)");
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
        //Clearly not the best way to do this, but it got the job done...
        moveDownState start = new moveDownState(pool, window);
        return null;
 }
 }
 

