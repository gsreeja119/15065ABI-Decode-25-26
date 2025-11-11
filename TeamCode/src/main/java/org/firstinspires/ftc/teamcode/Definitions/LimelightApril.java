package org.firstinspires.ftc.teamcode.Definitions;


import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;
@TeleOp
public class LimelightApril extends LinearOpMode

{
    private Limelight3A limelight;

    private IMU imu;

    public void runOpMode()
    {
        limelight = hardwareMap.get(Limelight3A.class,"limelight");
        limelight.pipelineSwitch(8);
    }

    public void waitForStart()
    {
        limelight.start();
    }

}

