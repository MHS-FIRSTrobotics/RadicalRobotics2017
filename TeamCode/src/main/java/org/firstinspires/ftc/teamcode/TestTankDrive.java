package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareDevice;

import org.ftccommunity.ftcxtensible.robot.RobotContext;
import org.ftccommunity.ftcxtensible.xsimplify.SimpleOpMode;

/**
 * Created by mhsrobotics on 11/15/16.
 */
@TeleOp
public class TestTankDrive extends SimpleOpMode {
    private DcMotor FrontRight;
    private DcMotor FrontLeft;
    private DcMotor BackRight;
    private DcMotor BackLeft;


    @Override
    public void init(RobotContext ctx) throws Exception {
        FrontRight=hardwareMap.get("FrontRight");
        FrontLeft= hardwareMap.get("FrontLeft");
        BackRight= hardwareMap.get("BackRight");
        BackLeft= hardwareMap.get("BackLeft");

        FrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        BackLeft.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    @Override
    public void loop(RobotContext ctx) throws Exception {
        FrontLeft.setPower(-gamepad1.leftJoystick.Y());
        BackLeft.setPower(-gamepad1.leftJoystick.Y());
        BackRight.setPower(-gamepad1.rightJoystick.Y());
        FrontRight.setPower(-gamepad1.rightJoystick.Y());
    }
}
