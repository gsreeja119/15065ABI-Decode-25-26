package org.firstinspires.ftc.teamcode.Definitions;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake2 {
    public DcMotorEx intakeMotor2;

    public void initIntake2(HardwareMap intake2) {
        intakeMotor2 = intake2.get(DcMotorEx.class, "Intake2");
        intakeMotor2.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        intakeMotor2.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);
    }
    public void setIntake2(double velocity) {
        intakeMotor2.setVelocity(velocity);
    }
}
