package org.firstinspires.ftc.teamcode.Definitions;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Transfer {
    private Transfer transferPos;
    private CRServo servoRot;
        public void initServo(HardwareMap hardwareMap) {
            transferPos = hardwareMap.get(Transfer.class, "Transfer_pos");
            servoRot = hardwareMap.get(CRServo.class, "CRServo_rot");
        }
        public void setTransferPos (double angle)
        {
            transferPos.setTransferPos(angle);
        }

        public void setServoRot (double power)
        {
            servoRot.setPower(power);
        }
}