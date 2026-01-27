package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Launcher {

    private DcMotorEx launcherMotor;
    private final double LAUNCHER_VELOCITY = 1500;
    private boolean isLauncherRunning = false;

    public Launcher(HardwareMap hardwareMap) {
        launcherMotor = hardwareMap.get(DcMotorEx.class, "LauncherMotor");

        launcherMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        launcherMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void start() {
        launcherMotor.setVelocity(LAUNCHER_VELOCITY);
        isLauncherRunning = true;
    }

    public void stop() {
        launcherMotor.setVelocity(0);
        isLauncherRunning = false;
    }

    public boolean isRunning() {
        return isLauncherRunning;
    }
}