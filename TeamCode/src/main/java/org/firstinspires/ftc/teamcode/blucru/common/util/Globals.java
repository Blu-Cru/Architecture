package org.firstinspires.ftc.teamcode.blucru.common.util;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Globals {
    public static HardwareMap hwMap;
    public static Telemetry telemetry;
    public static double voltage = 13.0;

    public static double getCorrectPower(double power){
        return power * 12.0/voltage;
    }
}
