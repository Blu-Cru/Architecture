package org.firstinspires.ftc.teamcode.blucru.common.subsytems;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.ArrayList;
import java.util.List;

public class Robot {

    //add all subsystems here
    //class will be a singleton bc there is only 1 robot


    //list of subsystems
    ArrayList<BluSubsystem> subsystems;
    static Robot instance;
    HardwareMap hwMap;
    List<LynxModule> hubs;
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

    public void setHwMap(HardwareMap hwMap){
        this.hwMap = hwMap;
    }

    public void init(){
        //store the hubs in an array
        hubs = hwMap.getAll(LynxModule.class);

        //set the hubs to auto bulk reads
        for (LynxModule hub : hubs){
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.AUTO);
        }

        //init all subsystems
        for (BluSubsystem subsystem : subsystems){
            subsystem.init();
        }
    }

    public void read(){


        //clear caches of both hubs
        for (LynxModule hub:hubs){
            hub.clearBulkCache();
        }

        //read from each subsytem
        for (BluSubsystem subsystem: subsystems){
            subsystem.read();
        }
    }

    public void write(){
        //write to each subsystem
        for (BluSubsystem subsystem : subsystems){
            subsystem.write();
        }
    }




}
