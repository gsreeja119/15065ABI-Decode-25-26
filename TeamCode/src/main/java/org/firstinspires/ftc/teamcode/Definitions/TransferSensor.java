package org.firstinspires.ftc.teamcode.Definitions;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TransferSensor {
    public NormalizedColorSensor transferSensor;

    public enum detectedColor2 {
        PURPLE,
        GREEN,
        UNKNOWN
    }

    public void init2(HardwareMap hardwareMap) {
        transferSensor = hardwareMap.get(NormalizedColorSensor.class, "TransferSensor");
    }

    public detectedColor2 getDetectedColor2(Telemetry telemetry) {
        NormalizedRGBA colors = transferSensor.getNormalizedColors();

        float normGreen2, normRed2, normBlue2;

        normGreen2 = colors.green / colors.alpha;
        normRed2 = colors.red / colors.alpha;
        normBlue2 = colors.red / colors.alpha;

        telemetry.addData("Green", normGreen2);
        telemetry.addData("Red", normRed2);
        telemetry.addData("Blue", normBlue2);

        return detectedColor2.UNKNOWN;
    }
}
