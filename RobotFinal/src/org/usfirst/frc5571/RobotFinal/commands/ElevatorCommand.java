// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5571.RobotFinal.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5571.RobotFinal.Robot;
import org.usfirst.frc5571.RobotFinal.subsystems.Elevator;

/**
 *
 */
public class  ElevatorCommand extends Command {
	private Elevator elevController = Robot.elevator;
	boolean position_held;
    public ElevatorCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.elevator);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		elevController.initCanPID();
		//elevController.initElevLimits();
		SmartDashboard.putString("Elevatorlev MODE:", "Initialized");
		position_held = false;
		elevController.showCanTalonStatus();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.B_Button) { // close clamp with current limited protection
			// axis = Robot.oi.xboxController.getY();
			// RobotMap.testCAN_MotorCANTalon1.set(axis);
			// elevController.positionMode();
			// SmartDashboard.putString("MODE:", "Position");
			// elevController.showCanTalonStatus();
			// Close Clamp
			if (!elevController.elevCurrenLimited()) {
				elevController.upElev();
				SmartDashboard.putString("Elevator MODE:", "UP");
			} else {
				elevController.servoHere();
				SmartDashboard.putString("Elevator MODE:", "UP CURRENT LIMIT EXCEEDED");
			}
		}

		else if (Robot.oi.A_Button) { // open clamp with current limited
										// protection
			// open Clamp
			if (!elevController.elevCurrenLimited()) {
				elevController.downElev();
				SmartDashboard.putString("Elevator MODE:", "DOWN");
				;
			} else { // current limit exceeded

				elevController.servoHere();
				SmartDashboard.putString("Elevator MODE:", "DOWN CURRENT LIMIT EXCEEDED");
			}

		}
//FOR TUNING ONLY DISCONNECT LINKAGE BEFORE USING
//		else if (Robot.oi.A_Button) {
//			elevController.positionMoveByCount(1000);
//			SmartDashboard.putString("MODE:", "B - Move+1000");
//
//		}

		//FOR TUNING ONLY DISCONNECT LINKAGE BEFORE USING
		//		else if (Robot.oi.B_Button){ 
//			elevController.positionMoveByCount(-1000);
//			SmartDashboard.putString("MODE:", "B - Move-1000");
//		}

		else {
			SmartDashboard.putString("Elevator MODE:", "HOLD POSITION");
			elevController.servoHere();
		}
		// Display status on every execute call
		elevController.showCanTalonStatus();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//elevController.showCanTalonStatus();
        return false;
        
    }
 
    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}