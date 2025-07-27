package org.firstinspires.ftc.teamcode.blucru.common.util;

import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.ejml.dense.block.VectorOps_DDRB;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class PDController extends PIDController{
    double p, d;
    Vector2d k;
    public PDController(){
        this(0);
    }
    public PDController(double p){
        this(p,0);
    }
    public PDController(double p, double d){
        super(p, 0,d);
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

    public double calculate(double errorPos, double errorVel){

        Vector2d error = new Vector2d(errorPos, errorVel);
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

    public void setPD(double p, double d){
        super.setPID(p, 0, d);
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
