
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class BeaconRed extends LinearOpMode{

    private DcMotor FrontRight;
    private DcMotor FrontLeft;
    private DcMotor BackRight;
    private DcMotor BackLeft;
    private Servo Beacon;
    private Servo bd;
    private ColorSensor colorSensor;

    private DcMotor launcher;








    @Override
    public void runOpMode() {


        FrontRight = (DcMotor) hardwareMap.get("FrontRight");
        FrontLeft = (DcMotor) hardwareMap.get("FrontLeft");
        BackRight = (DcMotor) hardwareMap.get("BackRight");
        BackLeft = (DcMotor) hardwareMap.get("BackLeft");
        Beacon = (Servo) hardwareMap.get("Beacon");
        launcher = (DcMotor) hardwareMap.get("Launcher");
        bd = (Servo) hardwareMap.get("BD");
        colorSensor = (ColorSensor) hardwareMap.get("Pha");
        telemetry.addData("Red", colorSensor.red());
        telemetry.addData("Blue", colorSensor.blue());


        FrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        BackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();


        sleep(1000);

        launcher.setPower(1.0);

        sleep(1000);

        launcher.setPower(0.0);
        bd.setPosition(180d);
        sleep(1400);

        launcher.setPower(1.0);

        sleep(1000);

        launcher.setPower(0.0);

        sleep(200);

        FrontLeft.setPower(.5);
        FrontRight.setPower(.5);
        BackLeft.setPower(.5);
        BackRight.setPower(.5);

        sleep(2300);

        FrontLeft.setPower(0.0);
        FrontRight.setPower(0.0);
        BackLeft.setPower(0.0);
        BackRight.setPower(0.0);

        sleep(200);

        FrontLeft.setPower(-0.5);
        FrontRight.setPower(0.5);
        BackLeft.setPower(-0.5);
        BackRight.setPower(0.5);

        sleep(400);

        FrontLeft.setPower(0.0);
        FrontRight.setPower(0.0);
        BackLeft.setPower(0.0);
        BackRight.setPower(0.0);

        sleep(200);

        FrontLeft.setPower(.5);
        FrontRight.setPower(.5);
        BackLeft.setPower(.5);
        BackRight.setPower(.5);

        sleep(1700);

        FrontLeft.setPower(0.0);
        FrontRight.setPower(0.0);
        BackLeft.setPower(0.0);
        BackRight.setPower(0.0);

        sleep(200);

        FrontLeft.setPower(-0.5);
        FrontRight.setPower(0.5);
        BackLeft.setPower(-0.5);
        BackRight.setPower(0.5);

        sleep(200);

        while (opModeIsActive()) {
            if (colorSensor.blue() > colorSensor.red()){
                FrontLeft.setPower(-0.5);
                FrontRight.setPower(0.5);
                BackLeft.setPower(0.5);
                BackRight.setPower(-0.5);

                sleep(500);

                FrontLeft.setPower(0.0);
                FrontRight.setPower(0.0);
                BackLeft.setPower(0.0);
                BackRight.setPower(0.0);

                sleep(200);

                FrontLeft.setPower(.5);
                FrontRight.setPower(.5);
                BackLeft.setPower(.5);
                BackRight.setPower(.5);

                sleep(500);

                FrontLeft.setPower(0.0);
                FrontRight.setPower(0.0);
                BackLeft.setPower(0.0);
                BackRight.setPower(0.0);

                sleep(500);

                FrontLeft.setPower(-.5);
                FrontRight.setPower(-.5);
                BackLeft.setPower(-.5);
                BackRight.setPower(-.5);

                sleep(500);

                FrontLeft.setPower(0.0);
                FrontRight.setPower(0.0);
                BackLeft.setPower(0.0);
                BackRight.setPower(0.0);
                break;

            }

            FrontLeft.setPower(-0.5);
            FrontRight.setPower(0.5);
            BackLeft.setPower(0.5);
            BackRight.setPower(-0.5);
        }







    }
}
