package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.pedropathing.ftc.localization.Encoder;
import com.pedropathing.ftc.localization.constants.ThreeWheelConstants;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Constants {
    public static FollowerConstants followerConstants = new FollowerConstants()
            .mass(5)
            .forwardZeroPowerAcceleration(2) //fix later
            .lateralZeroPowerAcceleration(2); //fix later

    public static PathConstraints pathConstraints = new PathConstraints(0.99, 100,
            1, 1);

    public static MecanumConstants driveConstants = new MecanumConstants()
            .maxPower(1)
            .rightFrontMotorName("FrontRightMotor")
            .rightRearMotorName("BackRightMotor")
            .leftRearMotorName("BackLeftMotor")
            .leftFrontMotorName("FrontLeftMotor")
            .leftFrontMotorDirection(DcMotor.Direction.REVERSE)
            .leftRearMotorDirection(DcMotor.Direction.FORWARD)
            .rightFrontMotorDirection(DcMotor.Direction.FORWARD)
            .rightRearMotorDirection(DcMotor.Direction.REVERSE)
            .xVelocity(2) //fix later
            .yVelocity(2); //fix later

    public static ThreeWheelConstants localizerConstants = new ThreeWheelConstants()
            .forwardTicksToInches(.001989436789) //fix later
            .strafeTicksToInches(.001989436789) //fix later
            .turnTicksToInches(.001989436789) //fix later
            .leftPodY(1) //fix later
            .rightPodY(-1) //fix later
            .strafePodX(-2.5)//fix later
            .leftEncoder_HardwareMapName("FrontLeftMotor") //fix later
            .rightEncoder_HardwareMapName("BackRightMotor") //fix later
            .strafeEncoder_HardwareMapName("FrontRightMotor") //fix later
            .leftEncoderDirection(Encoder.FORWARD) //fix later
            .rightEncoderDirection(Encoder.FORWARD) //fix later
            .strafeEncoderDirection(Encoder.REVERSE) //fix later
            .forwardTicksToInches(2) //fix later
            .strafeTicksToInches(2) //fix later
            .turnTicksToInches(2); //fix later


    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pathConstraints(pathConstraints)
                .mecanumDrivetrain(driveConstants)
                .threeWheelLocalizer(localizerConstants)
                .build();
    }
}