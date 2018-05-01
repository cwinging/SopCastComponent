package com.laifeng.sopcastsdk.video.effect;

import android.content.Context;
import android.opengl.GLES11Ext;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.FloatBuffer;

import com.laifeng.sopcastsdk.video.GLSLFileUtils;

/**
 * Created by cwing on 2018/1/3.
 */

public class BeautyEffect extends Effect {
    private static final String BEAUTY_EFFECT_VERTEX = "beauty/vertexshader.glsl";
    private static final String BEAUTY_EFFECT_FRAGMENT = "beauty/fragmentshader.glsl";

    private int singleStepOffsetLocation;

    public BeautyEffect(Context context) {
        super();
        String vertexShader = GLSLFileUtils.getFileContextFromAssets(context, BEAUTY_EFFECT_VERTEX);
        String fragmentShader = GLSLFileUtils.getFileContextFromAssets(context, BEAUTY_EFFECT_FRAGMENT);
        super.setShader(vertexShader, fragmentShader);
    }

    @Override
    public void prepare() {
        super.prepare();
        initEffectParams();
    }

    public void initEffectParams()  {
        singleStepOffsetLocation = GLES20.glGetUniformLocation(mProgram, "singleStepOffset");
        GLES20.glUniform2fv(singleStepOffsetLocation, 1, FloatBuffer.wrap(new float[] {2.0f / 90, 2.0f / 160}));
    }
}
