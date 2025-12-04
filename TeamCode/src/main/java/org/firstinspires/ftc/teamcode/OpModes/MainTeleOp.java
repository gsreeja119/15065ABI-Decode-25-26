package org.firstinspires.ftc.teamcode.OpModes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Definitions.DriveTrain;
import org.firstinspires.ftc.teamcode.Definitions.Intake;
import org.firstinspires.ftc.teamcode.Definitions.Intake2;
import org.firstinspires.ftc.teamcode.Definitions.Outtake;
import org.firstinspires.ftc.teamcode.Definitions.Servo;
import org.firstinspires.ftc.teamcode.Definitions.Transfer;

@TeleOp(name = "MainTeleOp")
public class MainTeleOp extends LinearOpMode
{

    @Override
    public void runOpMode() throws InterruptedException
    {
        Servo servo1 = new Servo();
        servo1.initServo(hardwareMap);
        DriveTrain drive = new DriveTrain();
        drive.initDriveTrain(hardwareMap);
        Intake intake = new Intake();
        intake.initIntake(hardwareMap);
        Intake2 intake2 = new Intake2();
        intake2.initIntake2(hardwareMap);
        Outtake outtake = new Outtake();
        outtake.initOuttake(hardwareMap);
        Transfer transfer = new Transfer();
        transfer.initTransfer(hardwareMap);

        double forward, strafe, rotate;

        telemetry.addData("Status", "Ready");
        telemetry.update();

        waitForStart();

        if (isStopRequested())
        {
            return;
        }

        while (opModeIsActive())
        {
            forward = gamepad1.right_stick_y;
            strafe = -gamepad1.left_stick_x;
            rotate = gamepad1.right_stick_x;

            drive.mecanumEquations(forward, strafe, rotate);

            if (gamepad1.right_bumper) {
                intake.power(-1);
                intake2.power(1);
            }

            if (gamepad1.y) {
                intake.power(1);
                intake2.power(-1);
            }

            if (gamepad1.left_bumper) {
                intake.power(0);
                intake2.power(0);
            }

            if (gamepad2.right_bumper) {
                outtake.power(-1);
            }

            if (gamepad2.left_bumper) {
                outtake.power(0);
            }

            if (gamepad2.y) {
                outtake.power(1);
            }

            if (gamepad2.a)
            {
                servo1.setServoPos(-0.4); // servo angle
                servo1.setServoRot(1.0); // servo power
            }

            if (gamepad2.b)
            {
                servo1.setServoPos(0.4); // servo power
                servo1.setServoRot(-1); // servo power
            }
        }
    }
}