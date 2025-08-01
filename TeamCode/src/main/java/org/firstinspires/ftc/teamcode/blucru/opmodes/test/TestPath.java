package org.firstinspires.ftc.teamcode.blucru.opmodes.test;

import org.firstinspires.ftc.teamcode.blucru.common.pathing.PIDPathBuilder;
import org.firstinspires.ftc.teamcode.blucru.common.util.Pose2d;

public class TestPath extends PIDPathBuilder {
    public TestPath(){
        super();
        this.setPower(0.5)
                .addMappedPoint(new Pose2d(0,24,0),1.5)
                .waitMilliseconds(1000)
                .setPower(1)
                .addMappedPoint(new Pose2d(0,0,0), 1.5)
                .waitMilliseconds(1000);
    }

}
