
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class BackupCode extends LinearOpMode{

    private DcMotor FrontRight;
    private DcMotor FrontLeft;
    private DcMotor BackRight;
    private DcMotor BackLeft;
    private Servo Beacon;
    private Servo bd;

    private DcMotor launcher;






    @Override
    public void runOpMode() throws InterruptedException {



        FrontRight= (DcMotor) hardwareMap.get("FrontRight");
        FrontLeft= (DcMotor) hardwareMap.get("FrontLeft");
        BackRight= (DcMotor) hardwareMap.get("BackRight");
        BackLeft= (DcMotor) hardwareMap.get("BackLeft");
        Beacon= (Servo) hardwareMap.get("Beacon");
        launcher=(DcMotor) hardwareMap.get("Launcher");
        bd= (Servo) hardwareMap.get("BD");


        FrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        BackRight.setDirection(DcMotorSimple.Direction.REVERSE);



        sleep(1000);

        launcher.setPower(1.0);

        sleep(1000);

        launcher.setPower(0.0);
        bd.setPosition(180d);
        sleep(1400);

        launcher.setPower(1.0);

        sleep(1000);

        launcher.setPower(0.0);























    }
}
