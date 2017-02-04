package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.ftccommunity.ftcxtensible.robot.RobotContext;
import org.ftccommunity.ftcxtensible.xsimplify.SimpleOpMode;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Created by mhsrobotics on 9/24/16.
 */
@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class DriverControl extends SimpleOpMode {
    private DcMotor FrontRight;
    private DcMotor FrontLeft;
    private DcMotor BackRight;
    private DcMotor BackLeft;
    private DcMotor ball;

    double fr;
    double fl;
    double br;
    double bl;
    double power;
    double suck;
    double blow;
    

    //Naming the DcMotors to be recognized the code

    @Override
    public void init(RobotContext ctx) throws Exception {
        FrontRight=hardwareMap.get("FrontRight");
        FrontLeft= hardwareMap.get("FrontLeft");
        BackRight= hardwareMap.get("BackRight");
        BackLeft= hardwareMap.get("BackLeft");
        ball= hardwareMap.get("Ball");



     //Renaming the Variables for the phones to be able to figure out which ports on the robot are responsible for which variable

       // FrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
       // BackLeft.setDirection(DcMotorSimple.Direction.REVERSE);


        //flipping the mirrored motors directions so all motors move in one direction when an input to move the robot forward is applied




    }

    @Override
    public void loop(RobotContext ctx) throws Exception {
//Modular holonomic drive purposely modular to be flexible

        if (gamepad1.isLeftBumperPressed()){

            power = 0.25;


        }
        else {
            power = 1.0;
        }



        double gamepad1LeftY = gamepad1.leftJoystick.Y() * power;
        double gamepad1LeftX = -gamepad1.leftJoystick.X() * power;
        double gamepad1RightX = gamepad1.rightJoystick.X() * power;

        // holonomic formulas

        double fl = gamepad1LeftY - gamepad1LeftX + gamepad1RightX;
        double fr = -gamepad1LeftY - gamepad1LeftX + gamepad1RightX;
        double br = gamepad1LeftY + gamepad1LeftX + gamepad1RightX;
        double bl = -gamepad1LeftY + gamepad1LeftX + gamepad1RightX;


        // write the values to the motors
        FrontRight.setPower(fl);
        FrontLeft.setPower(fr);
        BackLeft.setPower(bl);
        BackRight.setPower(br);

        suck = gamepad1.getRightTrigger();
        blow = -gamepad1.getLeftTrigger();

        ball.setPower(suck + blow);

		/*
		 * Telemetry for debugging
		 */


    }



    }



