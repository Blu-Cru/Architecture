package org.firstinspires.ftc.teamcode.blucru.common.hardware;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.blucru.common.util.Globals;

public class BluTouchSensor implements BluHardwareDevice{
    TouchSensor sensor;
    String name;
    private boolean state;
    private boolean lastState;
    public BluTouchSensor(TouchSensor sensor, String name){
        this.sensor = sensor;
        state=false;
        lastState=false;
        this.name = name;
    }
    public BluTouchSensor(String name){
        this(Globals.hwMap.get(TouchSensor.class, name),name);
    }

    @Override
    public void init() {
        state=false;
        lastState=false;
    }

    @Override
    public void read() {
        lastState = state;
        state = sensor.isPressed();
    }

    @Override
    public void write() {

    }

    /**
     * returns if the sensor is pressed, the passed in boolean being true
     * means that if the sensor was pressed last loop then it will return false while
     * having the boolean be false means that the last state does not matter at all
     * */
    public boolean isPressed(boolean debounce){
        return (debounce && !lastState && state) || (!debounce && state);
    }

    public boolean isPressed(){
        return isPressed(false);
    }
    public boolean changed(){
        return state != lastState;
    }

    @Override
    public void telemetry() {
        Globals.telemetry.addData(name + " Sensor Pressed", isPressed());
        Globals.telemetry.addData(name + " Changed", changed());
    }
}
