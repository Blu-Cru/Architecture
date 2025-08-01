package org.firstinspires.ftc.teamcode.blucru.opmodes.test;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.blucru.common.hardware.motor.BluMotor;
import org.firstinspires.ftc.teamcode.blucru.opmodes.BluLinearOpMode;

public class BluMotorTest extends BluLinearOpMode {
    BluMotor bluMotor;
    DcMotorEx dcMotor;
    @Override
    public void initialize(){
        bluMotor = new BluMotor("frontLeft");
        dcMotor = hardwareMap.get(DcMotorEx.class, "frontRight");
        bluMotor.setPower(0);
        bluMotor.write();
        dcMotor.setPower(0);
    }

    public void periodic(){
        bluMotor.read();
        bluMotor.setPower(1);
        bluMotor.write();
        dcMotor.setPower(1);
    }
}
