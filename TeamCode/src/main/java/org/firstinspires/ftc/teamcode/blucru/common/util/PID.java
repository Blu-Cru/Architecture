package org.firstinspires.ftc.teamcode.blucru.common.util;

import com.arcrobotics.ftclib.controller.PIDController;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class PID extends PIDController{
    double p, i, d;
    Vector2d k;
    public PID(){
        this(0);
    }
    public PID(double p){
        this(p,0);
    }
    public PID(double p, double d){
        this(p, 0, d);
    }
    public PID(double p, double i, double d){
        super(p, i,d);
        k = new Vector2d(p, d);
    }

    public double calculate(double currentPos, double targetPos, double currentVel, double targetVel){
        Vector2d pv = new Vector2d(currentPos, currentVel);
        Vector2d sp = new Vector2d(targetPos, targetVel);

        return calculate(pv, sp);
    }

    public double calculate(Vector2d curr, Vector2d target){
        Vector2d error = target.subtractNotInPlace(curr);

        super.setSetPoint(error.getX());
        return error.dotProduct(k);
    }

    public double calculate(Vector2d curr){
        return calculate(curr, new Vector2d(getSetPoint(), 0));
    }
    public double calculate(Vector2d pv, MotionProfile profile){
        Vector2d sp = profile.getInstantState();
        return calculate(pv, sp);
    }

    public void setPID(double p, double i, double d){
        super.setPID(p,i,d);
    }
    public void setPD(double p, double d){
        super.setPID(p, this.i, d);
    }
    public void setP(double p){
        super.setP(p);
    }
    public void setD(double d){
        super.setD(d);
    }

    public void telemetry(){
        Telemetry telemetry = Globals.telemetry;
        telemetry.addData("Set Point: ", super.getSetPoint());
    }
}
