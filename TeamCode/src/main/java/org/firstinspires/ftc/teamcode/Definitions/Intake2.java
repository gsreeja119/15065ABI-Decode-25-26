package org.firstinspires.ftc.teamcode.Definitions;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake2 {
    private DcMotor intakeMotor2;

    public void initIntake2 (HardwareMap intake2) {
        intakeMotor2 = intake2.get(DcMotor.class, "Intake2");
        intakeMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void power(double power) {
        intakeMotor2.setPower(power);
    }
}
