package org.firstinspires.ftc.teamcode.Definitions;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class IntakeSensor {
   public NormalizedColorSensor intakeSensor;

    public enum detectedColor {
        PURPLE,
        GREEN,
        UNKNOWN;
    }

    public void init(HardwareMap hardwareMap) {
        intakeSensor = hardwareMap.get(NormalizedColorSensor.class, "IntakeSensor");
    }

    public detectedColor getDetectedColor(Telemetry telemetry) {
        NormalizedRGBA colors = intakeSensor.getNormalizedColors();

        float normGreen, normRed, normBlue;
        normGreen = colors.green / colors.alpha;
        normRed = colors.red / colors.alpha;
        normBlue = colors.red / colors.alpha;

        telemetry.addData("Green", normGreen);
        telemetry.addData("Red", normRed);
        telemetry.addData("Blue", normBlue);

        return detectedColor.UNKNOWN;
    }
}
