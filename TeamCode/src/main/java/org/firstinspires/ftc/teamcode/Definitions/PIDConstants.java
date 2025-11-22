package org.firstinspires.ftc.teamcode.Definitions;
import com.acmerobotics.dashboard.config.Config;
import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Configurable
public class PIDConstants {
    public static double Kp = 1.8; //Proportional gain
    public static double Ki = 0.0; // Integral gain
    public static double Kd = 0.031; // Derivative gain
}
