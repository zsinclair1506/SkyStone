package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous

public class BuildZoneBd extends LinearOpMode{

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
     * <p> this method is used to drag the foundation from the starting </p>
     * <p> position within the field to the corner of the build zone before parking</p>
     * 
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
            dM.forwardDriveSlow(1500);
            dM.leftDriveSlow(1750);
            dM.forwardDriveSlow(850);
            dM.stopDrive();
            aM.flipDown(1000);
            //aM.flipUp(500); not sure
            left_drive.setPower(-0.4);
            right_drive.setPower(0.3);
            rright_drive.setPower(-0.3);
            rleft_drive.setPower(0.4);
            sleep(3000);
            dM.stopDrive();
            aM.flipUp(500);
            //right
            dM.forwardDriveSlow(110);
            dM.rightDrive(1100);
            dM.forwardDriveSlow(3500);
            //left
            dM.leftDriveSlow(2300);
            dM.donutsLeft(220);
            aM.flipDown(1000);
            dM.forwardDriveSlow(3600);
            dM.leftDrive(1100);
            dM.leftDrive(200);
           
            //right
          /**  dM.leftDrive(800);
            dM.forwardDrive(1100);
            dM.leftDrive(550);
            dM.forwardDrive(250); */
            dM.stopDrive();
            telemetry.addData("Stopped","Run Complete");
            sleep(5000); // Approximately 18.5 Seconds
        
    }
} //23.5 seconds total
// Tests: 1 y 2 y 3 y 4 n 5 y 6 n 7 y 8 y 9 y 10 y Successful: 80%
