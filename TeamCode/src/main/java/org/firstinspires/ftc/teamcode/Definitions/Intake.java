package org.firstinspires.ftc.teamcode.Definitions;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    public DcMotorEx intakeMotor;

    public void initIntake(HardwareMap intake) {
        intakeMotor = intake.get(DcMotorEx.class, "Intake");
        intakeMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        intakeMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);
    }
    public void setIntake(double velocity) {
        intakeMotor.setVelocity(velocity);
    }
}