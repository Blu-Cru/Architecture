package org.firstinspires.ftc.teamcode.blucru.common.pathing;

import org.firstinspires.ftc.teamcode.blucru.common.util.Pose2d;

public interface PathSegment {

    public boolean isDone();
    public void startSegment();
    public boolean failed();
    public Pose2d getPose();
    public void runSegment();

}
