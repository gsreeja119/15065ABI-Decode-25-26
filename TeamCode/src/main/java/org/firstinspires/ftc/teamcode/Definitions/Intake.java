package org.firstinspires.ftc.teamcode.Definitions;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake
{
    private DcMotor intakeMotor;
    private DcMotor intakeMotor2;

    public void initIntake(HardwareMap intake)
    {
        intakeMotor = intake.get(DcMotor.class, "IntakeMotor");
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        intakeMotor2 = intake.get(DcMotor.class, "IntakeMotor2");
        intakeMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void power(double power)
    {
        intakeMotor.setPower(power);
        intakeMotor2.setPower(power);
    }
}