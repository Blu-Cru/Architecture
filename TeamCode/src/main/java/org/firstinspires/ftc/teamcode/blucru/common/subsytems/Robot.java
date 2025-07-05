package org.firstinspires.ftc.teamcode.blucru.common.subsytems;

import java.util.ArrayList;

public class Robot {

    //add all subsystems here
    //class will be a singleton bc there is only 1 robot


    //list of subsystems
    ArrayList<BluSubsystem> subsystems;
    static Robot instance;
    public static Robot getInstance(){
        if (instance == null){
            instance = new Robot();
        }
        return instance;
    }

    //private constructor to init subsystems

    private Robot(){
        subsystems = new ArrayList<>();
    }




}
