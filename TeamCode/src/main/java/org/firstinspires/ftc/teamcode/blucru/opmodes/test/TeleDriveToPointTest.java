package org.firstinspires.ftc.teamcode.blucru.opmodes.test;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.blucru.common.util.Pose2d;
import org.firstinspires.ftc.teamcode.blucru.opmodes.BluLinearOpMode;
@TeleOp(group =  "test")
public class TeleDriveToPointTest extends BluLinearOpMode {
    public void initialize(){
        enableDash();
        addDrivetrain();
        drivetrain.setCurrentPose(new Pose2d(0,0,0));
    }

    public void periodic(){
        if (driver1.pressedA()){
            //go 10 inches to the right from 0,0,0
            drivetrain.pidTo(new Pose2d(10,0,0));
        }
        if (driver1.pressedB()){
            //go 10 inches forward from 0,0,0
            drivetrain.pidTo(new Pose2d(0,10,0));
        }
        if (driver1.pressedX()){
            //rotate 90 degrees to the left from 0,0,0
            drivetrain.pidTo(new Pose2d(0,0,Math.PI/2));
        }
        if(driver1.pressedY()){
            //back to 0,0,0
            drivetrain.pidTo(new Pose2d(0,0,0));
        }
        if (driver1.pressedLeftBumper()){
            //idle drivetrain if something bad happens
            drivetrain.switchToIdle();
        }

        //reset heading
        if (driver1.pressedRightBumper()){
            drivetrain.setHeading(Math.PI/2);
        }


    }
}
