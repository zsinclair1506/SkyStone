package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous

/**
 * @author      Zac Sinclair, Rosemary Nguyen <zsinclair1506@gmail.com>
 * @version     1.3.3                 (current version number of program)
 * @since       1.??                   (the version of the package this class was first added to)
 */

public class BuildZoneRc extends LinearOpMode{

private ElapsedTime runtime;
private DcMotor left_drive;
private DcMotor right_drive;
private DcMotor rleft_drive;
private DcMotor rright_drive;
private CRServo servo0;
private CRServo servo1;
private CRServo servo2;
private CRServo servo3;
private CRServo lservo1;
private CRServo lservo2;
private Servo pservo1;
private Servo pservo2;
private CRServo pservo3;

 
/**
 * Autonomous Run to get foundation and park.                           (1)
 * <p>
 * While running this program the robot will travel from    (2)
 * a predetermined location against the wall to the centre of the
 * side of the foundation, it will then pull the foundation using
 * an attachment found on it's side, and release it and travel 
 * around to the other side to push it into the corner of the arena
 * afterwards the robot will travel to its right and park underneath 
 * the skybridge, before the end of the Autonomous period.
 * </p>
 *   
 * @param           (3)
 * @return Description text text text.
 */

    public void runOpMode() {
    
    DirectionMethods dM = new DirectionMethods(hardwareMap);
    AttachmentMethods aM = new AttachmentMethods(hardwareMap);
 
          left_drive = hardwareMap.dcMotor.get("left_drive");
          right_drive = hardwareMap.dcMotor.get("right_drive");
          rright_drive = hardwareMap.dcMotor.get("rright_drive");
          rleft_drive = hardwareMap.dcMotor.get("rleft_drive");
          servo0 = hardwareMap.get(CRServo.class,"servo0");
          servo1 = hardwareMap.get(CRServo.class,"servo1");
          servo2 = hardwareMap.get(CRServo.class,"servo2");
          servo3 = hardwareMap.get(CRServo.class,"servo3");
          lservo1 = hardwareMap.get(CRServo.class,"lservo1");
          lservo2 = hardwareMap.get(CRServo.class,"lservo2");
          pservo1 = hardwareMap.get(Servo.class,"pservo1");
          pservo2 = hardwareMap.get(Servo.class,"pservo2");
          pservo3 = hardwareMap.get(CRServo.class,"pservo3");
          runtime = new ElapsedTime();
        // Wait for the game to start (driver presses PLAY)
         waitForStart();
            // Start timer - saves running time in seconds
        runtime.reset();


        // run until the end of the match (driver presses STOP)
        
            telemetry.addLine("Run - Build Zone Blue");
            telemetry.update();
            dM.forwardDriveSlow(1500); //dM stands for Direction Methods - the object that has been instantiated above
            dM.rightDriveSlow(2250);
            dM.forwardDriveSlow(1500);
            dM.stopDrive();
            
            aM.flipDown(1200);
            //aM.flipUp(500); not sure
            left_drive.setPower(-0.4);
            right_drive.setPower(0.3);
            rright_drive.setPower(-0.3);
            rleft_drive.setPower(0.4); //Make Method, Devon said to make an override thing, 
            sleep(2700);
            dM.stopDrive();
            aM.flipUp(500);
            //right
            dM.forwardDriveSlow(90);
            dM.leftDrive(1150);
            dM.forwardDriveSlow(3650);
            //left
            dM.rightDriveSlow(2275);
            dM.donutsLeft(180);
            aM.flipDown(1000);
            dM.forwardDriveSlow(3250);
            //right
            dM.rightDrive(1300);
            dM.forwardDrive(150);
            dM.rightDrive(300);
            dM.backwardDriveSlow(1650);
           /** dM.rightDrive(800);
            dM.forwardDrive(1100);
            dM.rightDrive(550);
            dM.forwardDrive(250); */
            dM.stopDrive();
            telemetry.addData("Stopped","Run Complete");
            sleep(5000); // Approximately 18.5 Seconds // Definitely not that long lol
        
    }
} //23.5 seconds total
// Tests: 1 y 2 y 3 y 4 n 5 y 6 n 7 y 8 y 9 y 10 y Successful: 80%
