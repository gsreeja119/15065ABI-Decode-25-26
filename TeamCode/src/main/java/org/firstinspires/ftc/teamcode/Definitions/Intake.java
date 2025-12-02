package org.firstinspires.ftc.teamcode.Definitions;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake
{
    private DcMotor intakeMotor;

    public void initIntake(HardwareMap intake)
    {
        intakeMotor = intake.get(DcMotor.class, "IntakeMotor");
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void power(double power)
    {
        intakeMotor.setPower(power);
    }
}