package org.firstinspires.ftc.teamcode.blucru.common.hardware.servo;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.CRServoImpl;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImpl;

import org.firstinspires.ftc.teamcode.blucru.common.hardware.BluHardwareDevice;
import org.firstinspires.ftc.teamcode.blucru.common.util.Globals;
import org.firstinspires.ftc.teamcode.blucru.common.util.PDController;
import org.firstinspires.ftc.teamcode.blucru.common.util.Vector2d;

public class BluPIDServo extends ServoImpl implements BluHardwareDevice {
    PDController pid;
    String name;
    double targetPos;
    double currentPos;
    double currPower;

    public BluPIDServo(String name, Direction direction, PDController pid) {
        this(Globals.hwMap.get(Servo.class, name), name, direction, pid);
    }

    public BluPIDServo(String name, PDController pid) {
        this(name, Direction.FORWARD, pid);
    }

    private BluPIDServo(Servo servo, String name, Direction direction, PDController pid) {
        super(servo.getController(), servo.getPortNumber(), direction);
        this.name = name;
        this.targetPos = 0;
        this.currentPos = 0;
    }

    public BluPIDServo(String name, Direction direction, double p, double d) {
        this(name, direction, new PDController(p, d));
    }

    public BluPIDServo(String name, double p, double d) {
        this(name, new PDController(p, d));
    }

    public void init() {
        super.setPosition(0);
    }

    @Override
    public void read() {
        currentPos = super.getPosition();
    }

    public void setPid(double p, double d) {
        pid.setPID(p, 0, d);
    }

    public void setPosition(double pos) {
        pid.setSetPoint(pos);
    }
    @Override
    public void write() {
        double pidPower = pid.calculate(new Vector2d(targetPos, currPower));
    }

    @Override
    public void telemetry() {

    }
}
