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

    public void setSafePower(DcMotor motor, double targetPower){
        final double SLEW_RATE = 0.2;
        double currentPower = motor.getPower();
        double desiredChange = targetPower - currentPower;
        double limitedChange = Math.max(-SLEW_RATE, Math.min(desiredChange, SLEW_RATE));
        motor.setPower(currentPower += limitedChange);
    }

    /* public void power(double power) {
        intakeMotor2.setPower(power);
    } */
}
