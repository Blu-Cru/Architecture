package org.firstinspires.ftc.teamcode.blucru.common.pathing;

import org.firstinspires.ftc.teamcode.blucru.common.util.Pose2d;

public class WaitSegment implements PathSegment{
    final PathSegment previous;
    private final double waitTime;
    private double startTime;
    public WaitSegment(PathSegment previous, double waitTime){
        this.previous = previous;
        this.waitTime = waitTime;
    }
    @Override
    public boolean isDone() {
        return System.currentTimeMillis() - startTime >= waitTime;
    }

    @Override
    public void startSegment() {
        startTime = System.currentTimeMillis();
    }

    @Override
    public boolean failed() {
        return false;
    }

    @Override
    public Pose2d getPose() {
        return previous.getPose();
    }

    @Override
    public void runSegment() {
        previous.runSegment();
    }
}
