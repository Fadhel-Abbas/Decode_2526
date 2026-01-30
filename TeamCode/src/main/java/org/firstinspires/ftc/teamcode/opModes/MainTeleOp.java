package org.firstinspires.ftc.teamcode.opModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Launcher;

@TeleOp(name="Main TeleOp")
public class MainTeleOp extends LinearOpMode {
    boolean isOpen = false;
    boolean lastA = false;
    @Override
    public void runOpMode() throws InterruptedException {
        DriveTrain drivetrain = new DriveTrain(hardwareMap);
        Intake intake = new Intake(hardwareMap);
        Launcher launcher = new Launcher(hardwareMap);

        waitForStart();
        if (isStopRequested()) return;

        while(opModeIsActive()){

            double y = gamepad1.left_stick_y;
            double x = gamepad1.right_stick_x;

            double leftVelocity = (y + x) * 600;
            double rightVelocity = (y - x) * 600;

            drivetrain.setLeftMotor(leftVelocity);
            drivetrain.setRightMotor(rightVelocity);


            if(gamepad1.xWasPressed() || gamepad2.xWasPressed()) intake.setMaxVelocity();
            if(gamepad1.aWasPressed() || gamepad2.aWasPressed()) intake.setZeroVelocity();
            if(gamepad1.yWasPressed()) launcher.toggle();
            if(gamepad1.rightBumperWasPressed()) launcher.fire();

        }
    }
}
