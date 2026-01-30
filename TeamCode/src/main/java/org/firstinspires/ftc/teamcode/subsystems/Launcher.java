package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.Timer;
import java.util.TimerTask;

public class Launcher {

    private DcMotorEx launcherMotor;
    private Servo transferServo;
    private final double LAUNCHER_VELOCITY = 1500;
    static final double NEUTRAL = 0.0;
    static final double TRANSFER  = 0.5; // 0.5 = 90 DEG
    static final int COOLDOWN = 1000; // ms
    private boolean isLauncherRunning = false;
    Timer cooldownTimer;
    TimerTask cooldownTask;

    public Launcher(HardwareMap hardwareMap) {
        transferServo = hardwareMap.get(Servo.class, "servo1");
        launcherMotor = hardwareMap.get(DcMotorEx.class, "LauncherMotor");

        launcherMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        launcherMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        cooldownTimer = new Timer();
        cooldownTask = new TimerTask() {
            @Override
            public void run() {
                transferServo.setPosition(NEUTRAL);
            }
        };
    }

    public void setMaxVelocity() {
        launcherMotor.setVelocity(LAUNCHER_VELOCITY);
        isLauncherRunning = true;
    }

    public void fire() {
        double currentVelocity = launcherMotor.getVelocity();
        if(currentVelocity == LAUNCHER_VELOCITY) {
            cooldownTimer.cancel();
            transferServo.setPosition(TRANSFER);
            cooldownTimer.schedule(cooldownTask, COOLDOWN);
        } else {
            telemetry.addLine("launcher not yet spooled, current velocity:" + currentVelocity);
            telemetry.update();
        }
    }

    public void setZeroVelocity() {
        launcherMotor.setVelocity(0);
        isLauncherRunning = false;
    }
    public void toggle(){
        if(isLauncherRunning){
            setZeroVelocity();
        } else {
            setMaxVelocity();
        }
    }

    public boolean isRunning() {
        return isLauncherRunning;
    }
}