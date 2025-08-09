package org.firstinspires.ftc.teamcode.blucru.opmodes.test;

import org.firstinspires.ftc.teamcode.blucru.common.util.Pose2d;
import org.firstinspires.ftc.teamcode.blucru.opmodes.BluLinearOpMode;

public class DriveKStaticTuner extends BluLinearOpMode {
    double power;
    enum Direction{
        X,Y
    }
    Direction motorDirection;
    public void initialize(){
        addDrivetrain();
        motorDirection = Direction.Y;
    }

    public void periodic(){
        if (driver1.pressedRightBumper()){
            power += 0.01;
        }
        if (driver1.pressedLeftBumper()){
            power -= 0.01;
        }
        if (driver1.pressedA()){
            if (motorDirection == Direction.Y){
                motorDirection = Direction.X;
            } else {
                motorDirection = Direction.Y;
            }
        }

        if (motorDirection == Direction.Y){
            drivetrain.drive(new Pose2d(0, power, 0));
        } else {
            drivetrain.drive(new Pose2d(power, 0,0));
        }
    }

}
