package org.firstinspires.ftc.teamcode.OpModes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Definitions.AutoDriveTrain;
import org.firstinspires.ftc.teamcode.Definitions.DriveTrain;
import org.firstinspires.ftc.teamcode.Definitions.Intake;
import org.firstinspires.ftc.teamcode.Definitions.Outtake;
import org.firstinspires.ftc.teamcode.Definitions.Transfer;

@TeleOp(name = "MainTeleOp")
public class MainTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        AutoDriveTrain autoDriveTrain = new AutoDriveTrain();
        DriveTrain drive = new DriveTrain();
        drive.initDriveTrain(hardwareMap);
        Intake intake = new Intake();
        intake.initIntake(hardwareMap);
        Outtake outtake = new Outtake();
        outtake.initOuttake(hardwareMap);
        Transfer transfer = new Transfer();
        transfer.initTransfer(hardwareMap);

        double forward, strafe, rotate;

        telemetry.addData("Status", "Ready");
        telemetry.update();

        autoDriveTrain.resetEncoders();

        waitForStart();

        if (isStopRequested()) {
            return;
        }

        while (opModeIsActive()) {
            forward = gamepad1.right_stick_y;
            strafe = -gamepad1.left_stick_x;
            rotate = -gamepad1.right_stick_x;

            drive.mecanumEquations(forward, strafe, rotate);

            if (gamepad1.right_bumper) {
                intake.power(1);
            }

            if (gamepad1.left_bumper) {
                intake.power(0);
            }

            if (gamepad2.right_bumper) {
                outtake.power(1);
            }

            if (gamepad2.left_bumper) {
                outtake.power(0);
            }

            if (gamepad2.x) {
                transfer.power(0.5);
            }

            if (gamepad2.a) {
                transfer.power(0);
            }
        }
    }
}