package org.firstinspires.ftc.teamcode.OpModes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Definitions.DriveTrain;
import org.firstinspires.ftc.teamcode.Definitions.Intake;

@TeleOp(name = "MainTeleOp")
public class MainTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DriveTrain drive = new DriveTrain();
        drive.initDriveTrain(hardwareMap);
        Intake intake = new Intake();
        intake.initIntake(hardwareMap);

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

            drive.mecanumEquations(forward,strafe,rotate);

            if (gamepad2.right_bumper) {
                intakeMotor.setPower(1);
            }
        }
    }
    private DcMotor intakeMotor;
}
