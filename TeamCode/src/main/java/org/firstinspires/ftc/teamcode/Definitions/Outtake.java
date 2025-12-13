package org.firstinspires.ftc.teamcode.Definitions;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Outtake
{
    private DcMotorEx outtakeMotor;

    public void initOuttake(HardwareMap outtake)
    {
        outtakeMotor = outtake.get(DcMotorEx.class, "Outtake");
        outtakeMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        outtakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        outtakeMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    public void setOuttake(double velocity) {
        outtakeMotor.setVelocity(velocity);
}

    public void setSafePower(DcMotor motor, double targetPower){
        final double SLEW_RATE = 0.2;
        double currentPower = motor.getPower();
        double desiredChange = targetPower - currentPower;
        double limitedChange = Math.max(-SLEW_RATE, Math.min(desiredChange, SLEW_RATE));
        motor.setPower(currentPower += limitedChange);
    }

    /* public void power(double power)
    {
        outtakeMotor.setPower(power);
    } */
}
