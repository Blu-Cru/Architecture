package org.firstinspires.ftc.teamcode.blucru.common.hardware;

import com.qualcomm.robotcore.hardware.Gamepad;

public class SinglePressGamepad {

    //logging only single presses for toggles

    //a,b,x,y in that order;
    private boolean[] lastFaceButtons;

    //dpad up down left right in that order;
    private boolean[] lastDpad;

    //bumpers, left then right;
    private boolean[] lastBumper;

    //stick buttons, left then right;
    private boolean[] lastStickButton;

    //options and share, in that order;
    private boolean[] lastOptionsAndShare;

    //triggers, left and right in that order;
    private boolean[] lastTriggersPressed;

    //touchpad
    private boolean lastTouchpad;

    Gamepad gamepad;
    double triggerTolerance = 0.2;

    public SinglePressGamepad(Gamepad gamepad){
        this.gamepad = gamepad;
        lastFaceButtons = new boolean[]{false, false, false, false};
        lastDpad = new boolean[]{false, false, false, false};
        lastBumper = new boolean[]{false, false};
        lastStickButton = new boolean[]{false, false};
        lastOptionsAndShare = new boolean[]{false, false};
        lastTriggersPressed = new boolean[]{false, false};
        lastTouchpad = false;
    }


    //face button functions
    public boolean pressedA(){
        boolean res = gamepad.a && !lastFaceButtons[0];
        lastFaceButtons[0] = gamepad.a;
        return res;
    }
    public boolean pressedB(){
        boolean res = gamepad.b && !lastFaceButtons[1];
        lastFaceButtons[1] = gamepad.b;
        return res;
    }
    public boolean pressedX(){
        boolean res = gamepad.x && !lastFaceButtons[2];
        lastFaceButtons[2] = gamepad.x;
        return res;
    }
    public boolean pressedY(){
        boolean res = gamepad.y && !lastFaceButtons[3];
        lastFaceButtons[3] = gamepad.y;
        return res;
    }

    //dpad functions
    public boolean pressedDpadUp(){
        boolean res = gamepad.dpad_up && !lastDpad[0];
        lastDpad[0] = gamepad.dpad_up;
        return res;
    }
    public boolean pressedDpadDown(){
        boolean res = gamepad.dpad_down && !lastDpad[1];
        lastDpad[1] = gamepad.dpad_down;
        return res;
    }
    public boolean pressedDpadLeft(){
        boolean res = gamepad.dpad_left && !lastDpad[2];
        lastDpad[2] = gamepad.dpad_left;
        return res;
    }
    public boolean pressedDpadRight(){
        boolean res = gamepad.dpad_right && !lastDpad[3];
        lastDpad[3] = gamepad.dpad_right;
        return res;
    }

    //bumper functions
    public boolean pressedLeftBumper(){
        boolean res = gamepad.left_bumper && !lastBumper[0];
        lastBumper[0] = gamepad.left_bumper;
        return res;
    }
    public boolean pressedRightBumper(){
        boolean res = gamepad.right_bumper && !lastBumper[1];
        lastBumper[1] = gamepad.right_bumper;
        return res;
    }

    //stick button functions
    public boolean pressedLeftStickButton(){
        boolean res = gamepad.left_stick_button && !lastStickButton[0];
        lastBumper[0] = gamepad.left_stick_button;
        return res;
    }
    public boolean pressedRightStickButton(){
        boolean res = gamepad.right_stick_button && !lastStickButton[1];
        lastBumper[1] = gamepad.right_stick_button;
        return res;
    }

    //options and share functions
    public boolean pressedOptions(){
        boolean res = gamepad.options && !lastOptionsAndShare[0];
        lastOptionsAndShare[0] = gamepad.options;
        return res;
    }
    public boolean pressedShare(){
        boolean res = gamepad.share && !lastOptionsAndShare[1];
        lastOptionsAndShare[1] = gamepad.share;
        return res;
    }

    //pressing triggers
    public boolean pressedLeftTrigger(){
        boolean triggerPressed = gamepad.left_trigger > triggerTolerance;
        boolean res = triggerPressed && !lastTriggersPressed[0];
        lastOptionsAndShare[0] = triggerPressed;
        return res;
    }
    public boolean pressedRightTrigger(){
        boolean triggerPressed = gamepad.right_trigger > triggerTolerance;
        boolean res = triggerPressed && !lastTriggersPressed[1];
        lastOptionsAndShare[1] = triggerPressed;
        return res;
    }

    //touchpad functions
    public boolean pressedTouchpad(){
        boolean res = gamepad.touchpad && !lastTouchpad;
        lastTouchpad = gamepad.touchpad;
        return res;
    }
}
