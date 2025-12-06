package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous (name = "BlueAllianceAuto")
public class CloseRedAuto extends LinearOpMode {
    private DcMotor frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor;

    public void runOpMode() {
        frontLeftMotor = hardwareMap.get(DcMotor.class, "FLMotor");
        backLeftMotor = hardwareMap.get(DcMotor.class, "BLMotor");
        frontRightMotor = hardwareMap.get(DcMotor.class, "FRMotor");
        backRightMotor = hardwareMap.get(DcMotor.class, "BRMotor");

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backRightMotor.setDirection(DcMotor.Direction.REVERSE);

        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        backRightMotor.setPower(1);
        backLeftMotor.setPower(1);
        frontLeftMotor.setPower(1);
        frontRightMotor.setPower(1);
        sleep(1500);

        backRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        sleep(5000);

        backRightMotor.setPower(-1);
        backLeftMotor.setPower(1);
        frontLeftMotor.setPower(-1);
        frontRightMotor.setPower(1);
        sleep(2000);

        backRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        sleep(5000);

        backRightMotor.setPower(1);
        backLeftMotor.setPower(1);
        frontLeftMotor.setPower(1);
        frontRightMotor.setPower(1);
        sleep(1500);

        backRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        sleep(5000);

        if (isStopRequested()) {
            return;
        }
    }
}