package org.firstinspires.ftc.teamcode.blucru.common.pathing;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.blucru.common.subsytems.Robot;

public class DrivetrainSetPowerCommand extends InstantCommand {
    public DrivetrainSetPowerCommand(double power){
        super(() -> {
            Robot.getInstance().drivetrain.setDrivePower(power);
        });

        addRequirements(Robot.getInstance().drivetrain);
    }
}
