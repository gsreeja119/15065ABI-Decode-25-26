package org.firstinspires.ftc.teamcode.OpModes;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Definitions.DriveTrain;
@TeleOp(name = "MainTeleOp")
public class MainTeleOp extends LinearOpMode
{


    @Override
    public void runOpMode() throws InterruptedException
    {



        DriveTrain drive = new DriveTrain();
        drive.initDrivetrain(hardwareMap);

        double forward, strafe, rotate;

        telemetry.addData("Status", "Ready");
        telemetry.update();

        waitForStart();

        if (isStopRequested()) {
            return;
        }

        while (opModeIsActive()){
            forward = gamepad1.right_stick_y;
            strafe = -gamepad1.left_stick_x;
            rotate = -gamepad1.right_stick_x;

            drive.driveFieldRelative(forward, strafe, rotate);
        }
    }

    private DcMotor frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor;

    public void initDrivetrain(HardwareMap hardwareMap) {
        frontLeftMotor = hardwareMap.get(DcMotor.class, "FrontLeftMotor");
        backLeftMotor = hardwareMap.get(DcMotor.class, "BackLeftMotor");
        frontRightMotor = hardwareMap.get(DcMotor.class, "FrontRightMotor");
        backRightMotor = hardwareMap.get(DcMotor.class, "BackRightMotor");

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

}

