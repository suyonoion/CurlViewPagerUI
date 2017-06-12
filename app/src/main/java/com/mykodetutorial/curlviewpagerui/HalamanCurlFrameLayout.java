package com.mykodetutorial.curlviewpagerui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class HalamanCurlFrameLayout extends FrameLayout implements HalamanCurl {

    private float mCurl;

    private Path mClipPath;

    private Path mCurlPath;

    private Paint mCurlStrokePaint;

    private Paint mCurlFillPaint;

    private PointF mBottomFold = new PointF();

    private PointF mTopFold = new PointF();

    private PointF mBottomFoldTip = new PointF();

    private PointF mTopFoldTip = new PointF();

    int color_belakang = ContextCompat.getColor(getContext(),setResource("warna_belakang","color"));
    int color_bingkai_belakang = ContextCompat.getColor(getContext(),setResource("warna_bingkai_belakang","color"));

    public HalamanCurlFrameLayout(Context context) {
        super(context);
        init();
    }

    public HalamanCurlFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HalamanCurlFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)
    public HalamanCurlFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {

        if (Build.VERSION.SDK_INT < 18) {  // clipPath() not supported in hardware accel
            setLayerType(LAYER_TYPE_SOFTWARE, null);
        }

        mCurlStrokePaint = new Paint();
        mCurlStrokePaint.setStyle(Paint.Style.STROKE);
        mCurlStrokePaint.setStrokeWidth(5.0F);
        mCurlStrokePaint.setColor(color_bingkai_belakang);

        mCurlFillPaint = new Paint();
        mCurlFillPaint.setStyle(Paint.Style.FILL);
        mCurlFillPaint.setColor(color_belakang);

        mCurlPath = new Path();

        mClipPath = new Path();
    }

    @Override
    public void setCurlFactor(float curl) {
        mCurl = curl;
        boolean foldingPage = curl < 0;
        if (curl < 0) curl += 1;

        int w = getWidth();
        int h = getHeight();

        mBottomFold.x = w * curl;
        mBottomFold.y = h;

        if (mBottomFold.x > w / 2) {
            // fold is on right edge
            mTopFold.x = w;
            mTopFold.y = h - (w - mBottomFold.x) * h / mBottomFold.x;
        } else {
            // fold is on top edge
            mTopFold.x = 2 * mBottomFold.x;
            mTopFold.y = 0;
        }

        // this is the angle of the fold
        double angle = Math.atan((h - mTopFold.y) / (mTopFold.x - mBottomFold.x));

        // multiple fold angle by 2 to get the angle of the right page edge
        double cosFactor = Math.cos(2 * angle);
        double sinFactor = Math.sin(2 * angle);

        float foldWidth = w - mBottomFold.x;
        mBottomFoldTip.x = (float) (mBottomFold.x + foldWidth * cosFactor);
        mBottomFoldTip.y = (float) (h - foldWidth * sinFactor);

        if (mBottomFold.x > w / 2) {
            mTopFoldTip.x = mTopFold.x;
            mTopFoldTip.y = mTopFold.y;
        } else {
            mTopFoldTip.x = (float) (mTopFold.x + (w - mTopFold.x) * cosFactor);
            mTopFoldTip.y = (float) - (sinFactor * (w - mTopFold.x));
        }

        mClipPath.reset();
        if (foldingPage) {
            // clip to show the page disappearing as it's folded
            mClipPath.moveTo(0, 0);
            if (mTopFold.y != 0) {
                mClipPath.lineTo(w, 0);
            }
            mClipPath.lineTo(mTopFold.x, mTopFold.y);
            mClipPath.lineTo(mBottomFold.x, mBottomFold.y);
            mClipPath.lineTo(0, h);
        } else {
            // clip to show the page underneath revealing
            mClipPath.moveTo(w, h);
            if (mTopFold.y == 0) {
                mClipPath.lineTo(w, 0);
            }
            mClipPath.lineTo(mTopFold.x, mTopFold.y);
            mClipPath.lineTo(mBottomFold.x, mBottomFold.y);
        }
        mClipPath.close();

        mCurlPath.reset();
        mCurlPath.moveTo(mBottomFold.x, mBottomFold.y);
        mCurlPath.lineTo(mBottomFoldTip.x, mBottomFoldTip.y);
        mCurlPath.lineTo(mTopFoldTip.x, mTopFoldTip.y);
        mCurlPath.lineTo(mTopFold.x, mTopFold.y);
        mCurlPath.close();

        invalidate();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        if (mCurl != 0 && mCurl != 1 && mCurl != -1) {
            canvas.clipPath(mClipPath);
        }
        super.dispatchDraw(canvas);
        canvas.restore();
        if (mCurl < 0) {
            canvas.drawPath(mCurlPath, mCurlFillPaint);
            canvas.drawPath(mCurlPath, mCurlStrokePaint);
        }
    }

    public int setResource(String name, String Type)
    {
        return getContext().getResources().getIdentifier(name, Type, getContext().getPackageName());
    }
}

