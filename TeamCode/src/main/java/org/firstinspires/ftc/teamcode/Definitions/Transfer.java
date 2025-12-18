package org.firstinspires.ftc.teamcode.Definitions;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Transfer {
    public Servo transfer;

    public void initServo(HardwareMap hardwareMap) {
        transfer = hardwareMap.get(Servo.class, "Transfer");
    }
}

