package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Definitions.Intake;
import org.firstinspires.ftc.teamcode.Definitions.Intake2;
@Disabled
@TeleOp(name = "TestTeleOp")
public class TestTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Spindexer = hardwareMap.get(DcMotor.class, "Spindexer");
        Spindexer.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Spindexer.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();

        if (isStopRequested()) {
            return;
        }

        while (opModeIsActive()) {
            if (gamepad2.left_bumper) {
                encoder(3);
            }

            if (gamepad2.dpad_up) {
                encoder(6);
            }
        }
    }
    double ticks = 145.1;
    double newTarget;
    private DcMotor Spindexer;
    public void encoder(int turnage) {
        Spindexer.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        newTarget = ticks/turnage;
        Spindexer.setTargetPosition((int)newTarget);
        Spindexer.setPower(0.6);
        Spindexer.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
}
