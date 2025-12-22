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

public class Constants
{
    public static FollowerConstants followerConstants = new FollowerConstants()
            .mass(5)
            .forwardZeroPowerAcceleration(2) //fix later
            .lateralZeroPowerAcceleration(2) //fix later
            .useSecondaryTranslationalPIDF(true)
            .useSecondaryHeadingPIDF(true)
            .useSecondaryDrivePIDF(true);

    public static PathConstraints pathConstraints = new PathConstraints(0.99, 100,
            1, 1);

    public static MecanumConstants driveConstants = new MecanumConstants()
            .maxPower(1)
            .rightFrontMotorName("FRMotor")
            .rightRearMotorName("BRMotor")
            .leftRearMotorName("BLMotor")
            .leftFrontMotorName("FLMotor")
            .leftFrontMotorDirection(DcMotor.Direction.REVERSE)
            .leftRearMotorDirection(DcMotor.Direction.REVERSE)
            .rightFrontMotorDirection(DcMotor.Direction.FORWARD)
            .rightRearMotorDirection(DcMotor.Direction.FORWARD)
            .xVelocity(2) //fix later(Automatic Tuners)
            .yVelocity(2); //fix later(Automatic Tuners)

    public static ThreeWheelConstants localizerConstants = new ThreeWheelConstants()
            .forwardTicksToInches(.001989436789) //fix later(Three Wheel)
            .strafeTicksToInches(.001989436789) //fix later(Three Wheel)
            .turnTicksToInches(.001989436789) //fix later(Three Wheel)
            .leftPodY(1) //fix later(Three Wheel)
            .rightPodY(-1) //fix later(Three Wheel)
            .strafePodX(-2.5) //fix later(Three Wheel)
            .leftEncoder_HardwareMapName("FLMotor") //fix later(Three Wheel)
            .rightEncoder_HardwareMapName("BRMotor") //fix later(Three Wheel)
            .strafeEncoder_HardwareMapName("FRMotor") //fix later(Three Wheel)
            .leftEncoderDirection(Encoder.FORWARD) //fix later(Three Wheel)
            .rightEncoderDirection(Encoder.FORWARD) //fix later(Three Wheel)
            .strafeEncoderDirection(Encoder.FORWARD) //fix later(Three Wheel)
            .rightEncoderDirection(Encoder.FORWARD) //fix later(Three Wheel)
            .strafeEncoderDirection(Encoder.REVERSE) //fix later(Three Wheel)
            .forwardTicksToInches(2) //fix later(Three Wheel)
            .strafeTicksToInches(2) //fix later(Three Wheel)
            .turnTicksToInches(2); //fix later(Three Wheel)

    public static Follower createFollower(HardwareMap hardwareMap)
    {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pathConstraints(pathConstraints)
                .mecanumDrivetrain(driveConstants)
                .threeWheelLocalizer(localizerConstants)
                .build();
    }
}