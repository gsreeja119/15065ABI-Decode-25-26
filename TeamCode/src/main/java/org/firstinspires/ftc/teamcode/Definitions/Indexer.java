package org.firstinspires.ftc.teamcode.Definitions;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Indexer {
    public DcMotorEx indexer;

    public void initIndexer(HardwareMap Indexer) {
        indexer = Indexer.get(DcMotorEx.class, "Indexer");
        indexer.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        indexer.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }
}
