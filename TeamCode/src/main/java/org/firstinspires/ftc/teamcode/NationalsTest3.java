package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import java.util.Set;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * This OpMode executes Teleop for a four drive-wheeled robot
 */
@TeleOp (name="NationalsTest3", group="Linear Opmode")

public class NationalsTest3 extends LinearOpMode {
    // Declare OpMode members
        // Runtime timer - default mesurement in seconds
    private ElapsedTime runtime;
        // Wheel motor driver hardware variables
    private DcMotor leftDrive, rightDrive, rleftDrive, rrightDrive;
    //private Servo pivotservo;
    private CRServo servo0, servo1, servo2, servo3;
    private CRServo lservo1, lservo2;
    private Servo pservo1, pservo2, cservo1, cservo2;
    private CRServo pservo3, pservo4;
    private boolean kachow;
        // constructor
    public NationalsTest3 () {
            // Note - can't initialise DcMotor variables here - must be done inside runOpMode()
            // method below
            // Instantiate a runtime timer
        runtime = new ElapsedTime();
    } // end constructor
        // Initialise hardware - Note that this can't be done in the constructor as
        // JBot Java requires that it be done in the runOpMode() method
    
    // Methods for robot movement control
        // Move robot forwards or backwards
        
    private void moveForwardBackward (float forwardBackward) {
        telemetry.addData("Function: ", "moveForwardBackward");
        do{
            forwardBackward = gamepad1.left_stick_y;
            kachow = false;
            if (gamepad1.left_bumper || gamepad1.right_bumper || gamepad1.right_bumper && gamepad1.left_bumper)
                kachow = true;
            if (kachow)
                forwardBackward /= 2.75;
            leftDrive.setPower(forwardBackward);
            rightDrive.setPower(-forwardBackward);
            rleftDrive.setPower(forwardBackward);
            rrightDrive.setPower(-forwardBackward);
        } while (gamepad1.left_stick_y != 0);
    }
        // Move robot to left or right
    private void moveLeftRight (float leftRight) {
        telemetry.addData("Function: ", "moveLeftRight");
        do{
            leftRight = gamepad1.left_stick_x;
            kachow = false;
             if (gamepad1.left_bumper || gamepad1.right_bumper || gamepad1.right_bumper && gamepad1.left_bumper)
                kachow = true;
            if (kachow)
                leftRight /= 2.75;
            leftDrive.setPower(-leftRight);
            rightDrive.setPower(leftRight);
            rleftDrive.setPower(leftRight);
            rrightDrive.setPower(-leftRight);
        } while (gamepad1.left_stick_x != 0);
            }
    
    
        // Rotate robot to left or right (on the spot)
    private void rotateLeftRight (float donuts) {
        telemetry.addData("Function: ", "rotateLeftRight");
        do{
            donuts  =  -gamepad1.right_stick_x;
            kachow = false;
             if (gamepad1.left_bumper || gamepad1.right_bumper || gamepad1.right_bumper && gamepad1.left_bumper)
                kachow = true;
            if (kachow)
                donuts /= 2.75;
            leftDrive.setPower(donuts);
            rightDrive.setPower(donuts);
            rleftDrive.setPower(donuts);
            rrightDrive.setPower(donuts);
        } while (gamepad1.right_stick_x != 0);
        
    }
        //Motors powered off
    private void motorStop () {
        telemetry.addData("Function: ", "Stop");
        do{
            leftDrive.setPower(0);
            rightDrive.setPower(0);
            rleftDrive.setPower(0);
            rrightDrive.setPower(0);
        } while (gamepad1.left_stick_button);
    }
        //Pulls foundation from corner     
    private void autoPull () {
        telemetry.addData("Function: ", "Auto Pull");
        do{
            pservo1.setPosition(0.0);
            pservo2.setPosition(1.0);
            leftDrive.setPower(-0.25);
            rightDrive.setPower(0.25);
            rleftDrive.setPower(0.25);
            rrightDrive.setPower(-0.25);
        } while (gamepad2.dpad_up);
    }
        //Assists in stacking blocks
    private void autoStack () {
        telemetry.addData("Function: ", "Auto Stack");
        do{
            servo3.setPower(-0.5);
            servo0.setPower(0.5);
            servo1.setPower(0.5);
            servo2.setPower(-0.5);
            leftDrive.setPower(0.2);
            rightDrive.setPower(-0.2);
            rleftDrive.setPower(0.2);
            rrightDrive.setPower(-0.2);
        } while (gamepad2.dpad_down);
    }
        //Closes crab claw attachment on intake
    private void snippySnapClose () { //Need to recenter servo for crab claw
        telemetry.addData("Function: ", "SnippySnap Close");
        do{
            cservo1.setPosition(1);
            
            }while (gamepad2.dpad_left);
    }
        //Opens crab claw attachment on intake
    private void snippySnapOpen () {
        telemetry.addData("Function: ", "SnippySnap Open");
        do{
            cservo1.setPosition(0.5);
            
            }while (gamepad2.dpad_right);
    }
    
    
    //Methods for wheel intake system 
        //Sucks in stones
    private void intakeIn () {
        telemetry.addData("Function: ", "intakeIn");
        do{
            servo3.setPower(0.5); // continuous servo
            servo0.setPower(-0.5);
            servo1.setPower(-0.5);
            servo2.setPower(0.5);
        }while (gamepad2.right_stick_y < 0);
    }
        //Pushes out stones
     private void intakeOut () {
        telemetry.addData("Function: ", "intakeOut");
        do{
            servo3.setPower(-0.5);
            servo0.setPower(0.5);
            servo1.setPower(0.5);
            servo2.setPower(-0.5);
        }while (gamepad2.right_stick_y > 0);
    }
        //Stops intake servos
     private void intakeStop (){
        telemetry.addData("Function: ", "intakeStop");
        servo0.setPower(0);
        servo1.setPower(-0.05);
        servo2.setPower(-0.05);
        servo3.setPower(-0.05);
    }

