package org.firstinspires.ftc.teamcode.blucru.common.hardware.motor;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorImplEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.blucru.common.hardware.BluHardwareDevice;
import org.firstinspires.ftc.teamcode.blucru.common.util.Globals;

public class BluEncoder extends DcMotorImplEx implements BluHardwareDevice {
    String name;
    double encoderTicks=0;
    double vel=0;
    public BluEncoder(String name, Direction direction) {
        this(name, direction, ZeroPowerBehavior.FLOAT);
    }
    public BluEncoder(String name){
        this(name, Direction.FORWARD);
    }
    public BluEncoder(String name, Direction direction, ZeroPowerBehavior zpb){
        this(Globals.hwMap.get(DcMotor.class, name), name, direction, zpb);
    }
    private BluEncoder(DcMotor motor, String name, Direction direction, ZeroPowerBehavior zpb){
        super(motor.getController(), motor.getPortNumber(), direction);
        this.name = name;
        super.setZeroPowerBehavior(zpb);
    }

    @Override
    public void init() {
        init(false);
    }
    public void init(boolean resetEncoders){
        super.setPower(0);
        if (resetEncoders){
            reset();
        }
    }

    public void reset(){
        super.setMode(RunMode.STOP_AND_RESET_ENCODER);
        super.setMode(RunMode.RUN_WITHOUT_ENCODER);
    }

    public double getCurrentPos(){
        return encoderTicks;
    }
    public double getVel(){
        return vel;
    }
    @Override
    public void read() {
        encoderTicks = super.getCurrentPosition();
        vel = super.getVelocity();
    }

    @Override
    public void write() {

    }

    @Override
    public void telemetry() {
        Telemetry telemetry = Globals.telemetry;
        telemetry.addData(name + " Pos: ", encoderTicks);
        telemetry.addData(name + " Vel: ", vel);
    }
}
