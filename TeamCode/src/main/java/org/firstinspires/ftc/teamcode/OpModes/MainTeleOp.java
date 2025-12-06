package org.firstinspires.ftc.teamcode.OpModes;
import androidx.annotation.NonNull;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Definitions.DriveTrain;
import org.firstinspires.ftc.teamcode.Definitions.Intake;
import org.firstinspires.ftc.teamcode.Definitions.Intake2;
import org.firstinspires.ftc.teamcode.Definitions.Outtake;
import org.firstinspires.ftc.teamcode.Definitions.Transfer;

@TeleOp(name = "MainTeleOp")
public class MainTeleOp extends LinearOpMode
{
    @Override
    public void runOpMode() throws InterruptedException
    {
        Transfer transfer = new Transfer();
        transfer.initServo(hardwareMap);
        DriveTrain drive = new DriveTrain();
        drive.initDriveTrain(hardwareMap);
        Intake intake = new Intake();
        intake.initIntake(hardwareMap);
        Intake2 intake2 = new Intake2();
        intake2.initIntake2(hardwareMap);
        Outtake outtake = new Outtake();
        outtake.initOuttake(hardwareMap);

        double forward, strafe, rotate;

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

            while (gamepad1.left_bumper) {
                intake.power(-1);
                intake2.power(-1);
            }

            while (gamepad1.right_bumper) {
                intake.power(1);
                intake2.power(1);
            }

            while (gamepad2.right_bumper) {
                outtake.power(-1);
            }

            if (gamepad2.xWasPressed()) {
                Transfer.setPosition(0.4);
            }
            else {
                Transfer.setPosition(0);
            }

            if (gamepad2.left_bumper) {
                encoder(3);
            }

            if (gamepad2.dpad_up) {
                encoder(6);
            }
        }
    }
    double ticks = 537.7;
    double newTarget;
    private DcMotor Spindexer;
    private Servo Transfer;

    public void initServo(HardwareMap hardwareMap) {
        Transfer = hardwareMap.get(Servo.class, "Transfer");
    }

    public void initSpindexer(@NonNull HardwareMap spindexer) {
        Spindexer = spindexer.get(DcMotor.class, "Spindexer");
        Spindexer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Spindexer.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void encoder(int turnage) {
        newTarget = ticks/turnage;
        Spindexer.setTargetPosition((int)newTarget);
        Spindexer.setPower(0.5);
        Spindexer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}