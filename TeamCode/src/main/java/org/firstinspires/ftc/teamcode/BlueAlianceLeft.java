
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous
public class BlueAlianceLeft extends LinearOpMode{

    private DcMotor FrontRight;
    private DcMotor FrontLeft;
    private DcMotor BackRight;
    private DcMotor BackLeft;



    @Override
    public void runOpMode() throws InterruptedException {



        FrontRight= (DcMotor) hardwareMap.get("FrontRight");
        FrontLeft= (DcMotor) hardwareMap.get("FrontLeft");
        BackRight= (DcMotor) hardwareMap.get("BackRight");
        BackLeft= (DcMotor) hardwareMap.get("BackLeft");


        FrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        BackRight.setDirection(DcMotorSimple.Direction.REVERSE);
















    }
}
