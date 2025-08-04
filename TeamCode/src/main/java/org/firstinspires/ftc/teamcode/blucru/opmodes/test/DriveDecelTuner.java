package org.firstinspires.ftc.teamcode.blucru.opmodes.test;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.blucru.common.util.Pose2d;
import org.firstinspires.ftc.teamcode.blucru.common.util.Vector2d;
import org.firstinspires.ftc.teamcode.blucru.opmodes.BluLinearOpMode;

public class DriveDecelTuner extends BluLinearOpMode {

    double initialVelX;
    double initialVelY;
    double initialVelH;
    double finalVelX;
    double finalVelY;
    double finalVelH;
    double xDecel;
    double yDecel;
    double hDecel;
    Pose2d dists;
    Pose2d initPose;
    public void initialize(){
        addDrivetrain();
        enableDash();
        initialVelX = 0;
        initialVelY = 0;
        initialVelH = 0;
        finalVelX = 0;
        finalVelY = 0;
        finalVelH = 0;
        xDecel = 0;
        yDecel = 0;
        hDecel = 0;
        dists = new Pose2d(0,0,0);
        initPose = new Pose2d(0,0,0);
        drivetrain.setCurrentPose(new Pose2d(0,0,0));
    }

    public void periodic(){
        if (driver1.pressedA()){
            drivetrain.drive(new Pose2d(1,0,0));
        }
        if (driver1.pressedB()){
            drivetrain.drive(new Pose2d(0,1,0));
        }
        if (driver1.pressedX()) {
            drivetrain.drive(new Pose2d(0,0,1));
        }
        if (driver1.pressedY()){
            initialVelX = drivetrain.xState.getY();
            initialVelY = drivetrain.yState.getY();
            initialVelH = drivetrain.headingVel;

            initPose = drivetrain.currPose;

            drivetrain.drive(new Pose2d(0,0,0));
        }
        if (driver1.pressedRightBumper()){
            finalVelX = drivetrain.xState.getY();
            finalVelY = drivetrain.yState.getY();
            finalVelH = drivetrain.headingVel;

            Pose2d finalPose = drivetrain.currPose;
            dists = new Pose2d(finalPose.vec().subtractNotInPlace(initPose.vec()), finalPose.getH() - initPose.getH());

            xDecel = (initialVelX * initialVelX - finalVelX * finalVelX) / (2 * dists.getX());
            yDecel = (initialVelY * initialVelY - finalVelY * finalVelY) / (2 * dists.getY());
            hDecel = (initialVelH * initialVelH - finalVelH * finalVelH) / (2 * dists.getH());
        }
    }

    @Override
    public void telemetry() {
        telemetry.addData("x decel", xDecel);
        telemetry.addData("y decel", yDecel);
        telemetry.addData("h decel", hDecel);
    }
}
