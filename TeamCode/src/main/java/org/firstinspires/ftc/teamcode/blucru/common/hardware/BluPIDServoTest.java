package org.firstinspires.ftc.teamcode.blucru.common.hardware;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.blucru.common.hardware.servo.BluPIDServo;
import org.firstinspires.ftc.teamcode.blucru.common.hardware.servo.BluServo;
import org.firstinspires.ftc.teamcode.blucru.opmodes.BluLinearOpMode;

@TeleOp
public class BluPIDServoTest extends BluLinearOpMode {
    BluPIDServo servo;
    @Override
    public void initialize(){
        servo = new BluPIDServo("test", 0.1, 0.00001);
    }

    @Override
    public void periodic(){

        servo.read();
        
        if (gamepad1.a){
            servo.setPosition(0.5);
        }

        if (gamepad1.b){
            servo.setPosition(0);
        }

        if (gamepad1.x){
            servo.setPosition(1);
        }

        servo.write();
    }

}
