package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Definitions.DriveTrain;
import org.firstinspires.ftc.teamcode.Definitions.Intake;
import org.firstinspires.ftc.teamcode.Definitions.Intake2;
import org.firstinspires.ftc.teamcode.Definitions.Outtake;
import org.firstinspires.ftc.teamcode.Definitions.Spindexer;

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
        Spindexer spindexer = new Spindexer();
        spindexer.initSpindexer(hardwareMap);

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
        Spindexer.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        intakeMotor = hardwareMap.get(DcMotor.class, "Intake");
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        intakeMotor2 = hardwareMap.get(DcMotor.class, "Intake2");
        intakeMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        outtakeMotor = hardwareMap.get(DcMotor.class, "Outtake");
        outtakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        outtakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

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
                intake.setSafePower(intakeMotor, -0.9);
            }
            else {
                intake.setSafePower(intakeMotor, 0);
            }

            if (intake2On) {
                intake2.setSafePower(intakeMotor2, 0.9);
            }
            else {
                intake2.setSafePower(intakeMotor2, 0);
            }

            if (gamepad1.left_bumper && !lastLeftBumper1) {
                inouttakeOn = !inouttakeOn;
                inouttake2On = !inouttake2On;
            }

            lastLeftBumper1 = gamepad1.left_bumper;

            if (inouttakeOn) {
                intake.setSafePower(intakeMotor, 0.9);
            }
            else {
                intake.setSafePower(intakeMotor, 0);
            }

            if (inouttake2On) {
                intake2.setSafePower(intakeMotor2, -0.9);
            }
            else {
                intake2.setSafePower(intakeMotor2, 0);
            }

            if (gamepad2.right_bumper && !lastRightBumper2) {
                outtakeOn = !outtakeOn;
            }

            lastRightBumper2 = gamepad2.right_bumper;

            if (outtakeOn) {
                outtake.setOuttake(1200);
            }
            else {
                outtake.setOuttake(0);
            }

            if (gamepad2.left_bumper && !lastLeftBumper2) {
                outouttakeOn = !outouttakeOn;
            }

            lastLeftBumper2 = gamepad2.left_bumper;

            if (outouttakeOn) {
                outtake.setSafePower(outtakeMotor, 1);
            }
            else {
                outtake.setSafePower(outtakeMotor, 0);
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
                spindexer.setSafePower(Spindexer, 0.1);
            }
            else {
                spindexer.setSafePower(Spindexer, 0);
            }

            if (gamepad2.left_trigger > 0.5) {
                spindexer.setSafePower(Spindexer, -0.1);
            }
            else {
                spindexer.setSafePower(Spindexer, 0);
            }
        }
    }
    private DcMotor Spindexer;
    private Servo transfer;
    private DcMotor intakeMotor;
    private DcMotor intakeMotor2;
    private DcMotor outtakeMotor;
}

// cool comment 2