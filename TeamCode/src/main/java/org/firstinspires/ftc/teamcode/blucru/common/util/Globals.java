package org.firstinspires.ftc.teamcode.blucru.common.util;

import static org.firstinspires.ftc.teamcode.blucru.common.util.Alliance.RED;
import static org.firstinspires.ftc.teamcode.blucru.common.util.Alliance.BLUE;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Globals {
    public static HardwareMap hwMap;
    public static Telemetry telemetry;
    public static double voltage = 13.0;
    public static Alliance alliance = RED;

    public static double getCorrectPower(double power){
        return power * 12.0/voltage;
    }
    public static void setAlliance(Alliance alliance){
        Globals.alliance = alliance;
    }
    public static void flipAlliance(){
        Globals.setAlliance(Globals.alliance.flip());
    }
}
