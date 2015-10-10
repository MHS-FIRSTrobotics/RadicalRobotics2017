package org.ftccommunity.ftcxtensible.sensors.camera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.util.Log;

import org.ftccommunity.ftcxtensible.robot.RobotContext;

import java.io.ByteArrayOutputStream;

public class CameraPreviewCallback implements Camera.PreviewCallback {
    private static final String TAG = CameraPreviewCallback.class.getSimpleName();
    private int delay = 100;
    private RobotContext context;

    private long timestamp;

    public CameraPreviewCallback(RobotContext ctx, int captureDelay) {
        context = ctx;
        setDelay(captureDelay);
    }

    @Override
    public void onPreviewFrame(final byte[] data, Camera camera) {
        if (timestamp + getDelay() * 1000 > System.nanoTime()) {
            return;
        }

        if (context.cameraManager() != null && context.cameraManager().getCamera() != null) {
            Camera.Parameters parameters = context.cameraManager().getCamera().getParameters();
            Camera.Size previewSize = parameters.getPreviewSize();
            YuvImage image = new YuvImage(data, parameters.getPreviewFormat(),
                    previewSize.width,
                    parameters.getPreviewSize().height, null);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            image.compressToJpeg(new Rect(0, 0, previewSize.width, previewSize.height), 100, os);

            byte[] jpeg = os.toByteArray();
            try {
                os.close();
                Bitmap bitmap = BitmapFactory.decodeByteArray(jpeg, 0, jpeg.length);
                context.cameraManager().addImage(bitmap);
                timestamp = System.nanoTime();
            } catch (Exception e) {
                Log.e(TAG, e.getLocalizedMessage(), e);
            }
        }
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int milliseconds) {
        this.delay = milliseconds;
    }
}
