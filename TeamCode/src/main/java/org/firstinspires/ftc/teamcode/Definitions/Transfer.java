package org.firstinspires.ftc.teamcode.Definitions;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Transfer
{
    private DcMotor transferMotor;

    public void initTransfer(HardwareMap transfer)
    {
        transferMotor = transfer.get(DcMotor.class, "TransferMotor");
        transferMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        transferMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void power(double power) {
        transferMotor.setPower(power);
    }
}
