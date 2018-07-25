package org.wysaid.nativePort;

import android.graphics.Bitmap;

/**
 * Created by wangyang on 15/7/30.
 */
public class CGEFFmpegNativeLibrary {
    static {
        NativeLibraryLoader.load();
    }

    //CN: 视频转换+特效可能执行较长的时间， 请置于后台线程运行.
    //EN: Convert video + Filter Effects may take some time, so you'd better put it on another thread.
    public static boolean generateVideoWithFilter(String outputFilename, String inputFilename, String filterConfig, float filterIntensity, Bitmap blendImage, CGENativeLibrary.TextureBlendMode blendMode, float blendIntensity, boolean mute) {

        return nativeGenerateVideoWithFilter(outputFilename, inputFilename, filterConfig, filterIntensity, blendImage, blendMode == null ? 0 : blendMode.ordinal(), blendIntensity, mute);

    }

    public static boolean generateVideoWithFilterMulti(String outputFilename, String inputFilename, String filterConfig, float filterIntensity, Bitmap blendImage, Bitmap blendImage2, CGENativeLibrary.TextureBlendMode blendMode, float blendIntensity, CGENativeLibrary.TextureBlendMode blendMode2, float blendIntensity2, CGENativeLibrary.TextureBlendMode blendMode3, float blendIntensity3, boolean mute) {

        return nativeGenerateVideoWithFilterMulti(outputFilename, inputFilename, filterConfig, filterIntensity, blendImage, blendImage2, blendMode == null ? 0 : blendMode.ordinal(), blendIntensity, blendMode2 == null ? 0 : blendMode2.ordinal(), blendIntensity2, blendMode3 == null ? 0 : blendMode3.ordinal(), blendIntensity3, mute);

    }


    //////////////////////////////////////////

    private static native boolean nativeGenerateVideoWithFilter(String outputFilename, String inputFilename, String filterConfig, float filterIntensity, Bitmap blendImage, int blendMode, float blendIntensity, boolean mute);

    private static native boolean nativeGenerateVideoWithFilterMulti(String outputFilename, String inputFilename, String filterConfig, float filterIntensity, Bitmap blendImage, Bitmap blendImage2, int blendMode, float blendIntensity, int blendMode2, float blendIntensity2, int blendMode3, float blendIntensity3, boolean mute);

    public static native void avRegisterAll();

}
