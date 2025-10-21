package org.firstinspires.ftc.teamcode.Definitions;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.lang.reflect.Method;
import java.util.List;


public abstract class AutoApril extends LinearOpMode
{
    private static final String WEBCAM_NAME = "Webcam";

    private static final int ID_20 = 20; //Blue
    private static final int ID_21 = 21; //gpp
    private static final int ID_22 = 22; //pgp
    private static final int ID_23 = 23; //ppg
    private static final int ID_24 = 24; //Red

    private static final long TIMEOUT_MS = 4000;

 

}
