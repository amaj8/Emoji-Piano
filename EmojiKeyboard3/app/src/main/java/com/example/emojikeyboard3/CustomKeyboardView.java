package com.example.emojikeyboard3;
/*
 * Copyright (C) 2011 - Riccardo Ciovati
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
//package it.anddev.tutorial;
//package com.example.emojikeyboard3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.inputmethodservice.Keyboard.Key;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import com.example.emojikeyboard3.R;

import java.util.List;

public class CustomKeyboardView extends KeyboardView {
    private Context context;
    private Keyboard keyboard;

    public CustomKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }
//    public CustomKeyboardView(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//        this.context = context;
//    }


    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

//        Paint paint = new Paint();
//        paint.setTextAlign(Paint.Align.CENTER);
//        paint.setTextSize(28);
//        paint.setColor(Color.LTGRAY);
//
//        List<Key> keys = getKeyboard().getKeys();
//        for(Key key: keys) {
//            if(key.label != null) {
//                if (key.label.equals("\uD83D\uDE00")) {
//                    canvas.drawText("1", key.x + (key.width - 25), key.y + 40, paint);
//                }
//                else{
//                    canvas.drawText("2", key.x + (key.width - 25), key.y + 40, paint);
//                }
////                else if (key.label.equals("💌")) {
////                    canvas.drawText("2", key.x + (key.width - 25), key.y + 40, paint);
////                } else if (key.label.equals("👋")) {
////                    canvas.drawText("3", key.x + (key.width - 25), key.y + 40, paint);
////                } else if (key.label.equals("👶")) {
////                    canvas.drawText("4", key.x + (key.width - 25), key.y + 40, paint);
////                } else if (key.label.equals("😺")) {
////                    canvas.drawText("5", key.x + (key.width - 25), key.y + 40, paint);
////                }
//            }
//
//        }
//    }

        List<Key> keys = this.getKeyboard().getKeys();
        for(Key key: keys){
            Drawable dr;
            switch (key.codes[0]){
                case 1: dr = (Drawable) context.getResources().getDrawable(R.drawable.key1_9); break;
                case 2: dr = (Drawable) context.getResources().getDrawable(R.drawable.key2_9); break;
                case 3:  dr = (Drawable) context.getResources().getDrawable(R.drawable.key3_9); break;
                case 4:  dr = (Drawable) context.getResources().getDrawable(R.drawable.key4_9); break;
                case 5:  dr = (Drawable) context.getResources().getDrawable(R.drawable.key5_9); break;
                case 6:  dr = (Drawable) context.getResources().getDrawable(R.drawable.key6_9); break;
                case 7:  dr = (Drawable) context.getResources().getDrawable(R.drawable.key7_9); break;
                case 8:  dr = (Drawable) context.getResources().getDrawable(R.drawable.key8_9); break;
                case 9:  dr = (Drawable) context.getResources().getDrawable(R.drawable.key9_9); break;
                default: dr = (Drawable) context.getResources().getDrawable(R.drawable.piano_single); break;
            }

            dr.setBounds(key.x , key.y , key.x+ key.width , key.y + key.height);
            dr.draw(canvas);

//            if(key.codes[0] == 1){
////                Log.e("KEY", "Drawing key with code " + key.codes[0]);
//
//                dr.setBounds(key.x , key.y , key.x+ key.width , key.y + key.height);
//                dr.draw(canvas);
//            }
//            else {
//                Drawable dr = (Drawable) context.getResources().getDrawable(R.drawable.piano_single_key_smiley_scaled_9);
//                dr.setBounds(key.x , key.y , key.x+ key.width, key.y + key.height);
//                dr.draw(canvas);
//            }
        }
    }

    public void showWithAnimation(Animation animation) {
        animation.setAnimationListener(new AnimationListener() {


            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setVisibility(View.VISIBLE);
            }
        });

        setAnimation(animation);
    }


}