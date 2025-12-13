package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Definitions.DriveTrain;
import org.firstinspires.ftc.teamcode.Definitions.Intake;
import org.firstinspires.ftc.teamcode.Definitions.Intake2;
import org.firstinspires.ftc.teamcode.Definitions.Outtake;

@TeleOp(name = "MainTeleOp")
public class MainTeleOp extends LinearOpMode
{
    @Override
    public void runOpMode() throws InterruptedException
    {
        DriveTrain drive = new DriveTrain();
        drive.initDriveTrain(hardwareMap);
        Intake intake = new Intake();
        intake.initIntake(hardwareMap);
        Intake2 intake2 = new Intake2();
        intake2.initIntake2(hardwareMap);
        Outtake outtake = new Outtake();
        outtake.initOuttake(hardwareMap);

        double forward, strafe, rotate;

        boolean intakeOn = false;
        boolean intake2On = false;
        boolean lastRightBumper1 = false;
        boolean inouttakeOn = false;
        boolean inouttake2On = false;
        boolean lastLeftBumper1 = false;
        boolean outtakeOn = false;
        boolean lastRightBumper2 = false;
        boolean outouttakeOn = false;
        boolean lastLeftBumper2 = false;
        boolean transferUp = false;
        boolean lastUp = false;

        transfer = hardwareMap.get(Servo.class, "Transfer");

        Spindexer = hardwareMap.get(DcMotor.class, "Spindexer");
        Spindexer.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addData("Status", "Ready");
        telemetry.update();

        waitForStart();

        if (isStopRequested()) {
            return;
        }

        while (opModeIsActive())
        {
            forward = gamepad1.right_stick_y;
            strafe = -gamepad1.left_stick_x;
            rotate = gamepad1.right_stick_x;

            drive.mecanumEquations(forward, strafe, rotate);

            if (gamepad1.right_bumper && !lastRightBumper1) {
                intakeOn = !intakeOn;
                intake2On = !intake2On;
            }

            lastRightBumper1 = gamepad1.right_bumper;

            if (intakeOn) {
                intake.power(-0.7);
            }
            else {
                intake.power(0);
            }

            if (intake2On) {
                intake2.power(0.7);
            }
            else {
                intake2.power(0);
            }

            if (gamepad1.left_bumper && !lastLeftBumper1) {
                inouttakeOn = !inouttakeOn;
                inouttake2On = !inouttake2On;
            }

            lastLeftBumper1 = gamepad1.left_bumper;

            if (inouttakeOn) {
                intake.power(0.7);
            }
            else {
                intake.power(0);
            }

            if (inouttake2On) {
                intake2.power(-0.7);
            }
            else {
                intake2.power(0);
            }

            if (gamepad2.right_bumper && !lastRightBumper2) {
                outtakeOn = !outtakeOn;
            }

            lastRightBumper2 = gamepad2.right_bumper;

            if (outtakeOn) {
                outtake.power(-1);
            }
            else {
                outtake.power(0);
            }

            if (gamepad2.left_bumper && !lastLeftBumper2) {
                outouttakeOn = !outouttakeOn;
            }

            lastLeftBumper2 = gamepad2.left_bumper;

            if (outouttakeOn) {
                outtake.power(1);
            }
            else {
                outtake.power(0);
            }

            if (gamepad2.dpad_up && !lastUp) {
                transferUp = !transferUp;
            }

            lastUp = gamepad2.dpad_up;

            if (transferUp) {
                transfer.setPosition(0.2);
            }
            else {
                transfer.setPosition(0);
            }

            if (gamepad2.right_trigger > 0.5) {
                Spindexer.setPower(0.1);
            }
            else {
                Spindexer.setPower(0);
            }

            if (gamepad2.left_trigger > 0.5) {
                Spindexer.setPower(-0.1);
            }
            else {
                Spindexer.setPower(0);
            }
        }
    }
    private DcMotor Spindexer;
    private Servo transfer;
}

// cool comment 2