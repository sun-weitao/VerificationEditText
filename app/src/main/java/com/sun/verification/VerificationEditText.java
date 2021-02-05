package com.sun.verification;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.RequiresApi;

@SuppressLint("AppCompatCustomView")
public class VerificationEditText extends EditText {

    private int textLength = 0;
    private int textCount;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public VerificationEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.VerificationEditText);
        textCount = a.getInteger(R.styleable.VerificationEditText_textCount, 5);

        setCursorVisible(false);
        setSelected(true);
        setBackground(getResources().getDrawable(R.drawable.bg_border));
        setGravity(Gravity.CENTER_VERTICAL);
        setTextColor(getResources().getColor(android.R.color.transparent));
        setInputType(InputType.TYPE_CLASS_NUMBER);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(textCount)});

    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#d3d3d3"));
        paint.setStrokeWidth(1);

        for (int i = 1; i < textCount; i++) {
            int x = (width / textCount) * i;
            canvas.drawLine(x, 0, x, height, paint);
        }
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(50);
        paint.setStrokeCap(Paint.Cap.ROUND);
        for (int i = 0; i < textLength; i++) {
            int x = (width / textCount) * i;
            x = x + (width / textCount) / 2;
            int y = height / 2;
            canvas.drawPoint(x, y, paint);
        }
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        textLength = text.length();
    }
}
