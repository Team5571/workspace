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
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc5571.RobotFinal.Robot;
import org.usfirst.frc5571.RobotFinal.RobotMap;


/**
 * Bobby Gintz
 * 
 * This is a simple autonomous command group that sequences between a number of planned moves from a given position
 * After determining reasonable values for 90 degree turns and distance traveled in a straight line they can be
 * coded here.  
 * 
 * Note:  there is no compensation for drift so straight line distances may not be straight
 * 
 * Also:  Use caution when testing this command.  Be prepared to hit the SPACE bar on the driver station
 * which will cause an E-STOP
 */




public class  AutonomousCommand extends CommandGroup {
	// Flag to end the command
	public Boolean autoDone = false;
	//Boolean autoDriveCommandInProgress = false;

	// Scaling factors to adjust drive sensitivity during autonomous to simulate Joystick deflections. 
	static double AUTO_FAST_DRIVE_MAGNITUDE_SCALE = 0.6;
	static double AUTO_FAST_DRIVE_TWIST_SCALE = 0.5;
	static double AUTO_FINE_DRIVE_MAGNITUDE_SCALE = 0.4;
	static double AUTO_FINE_DRIVE_TWIST_SCALE = 0.3;


	static double DRIVE_TO_AUTO	= 10.0;	/* 1.2 seconds to go from start posision to auto zone */
	static double TIME_TO_ROTATE_90_DEGREES = 0.67;  /*  0.67 seconds estimated to rotate left */

	public AutonomousCommand() {
		
//		Unhandled exception: java.lang.NullPointerException at [org.usfirst.frc5571.RobotFinal.commands.RotateLeft90Command.isFinished(RotateLeft90Command.java:44),
//		                                                        edu.wpi.first.wpilibj.command.Command.run(Command.java:218), edu.wpi.first.wpilibj.command.CommandGroup._execute(CommandGroup.java:221), 
//		                                                        edu.wpi.first.wpilibj.command.Command.run(Command.java:216), edu.wpi.first.wpilibj.command.Scheduler.run(Scheduler.java:215), 
//		                                                        org.usfirst.frc5571.RobotFinal.Robot.autonomousPeriodic(Robot.java:92),
//		                                                        edu.wpi.first.wpilibj.IterativeRobot.startCompetition(IterativeRobot.java:135),
//		                                                        edu.wpi.first.wpilibj.RobotBase.main(RobotBase.java:234)]
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		
		/* Commands below use the mecanumDriveAutoFine() method of the drive train
		 * this mthod takes three doubles:  magnitude, direction, and rotation.
		 * 
		 * The commands run for as long as the duration specified in the call to the command
		 */
		
		//addSequential(new RotateLeft90Command(TIME_TO_ROTATE_90_DEGREES));
		
		addSequential(new MoveElevatorToPositionCommand(24000, 10)); /* raise to clear totes in landfill 16000 picks up*/
//		addSequential(new AutoDriveCommand(1,180,1,1.2)); /* back away and rotate */
		addSequential(new OpenGripperCommand(1));
		addSequential(new MoveElevatorToPositionCommand(600, 10)); /* raise to clear totes in landfill 16000 picks up*/

//		addSequential(new AutoDriveCommand(1, 0, 0, 2));
//		
		//addSequential(new AutoDriveCommand(0,0,1,1.45));  // Good 90 degree turn timing 
//		//addSequential(new CloseGripperCommand(2.5));
		//addSequential(new MoveElevatorToPositionCommand(6000, 10));
		
		//addSequential(new DriveForwardCommand(DRIVE_TO_AUTO));
		//autoDone = true;
	}
}

	