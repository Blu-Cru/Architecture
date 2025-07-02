package org.firstinspires.ftc.teamcode.blucru.common.util;

public enum Alliance {
    BLUE,
    RED;
    public Alliance flip(){
        if (this == RED){
            return BLUE;
        } else{
            return RED;
        }
    }
}


