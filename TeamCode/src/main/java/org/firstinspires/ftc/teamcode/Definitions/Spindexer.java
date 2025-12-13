package org.firstinspires.ftc.teamcode.Definitions;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Spindexer {
    private DcMotor Spindexer;

    public void initSpindexer(HardwareMap spindexer) {
        Spindexer = spindexer.get(DcMotor.class, "Spindexer");
        Spindexer.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Spindexer.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void setSafePower(DcMotor motor, double targetPower){
        final double SLEW_RATE = 0.2;
        double currentPower = motor.getPower();
        double desiredChange = targetPower - currentPower;
        double limitedChange = Math.max(-SLEW_RATE, Math.min(desiredChange, SLEW_RATE));
        motor.setPower(currentPower += limitedChange);
    }
}
