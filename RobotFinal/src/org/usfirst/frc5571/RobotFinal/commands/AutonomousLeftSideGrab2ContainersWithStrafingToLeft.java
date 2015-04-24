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
import edu.wpi.first.wpilibj.command.WaitCommand;

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




public class  AutonomousLeftSideGrab2ContainersWithStrafingToLeft extends CommandGroup {
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

	public AutonomousLeftSideGrab2ContainersWithStrafingToLeft() {
		

		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		
		
	
		
		/************************** Grab Both Containers Left then right place first container on scoring platform  ****************/
		/* This takes 15 seconds to complete!
		 * but blocks the setp for cooperatition
		 * Align front of front wheel with top edge of tote parallel to step in front of left container
		 */
		// Pick up Left Container first then right
//		addSequential(new MoveElevatorToPositionCommand(32000, 10)); /* raise to clear totes in landfill 16000 picks up*/
//		addParallel(new OpenGripperCommand(4));
//		addSequential(new AutoDriveCommand(0,0,1,1.5));  // Good 90 degree turn timing
//		addSequential(new AutoDriveCommand(1,0,0,.25));  //Drive forward
//		addSequential(new MoveElevatorToPositionCommand(16000, 10)); /* lower to  16000 to picks up containers */
//		addSequential(new CloseGripperCommand(4));
//		addSequential(new MoveElevatorToPositionCommand(35000, 10)); /* raise to clear totes in landfill 16000 picks up*/
//		addSequential(new AutoDriveCommand(-3,0,0,0.25));  // drive backwards to clear totes
//		addSequential(new AutoDriveCommand(0,0,-1,1.5));  // turn left to put down
//		addSequential(new MoveElevatorToPositionCommand(10000, 10)); /* lower to set down */
//		addSequential(new OpenGripperCommand(4));
//		addSequential(new MoveElevatorToPositionCommand(32000, 10)); /* raise to clear totes in landfill 16000 picks up*/
//		addSequential(new AutoDriveCommand(-2,0,0,1.2));  // drive backwards to wall
//		addSequential(new AutoDriveCommand(0,0,1,1.5));  // GRotate right to align with RHS container
//	
//		addSequential(new AutoDriveCommand(1,0,0,1));  // Move forward
//		addSequential(new MoveElevatorToPositionCommand(16000, 10)); /* lower to  16000 to picks up containers */
//		addSequential(new CloseGripperCommand(4));
//		addSequential(new MoveElevatorToPositionCommand(35000, 10)); /* raise to clear totes in landfill 16000 picks up*/

		/**********************************************************************
		
			
		/************************** Grab Both Containers Left then right puts down 1st on totes  but dont put container near step****************/
		/* This takes 15 seconds to complete!
		 * Align front of front wheel with top edge of tote parallel to step in front of left container
		 */
		// Pick up Left Container first then right but puts it down out of way of step
		addSequential(new AutoDriveCommand(1,0,0,5));  //Drive forward from driver station to landfill
		//addParallel(new MoveElevatorToPositionCommand(16000, 10)); /* raise to clear totes in landfill 16000 picks up*/
		//addParallel(new OpenGripperCommand(4));
		addParallel(new MoveElevatorToPositionCommand(32000, 10));
		//addSequential(new AutoDriveCommand(0,0,1,1.6));  // Good 90 degree turn timing
		//addSequential(new AutoDriveCommand(1,0,0,0.5));  //Drive forward
		addSequential(new MoveElevatorToPositionCommand(16000, 10)); /* lower to  16000 to picks up containers */
		addSequential(new CloseGripperCommand(4));   // pick up container
		addSequential(new MoveElevatorToPositionCommand(32000, 10)); /* raise to clear totes in landfill 16000 picks up*/
		//addSequential(new AutoDriveCommand(-2,0,0,0.35));  // drive backwards to clear totes
		addSequential(new AutoDriveCommand(-1,0,0,1.5));  // drive backwards to clear totes and scoring platform

		addSequential(new WaitCommand(0.5)); //allow robot to stop
		addSequential(new MoveElevatorToPositionCommand(28000, 10)); /* lower to clear totes in landfill 16000 picks up*/
		
		//addSequential(new MoveElevatorToPositionCommand(5000, 10)); /* lower to set down on floor*/
		//addSequential(new MoveElevatorToPositionCommand(32000, 10)); /* lower to set down on totes */

		addSequential(new OpenGripperCommand(4));			/* set container down on totes */
		addSequential(new MoveElevatorToPositionCommand(35000, 10)); /* raise to clear totes in landfill 16000 picks up*/
		addSequential(new AutoDriveCommand(3,-90.0,0,1.3));  //strafe left
		
//		addSequential(new AutoDriveCommand(0,0,-1,1.6));  // turn left to move backwards
//		addSequential(new AutoDriveCommand(-2,0,0,1.2));  // drive backwards to wall
//		addSequential(new AutoDriveCommand(0,0,1,1.5));  // GRotate right to align with RHS container
	
		addSequential(new AutoDriveCommand(1,0,0,2.0));  // Move forward
		addSequential(new MoveElevatorToPositionCommand(16000, 10)); /* lower to  16000 to picks up containers */
		addSequential(new CloseGripperCommand(4));
		addSequential(new MoveElevatorToPositionCommand(35000, 10)); /* raise to clear totes in landfill 16000 picks up*/
		addSequential(new AutoDriveCommand(1,180,0,3.0));  // Back away
		/************************** Grab Both Containers Left then right puts down 1st on totes  but don
		
		
		//		addSequential(new AutoDriveCommand(0,0,-1,3.5));  // turn left to put down
//		addSequential(new MoveElevatorToPositionCommand(1000, 10)); /* lower to set down */
//		addSequential(new OpenGripperCommand(4));
//		addSequential(new MoveElevatorToPositionCommand(32000, 10)); /* raise to clear totes in landfill 16000 picks up*/

		
//		//addSequential(new RotateLeft90Command(TIME_TO_ROTATE_90_DEGREES));
//		
//		addSequential(new MoveElevatorToPositionCommand(32000, 10)); /* raise to clear totes in landfill 16000 picks up*/
//		addParallel(new AutoDriveCommand(0,0,1,1.7));  // Good 90 degree turn timing
//		addSequential(new OpenGripperCommand(4));
//		//addSequential(new MoveElevatorToPositionCommand(600, 10)); /* raise to clear totes in landfill 16000 picks up*/
//	
//
////		addSequential(new AutoDriveCommand(1, 0, 0, 2));
////		addSequential(new AutoDriveCommand(1,180,1,1.2)); /* back away and rotate */
//
//		//addSequential(new AutoDriveCommand(0,0,1,1.45));  // Good 90 degree turn timing 
////		//addSequential(new CloseGripperCommand(2.5));
//		//addSequential(new MoveElevatorToPositionCommand(6000, 10));
//		
//		//addSequential(new DriveForwardCommand(DRIVE_TO_AUTO));
//		//autoDone = true;
	}
}

	