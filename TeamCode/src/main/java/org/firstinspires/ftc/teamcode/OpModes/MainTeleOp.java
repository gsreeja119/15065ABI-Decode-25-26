package org.firstinspires.ftc.teamcode.OpModes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Definitions.DriveTrain;
import org.firstinspires.ftc.teamcode.Definitions.Intake;
import org.firstinspires.ftc.teamcode.Definitions.Outtake;

@TeleOp(name = "MainTeleOp")
public class MainTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DriveTrain drive = new DriveTrain();
        drive.initDriveTrain(hardwareMap);
        Intake intake = new Intake();
        intake.initIntake(hardwareMap);
        Outtake outtake = new Outtake();
        outtake.initOuttake(hardwareMap);

        double forward, strafe, rotate;

        boolean wasRightBumperPressed = false;
        boolean wasLeftBumperPressed = false;
        boolean wasBPressed = false;
        boolean intakeMotorIsOn = false;
        boolean outtakeMotorIsOn = false;
        boolean reverseIntakeMotor = false;
        boolean reverseIntakeIsOn = false;

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

            drive.mecanumEquations(forward,strafe,rotate);

            if (gamepad2.right_bumper && !wasRightBumperPressed) {
                intakeMotorIsOn = !intakeMotorIsOn;
                wasRightBumperPressed = true;
            }
            else {
                wasRightBumperPressed = false;
            }
            if (intakeMotorIsOn) {
                intakeMotor.setPower(1);
            }
            else {
                intakeMotor.setPower(0);
            }


            if (gamepad2.left_bumper && !wasLeftBumperPressed) {
                outtakeMotorIsOn = !outtakeMotorIsOn;
                wasLeftBumperPressed = true;
            }
            else {
                wasLeftBumperPressed = false;
            }
            if (outtakeMotorIsOn) {
                outtakeMotor.setPower(1);
            }
            else {
                outtakeMotor.setPower(0);
            }


            if (gamepad2.b && !wasBPressed) {
                reverseIntakeMotor = !reverseIntakeIsOn;
                wasBPressed = true;
            }
            else {
                wasBPressed = false;
            }

            if (reverseIntakeMotor) {
                intakeMotor.setPower(-1);
            }
            else {
                intakeMotor.setPower(0);
            }
        }
    }
    private DcMotor intakeMotor;
    private DcMotor outtakeMotor;
}