package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp
public class TestTeleOp extends LinearOpMode {
    private DcMotor intakeMotor;

    public void initIntake(HardwareMap intake) {
        intakeMotor = intake.get(DcMotor.class, "IntakeMotor");
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void runOpMode() {
        if (gamepad1.a) {
            intakeMotor.setPower(1);
        }
        else{
            intakeMotor.setPower(0);
        }
    }
}