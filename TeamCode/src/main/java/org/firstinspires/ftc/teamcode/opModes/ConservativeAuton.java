//package org.firstinspires.ftc.teamcode.opModes;
//
//import com.acmerobotics.roadrunner.Pose2d;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//
//import org.firstinspires.ftc.teamcode.subsystems.DriveTrain;
//import org.firstinspires.ftc.teamcode.subsystems.Intake;
//
//@Autonomous(name="Conservative Auton")
//public class ConservativeAuton extends LinearOpMode {
//    Pose2d startPosition;
//
//    @Override
//    public void runOpMode() throws InterruptedException {
//        DriveTrain drivetrain = new DriveTrain(hardwareMap);
//        Intake intake = new Intake(hardwareMap);
//
//
//        startPosition = new Pose2d(0, 0, 0); // TODO: set actual start position
//        PinpointLocalizer localizer = new PinpointLocalizer(hardwareMap, 5, startPosition); // TODO: figure out what inPerTick is
//
//        waitForStart();
//        if (isStopRequested()) return;
//
//        while(opModeIsActive()){
//
//        }
//    }
//}
