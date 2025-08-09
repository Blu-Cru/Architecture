package org.firstinspires.ftc.teamcode.blucru.opmodes.test;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.blucru.common.hardware.motor.BluMotorWithEncoder;
import org.firstinspires.ftc.teamcode.blucru.opmodes.BluLinearOpMode;

public class BluMotorWithEncoderComparisonTest extends BluLinearOpMode {
    BluMotorWithEncoder bluMotor;
    DcMotorEx dcMotor;
    @Override
    public void initialize(){
        bluMotor = new BluMotorWithEncoder("frontLeft");
        dcMotor = hardwareMap.get(DcMotorEx.class, "frontRight");
        bluMotor.setPower(0);
        bluMotor.write();
        dcMotor.setPower(0);
    }

    public void periodic(){
        //motors should both head the same way
        bluMotor.read();
        bluMotor.setPower(1);
        bluMotor.write();
        dcMotor.setPower(1);
    }

    public void telemetry(){
        telemetry.addData("Blu Motor encoder", bluMotor.getCurrentPos());
        telemetry.addData("DcMotor encoder", dcMotor.getCurrentPosition());
    }
}
