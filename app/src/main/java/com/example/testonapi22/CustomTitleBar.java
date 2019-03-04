package com.example.testonapi22;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CustomTitleBar extends RelativeLayout {

    private Button titleBarLeftBtn;
    private Button titleBarRightBtn;
    private TextView titleBarText;


    public CustomTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_bar,this,true);
        titleBarLeftBtn = findViewById(R.id.title_bar_left);
        titleBarRightBtn = findViewById(R.id.title_bar_right);
        titleBarText = findViewById(R.id.title_bar_text);

        TypedArray attribues = context.obtainStyledAttributes(attrs,R.styleable.CustomTitleBar);
        if(attribues != null){
            int titleBarBackGround = attribues.getResourceId(R.styleable.CustomTitleBar_title_background_color, Color.GREEN);
            setBackgroundResource(titleBarBackGround);

            //左边按钮visible
            boolean leftButtonVisible = attribues.getBoolean(R.styleable.CustomTitleBar_left_button_vision,true);
            if(leftButtonVisible){
                titleBarLeftBtn.setVisibility(View.VISIBLE);
            }else{
                titleBarLeftBtn.setVisibility(View.INVISIBLE);
            }
            //左边按钮文字
            String leftButtonText = attribues.getString(R.styleable.CustomTitleBar_left_button_text);
            if(!TextUtils.isEmpty(leftButtonText)){
                titleBarLeftBtn.setText(leftButtonText);
                int leftButtonTextColor = attribues.getColor(R.styleable.CustomTitleBar_left_button_text_color,Color.WHITE);
                titleBarLeftBtn.setTextColor(leftButtonTextColor);
            }
            //左边按钮图片（要么图片，要么文字）
            int leftButtonDrawable = attribues.getResourceId(R.styleable.CustomTitleBar_left_button_drawable,R.mipmap.ic_launcher);
            if(leftButtonDrawable != -1){
                titleBarLeftBtn.setCompoundDrawablesWithIntrinsicBounds(leftButtonDrawable,0,0,0);
            }

            //标题
            //标题是否显示图片
            int titleTextDrawable = attribues.getResourceId(R.styleable.CustomTitleBar_title_text_drawable, -1);
            if (titleTextDrawable != -1) {
                titleBarText.setBackgroundResource(titleTextDrawable);
            } else {
                //如果不是图片标题 则获取文字标题
                String titleText = attribues.getString(R.styleable.CustomTitleBar_title_text);
                if (!TextUtils.isEmpty(titleText)) {
                    titleBarText.setText(titleText);
                }
                //获取标题显示颜色
                int titleTextColor = attribues.getColor(R.styleable.CustomTitleBar_title_text_color, Color.WHITE);
                titleBarText.setTextColor(titleTextColor);
            }

            //右边按钮visible
            boolean rightButtonVisible = attribues.getBoolean(R.styleable.CustomTitleBar_left_button_vision,true);
            if(rightButtonVisible){
                titleBarRightBtn.setVisibility(View.VISIBLE);
            }else{
                titleBarRightBtn.setVisibility(View.INVISIBLE);
            }
            //右边按钮文字
            String rightButtonText = attribues.getString(R.styleable.CustomTitleBar_right_button_text);
            if(!TextUtils.isEmpty(rightButtonText)){
                titleBarRightBtn.setText(rightButtonText);
                int rightButtonTextColor = attribues.getColor(R.styleable.CustomTitleBar_right_button_text_color,Color.WHITE);
                titleBarRightBtn.setTextColor(rightButtonTextColor);
            }
            //右边按钮图片（要么图片，要么文字）
            int rightButtonDrawable = attribues.getResourceId(R.styleable.CustomTitleBar_right_button_drawable,R.mipmap.ic_launcher);
            if(rightButtonDrawable != -1){
                titleBarRightBtn.setCompoundDrawablesWithIntrinsicBounds(0,0,rightButtonDrawable,0);
            }
            attribues.recycle();    //一定要回收attribute
        }
    }

    public void setTitleClickListener(OnClickListener onClickListener){
        if(onClickListener != null){
            titleBarLeftBtn.setOnClickListener(onClickListener);
            titleBarRightBtn.setOnClickListener(onClickListener);
        }
    }

    public Button getTitleBarLeftBtn() {
        return titleBarLeftBtn;
    }

    public Button getTitleBarRightBtn() {
        return titleBarRightBtn;
    }

    public TextView getTitleBarText() {
        return titleBarText;
    }
}
