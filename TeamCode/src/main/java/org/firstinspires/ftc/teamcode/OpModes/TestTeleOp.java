package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Definitions.Intake;
import org.firstinspires.ftc.teamcode.Definitions.Intake2;

@TeleOp(name = "TestTeleOp")
public class TestTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Intake intake = new Intake();
        intake.initIntake(hardwareMap);
        Intake2 intake2 = new Intake2();
        intake2.initIntake2(hardwareMap);

        waitForStart();

        if (isStopRequested()) {
            return;
        }

        while (opModeIsActive()) {
            if (gamepad1.a) {
                intake.setIntake(624);
                intake2.setIntake2(1150);
            }

            if (gamepad1.y) {
                intake2.setIntake2(-1150);
                intake.setIntake(-624);
            }

            if (gamepad1.x) {
                intake.setIntake(0);
                intake2.setIntake2(0);
            }
        }
    }
}
