package org.firstinspires.ftc.teamcode.Definitions;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Servo
{
    private Servo servoPos;
    private CRServo servoRot;
        public void initServo(HardwareMap hardwareMap)
        {
            servoPos = hardwareMap.get(Servo.class, "servo_pos");
            servoRot = hardwareMap.get(CRServo.class, "CRServo_rot");
        }

        public void setServoPos ( double angle)
        {
            servoPos.setServoPos(angle);
        }

        public void setServoRot ( double power)
        {
            servoRot.setPower(power);
        }



}