     //Methods for forklift
    private void lMoveU1 (){
        telemetry.addData("Function: ", "lMoveU1");
        do{
            lservo1.setPower(1);
        }while (gamepad2.left_bumper);
    }
    private void lMoveD1 (){
        telemetry.addData("Function: ", "lMoveD1");
        do{
            lservo1.setPower(-1);
        }while (gamepad2.left_trigger != 0);
    }
    private void lMoveU2 (){
        telemetry.addData("Function: ", "lMoveU2");
        do{
            lservo2.setPower(1);
        }while (gamepad2.right_bumper);
    }
    private void lMoveD2 (){
        telemetry.addData("Function: ", "lMoveD2");
        do{
            lservo2.setPower(-1);
        }while (gamepad2.right_trigger != 0);
    }
    private void lStop (){
        telemetry.addData("Function: ", "lStop1");
        telemetry.addData("Function: ", "lStop2");
        lservo1.setPower(-0.1);
        lservo2.setPower(-0.1);
    }
    //3D printed servo pivot
        //Lifts Grabbing mechansism up
    private void pivotUp(){
        telemetry.addData("Function: ", "pivotUp");
        pservo1.setPosition(1.0);
        pservo2.setPosition(0.0);
    }
        //Lowers grabbing mechanism down
    private void pivotDown(){
        telemetry.addData("Function: ", "pivotDown");
        pservo1.setPosition(0.0);
        pservo2.setPosition(1.0);
    }
    //Arm pivot
        //Lifts the rack and pinion lift mechanism up
    private void rackPivotUp(){
        telemetry.addData("Function: ", "rackPivotUp");
        pservo3.setPower(1);
        pservo4.setPower(-1);
    }
        //Lowers the rack and pinion lift mechanism down
    private void rackPivotDown(){
        telemetry.addData("Function: ", "rackPivotDown");
        pservo3.setPower(-1);
        pservo4.setPower(1);
    }
        //Stops the pivoting of the rack and pinion lift mechanism
    private void rackPivotStop(){
        telemetry.addData("Function: ", "rackPivotStop");
        pservo3.setPower(0);
        pservo4.setPower(0);
    }
    /*private void rackPivotUp(){
        telemetry.addData("Function: ", "rackPivotUp");
        while(pservo3.getPosition() != 0.5 && pservo4.getPosition() != 0.5){
            double p3 = pservo3.getPosition();
            double p4 = pservo4.getPosition();
            double p3n = p3 + 0.1;
            double p4n = p4 - 0.1;
            pservo3.setPosition(p3n);
            pservo4.setPosition(p4n);
        }
    } 
    private void rackPivotDown(){
        telemetry.addData("Function: ", "rackPivotDown");
        while(pservo3.getPosition() != 0 && pservo4.getPosition() != 1){
            double p3 = pservo3.getPosition();
            double p4 = pservo4.getPosition();
            double p3n = p3 - 0.1;
            double p4n = p4 + 0.1;
            pservo3.setPosition(p3n);
            pservo4.setPosition(p4n);
        }
    }*/
    
