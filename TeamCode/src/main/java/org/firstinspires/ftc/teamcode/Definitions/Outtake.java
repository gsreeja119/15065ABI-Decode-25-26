package org.firstinspires.ftc.teamcode.Definitions;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Outtake {
    public DcMotorEx outtakeMotor;

    public void initOuttake(HardwareMap outtake) {
        outtakeMotor = outtake.get(DcMotorEx.class, "Outtake");
        outtakeMotor.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        outtakeMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);
        outtakeMotor.setDirection(DcMotorEx.Direction.REVERSE);
    }

    public void setOuttake(double velocity) {
        outtakeMotor.setVelocity(velocity);
    }
}
