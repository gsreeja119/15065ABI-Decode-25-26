package org.firstinspires.ftc.teamcode.Definitions;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Transfer {
    public Servo transfer;

    public void initTransfer(HardwareMap hardwareMap) {
        transfer = hardwareMap.get(Servo.class, "Transfer");
    }

    public void servoPosition(double angle) {
        transfer.setPosition(angle);
        transfer.setDirection(Servo.Direction.REVERSE);
    }
}