    @Override
    public void runOpMode() {
        telemetry.addData("Status: ", "Initialized");
        telemetry.update();
        
            // Initialize the hardware variables - ***can only be done inside runOpMode()***.
            // Note that the strings used here as parameters to 'get' must correspond to
            // the names assigned during the robot configuration step
            // (using the FTC Robot Controller app on the phone).
           
    
            leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
            rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
            rleftDrive = hardwareMap.get(DcMotor.class, "rleft_drive");
            rrightDrive = hardwareMap.get(DcMotor.class, "rright_drive");
            servo0 = hardwareMap.get(CRServo.class, "servo0");
            servo1 = hardwareMap.get(CRServo.class, "servo1");
            servo2 = hardwareMap.get(CRServo.class, "servo2");
            servo3 = hardwareMap.get(CRServo.class, "servo3");
            lservo1 = hardwareMap.get(CRServo.class, "lservo1");
            lservo2 = hardwareMap.get(CRServo.class, "lservo2");
            pservo1 = hardwareMap.get(Servo.class, "pservo1");
            pservo2 = hardwareMap.get(Servo.class, "pservo2");
            pservo3 = hardwareMap.get(CRServo.class, "pservo3");
            pservo4 = hardwareMap.get(CRServo.class, "pservo4");
            cservo1 = hardwareMap.get(Servo.class, "cservo1");
            cservo2 = hardwareMap.get(Servo.class,"cservo2");
            // set a deadzone for the gamepad1 joystick
       /** gamepad1.setJoystickDeadzone (0.25f);
        gamepad2.setJoystickDeadzone (0.25f); */
        
            // Wait for the game to start (driver presses PLAY)          
        waitForStart();
            // Start timer - saves running time in seconds
        runtime.reset();
   
            // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
                // Drive controls
            if (gamepad1.left_stick_y != 0) {
                moveForwardBackward (gamepad1.left_stick_y);
            } else if (gamepad1.left_stick_x != 0) {
                moveLeftRight (gamepad1.left_stick_x);
            } else if (gamepad1.right_stick_x != 0) {
                rotateLeftRight (gamepad1.right_stick_x);
            } else {
                motorStop ();
            }
                // Attachment controls
                // intake system
            if (gamepad2.right_stick_y < 0) {
                intakeIn();
            } else if (gamepad2.right_stick_y > 0) {
                intakeOut();
            } else if (gamepad2.right_stick_button) {
                intakeStop();
            } 
                //rack and pinion level 1
            if (gamepad2.left_bumper){
                lMoveU1();
            } else if (gamepad2.left_trigger != 0){
                lMoveD1();
            } else {
                lStop();
            }
                //Rack and Pinion level 2
            if (gamepad2.right_bumper){
                lMoveU2();
            } else if (gamepad2.right_trigger != 0){
                lMoveD2();
            } else {
                lStop();
            }
                //pivots
                //3D printed attachment pivot
            if (gamepad2.a){
                pivotUp();
            } else if (gamepad2.b){
                pivotDown();
            }
                //arm pivot
            if (gamepad2.x){
                rackPivotDown();
            } else if (gamepad2.y){
                rackPivotUp();
            }
            else {
                rackPivotStop();
            }
                //Semi-Auto Actions
            if (gamepad2.dpad_up){
                autoPull(); //Foundation Pull
            } else if (gamepad2.dpad_down){
                autoStack(); //Brick Stacking
            }
                //Lobster Claw
            if (gamepad2.dpad_left){
                snippySnapClose();
            } else if (gamepad2.dpad_right){
                snippySnapOpen();
            }
           
                // Show the elapsed game time and wheel power.
            telemetry.addData("Status: ", "/nRun Time: " + runtime.toString() + "secs");
            telemetry.addData("Motors", "left (%.2f), right (%.2f), rleft(%.2f), rright(%.2f)",
                    leftDrive.getPower(), rightDrive.getPower(), rleftDrive.getPower(), rrightDrive.getPower());
            telemetry.addData("Servos", "0 (%.2f), 1 (%.2f), 2 (%.2f), 3 (%.2f)",
                    servo0.getPower(), servo1.getPower(), servo2.getPower(), servo3.getPower());
            telemetry.addData("Servos2", "P1 (%.2f), P2 (%.2f), P3 (%.2f), P4 (%.2f), L1 (%.2f), L2 (%.2f)",
                    pservo1.getPosition(), pservo2.getPosition(), pservo3.getPower(), pservo4.getPower(), lservo1.getPower(), lservo2.getPower());
            telemetry.addData("Servos3","C2 (%.2f), C1 (%.2f)",
                    cservo2.getPosition(), cservo1.getPosition());
            telemetry.update();
        } // end while (opModeIsActive()) Loop
    } // end runOpMode()
} // end class NationalsTest3
