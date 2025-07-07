package org.firstinspires.ftc.teamcode.blucru.common.subsytems.mecanumDrivetrain.localization;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.blucru.common.util.Globals;
import org.firstinspires.ftc.teamcode.blucru.common.util.Pose2d;

public class Pinpoint implements RobotLocalizer{

    GoBildaPinpointDriver pinpoint;
    double headingOffset;

    Pose2D pinpointPose;

    public Pinpoint(String name){
        this(Globals.hwMap.get(GoBildaPinpointDriver.class, name));
    }

    public Pinpoint(GoBildaPinpointDriver pinpoint){
        this.pinpoint = pinpoint;
        headingOffset = 0;
        pinpointPose = pinpoint.getPosition();
    }

    @Override
    public void read() {
        pinpoint.update();
        pinpointPose = pinpoint.getPosition();
    }

    /**
     * returns pose in x,y,h in inch,inch,radian
     * */
    @Override
    public Pose2d getPose() {

        //Pose2D is different from Pose2d, Pose2D is ftc's Pose where Pose2d is the custom pose
        return new Pose2d(pinpointPose.getX(DistanceUnit.INCH), pinpointPose.getY(DistanceUnit.INCH), pinpointPose.getHeading(AngleUnit.RADIANS));
    }

    /**
     * in inches
     * */
    @Override
    public double getX() {
        return pinpointPose.getX(DistanceUnit.INCH);
    }

    /**
     * in inches
     * */
    @Override
    public double getY() {
        return pinpointPose.getY(DistanceUnit.INCH);
    }

    /**
     * in radians
     * */
    @Override
    public double getHeading() {
        return pinpointPose.getHeading(AngleUnit.RADIANS) - headingOffset;
    }

    /**
     * for setting offsets, inch, inch, radian
     * */
    @Override
    public void setOffset(double x, double y, double h) {
        pinpoint.setOffsets(x,y,DistanceUnit.INCH);
        headingOffset = h;
    }

    /**
     * inch, inch, radian
     * */
    public void setPosition(double x, double y, double h){
        pinpoint.setPosX(x, DistanceUnit.INCH);
        pinpoint.setPosY(y, DistanceUnit.INCH);
        pinpoint.setHeading(h, AngleUnit.RADIANS);
        read();
    }
}
