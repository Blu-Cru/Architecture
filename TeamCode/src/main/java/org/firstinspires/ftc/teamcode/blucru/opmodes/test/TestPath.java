package org.firstinspires.ftc.teamcode.blucru.opmodes.test;

import org.firstinspires.ftc.teamcode.blucru.common.pathing.PIDPathBuilder;
import org.firstinspires.ftc.teamcode.blucru.common.util.Globals;
import org.firstinspires.ftc.teamcode.blucru.common.util.Pose2d;

public class TestPath extends PIDPathBuilder {
    public TestPath(){
        super();
        this.setPower(0.5)
                .addMappedPoint(new Pose2d(0,24,Math.PI/2),1.5)
                .waitMilliseconds(1000)
                .setPower(1)
                .addMappedPoint(new Pose2d(0,0,Math.PI/2), 1.5)
                .callback(() -> {
                    Globals.telemetry.addData("Callback", "running");
                })
                .waitMilliseconds(1000);
    }

}
