package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class DriveTrain {
    private DcMotorEx leftMotor;
    private DcMotorEx rightMotor;

    public DriveTrain(HardwareMap hardwareMap){
        leftMotor = (DcMotorEx) hardwareMap.dcMotor.get("leftMotor");
        rightMotor = (DcMotorEx) hardwareMap.dcMotor.get("rightMotor");

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void setLeftMotor(double velocity) {
        leftMotor.setVelocity(velocity);
    }

    public void setRightMotor(double velocity) {
        rightMotor.setVelocity(velocity);
    }
}
