package org.firstinspires.ftc.teamcode.OpModes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Definitions.DriveTrain;
import org.firstinspires.ftc.teamcode.Definitions.Indexer;
import org.firstinspires.ftc.teamcode.Definitions.Intake;
import org.firstinspires.ftc.teamcode.Definitions.Intake2;
import org.firstinspires.ftc.teamcode.Definitions.Outtake;
import org.firstinspires.ftc.teamcode.Definitions.Transfer;

@TeleOp
public class MainTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DriveTrain driveTrain = new DriveTrain();
        Indexer indexer = new Indexer();
        Intake intake = new Intake();
        Intake2 intake2 = new Intake2();
        Outtake outtake = new Outtake();
        Transfer transfer = new Transfer();

        driveTrain.initDriveTrain(hardwareMap);
        indexer.initIndexer(hardwareMap);
        intake.initIntake(hardwareMap);
        intake2.initIntake2(hardwareMap);
        outtake.initOuttake(hardwareMap);
        transfer.initTransfer(hardwareMap);

        double forward, strafe, rotate;

        waitForStart();

        if (isStopRequested()) {
            return;
        }

        while (opModeIsActive()) {
            forward = -gamepad1.right_stick_y;
            strafe = gamepad1.left_stick_x;
            rotate = -gamepad1.right_stick_x;


            driveTrain.mecanumEquations(forward, strafe, rotate);


            if (gamepad1.right_bumper) {
                intake.setIntake(-1150);
            }
            else {
                intake.setIntake(0);
            }

            if (gamepad1.dpad_down) {
                intake.setIntake(1150);
            }
            else {
                intake.setIntake(0);
            }

            if (gamepad1.right_bumper) {
                intake2.setIntake2(1600);
            }
            else {
                intake2.setIntake2(0);
            }

            if (gamepad1.dpad_down) {
                intake2.setIntake2(-1600);
            }
            else {
                intake2.setIntake2(0);
            }


            if (gamepad2.right_trigger > 0.5) {
                indexer.setIndexer(200);
            }
            else {
                indexer.setIndexer(0);
            }


            if (gamepad2.a) {
                transfer.servoPosition(0.4)   ;
            }
            else {
                transfer.servoPosition(0.28);
            }


            if (gamepad2.right_bumper) {
                outtake.setOuttake(6000);
            }
            else {
                outtake.setOuttake(0);
            }

            if (gamepad2.left_bumper) {
                outtake.setOuttake(-300);
            }
            else {
                outtake.setOuttake(0);
            }
         }
    }
}
