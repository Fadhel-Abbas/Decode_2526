package org.firstinspires.ftc.teamcode.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private DcMotorEx intakeMotor;
    double maxVelocity;
    private boolean isIntakeRunning;

    public Intake(HardwareMap hardwareMap) {
        intakeMotor = (DcMotorEx) hardwareMap.dcMotor.get("intakeMotor");
        intakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // the maximum free speed of a core hex motor is 600tps
        maxVelocity = -600;
    }

    public void setMaxVelocity(){
        intakeMotor.setVelocity(maxVelocity);
        isIntakeRunning = true;
    }

    public void setZeroVelocity(){
        intakeMotor.setVelocity(0);
    }


    public boolean getIsIntakeRunning(){
        return isIntakeRunning;
    }

}
