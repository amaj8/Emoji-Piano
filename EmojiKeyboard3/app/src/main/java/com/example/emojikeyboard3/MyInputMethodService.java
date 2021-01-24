package com.example.emojikeyboard3;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.text.method.MetaKeyKeyListener;
import android.util.Log;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

import androidx.annotation.MainThread;
import androidx.loader.content.Loader;

import java.util.List;


//package com.example.emojikeyboard2;

public class MyInputMethodService extends InputMethodService
        implements KeyboardView.OnKeyboardActionListener{

    private CustomKeyboardView kv;
    private Keyboard keyboard;

    private boolean caps = false;

    private MediaPlayer mp;
    private final SoundPool sp = new SoundPool(5,AudioManager.STREAM_MUSIC,0);
    private boolean loaded = false;
//    private int sound1, sound2, sound3, sound4, sound5, sound6, sound7, sound8, sound9,sound10;
//        = sp.load(this,R.raw.c2v60,1);

//    private final int sound1 = sp.load(this,R.raw.c3,1);
//    private final int sound2 = sp.load(this,R.raw.d3,1);
//    private final int sound3 = sp.load(this,R.raw.e3,1);
//    private final int sound4 = sp.load(this,R.raw.f3,1);
//    private final int sound5 = sp.load(this,R.raw.g3,1);
//    private final int sound6 = sp.load(this,R.raw.a3,1);
//    private final int sound7 = sp.load(this,R.raw.b3,1);
//    private final int sound8 = sp.load(this,R.raw.c3,1);
//    private final int sound9 = sp.load(this,R.raw.d3,1);
//    private final int sound10 = sp.load(this,R.raw.c3,1);


    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();
//        getCurrentInputConnection().commitText(String.valueOf(Character.toChars(primaryCode)), 1);

//        playClick(primaryCode);
        switch(primaryCode){
            case Keyboard.KEYCODE_DELETE :
                ic.deleteSurroundingText(1, 0);
                break;
            case Keyboard.KEYCODE_SHIFT:
                caps = !caps;
                keyboard.setShifted(caps);
                kv.invalidateAllKeys();
                break;
            case Keyboard.KEYCODE_DONE:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                break;
//            case 1:
//                String code = "0x0001F601"+"0x0001F601";
//                String code = "\uD83D\uDE00\uD83D\uDE00";
//                String code = "\u1F600";
//                Faces f = new Faces();
                /*TODO: put this at the beginning
                  declare all objects in beginning and then call their methods
                  probably have to do a parent child thing coz getEmojis method is same
                  the emojis represented by Strings get changed

                 */
//                String text = f.getEmojis(primaryCode);

//                ic.commitText(String.valueOf(text),1);

//                break;
            default:
//                char code = (char)primaryCode;
//                if(Character.isLetter(code) && caps){
//                    code = Character.toUpperCase(code);
//                }
                Faces f = new Faces();
                String text = f.getEmojis(primaryCode);
                ic.commitText(String.valueOf(text),1);

//                ic.commitText(String.valueOf(Character.toChars(primaryCode)),1);
        }
    }

    @Override
    public void onPress(int primaryCode) {
//        AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
//        am.playSoundEffect(R.raw.c3);
//        float vol = (float)0.5; //This will be half of the default system sound
//        am.playSoundEffect(AudioManager.FX_KEY_CLICK, vol);

//        int sound1, sound2, sound3, sound4, sound5, sound6, sound7, sound8, sound9,sound10;
//////        = sp.load(this,R.raw.c2v60,1);
////
//        sound1 = sound1 = sp.load(this,R.raw.c3,1);
//        sound2 = sp.load(this,R.raw.d3,1);
//        sound3 = sp.load(this,R.raw.e3,1);
//        sound4 = sp.load(this,R.raw.f3,1);
//        sound5 = sp.load(this,R.raw.g3,1);
//        sound6 = sp.load(this,R.raw.a3,1);
//        sound7 = sp.load(this,R.raw.b3,1);
//        sound8 = sp.load(this,R.raw.c4,1);
//        sound9 = sp.load(this,R.raw.d4,1);
//        sound10 = sp.load(this,R.raw.c3,1);
//
//        sp.setOnLoadCompleteListener(new OnLoadCompleteListener() {
//            @Override
//            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
//                loaded = true;
//            }
//        });
//
//
//        switch(primaryCode){
//            case 1: sp.play(sound1,1,1,0,0,1); break;
//            case 2: sp.play(sound2,1,1,0,0,1);  break;
//            case 3: sp.play(sound3,1,1,0,0,1); break;
//            case 4: sp.play(sound4,1,1,0,0,1); break;
//            case 5: sp.play(sound5,1,1,0,0,1); break;
//            case 6: sp.play(sound6,1,1,0,0,1); break;
//            case 7: sp.play(sound7,1,1,0,0,1); break;
//            case 8: sp.play(sound8,1,1,0,0,1); break;
//            case 9: sp.play(sound9,1,1,0,0,1); break;
//            default: sp.play(sound10,1,1,0,0,1); break;
//        }

//        sp.play(soundId,1,1,0,0,1);


////        MediaPlayer mp;
        switch(primaryCode){
            case 1: mp = MediaPlayer.create(getBaseContext(),R.raw.c3); break;
            case 2: mp = MediaPlayer.create(getBaseContext(),R.raw.d3); break;
            case 3: mp = MediaPlayer.create(getBaseContext(),R.raw.e3); break;
            case 4: mp = MediaPlayer.create(getBaseContext(),R.raw.f3); break;
            case 5: mp = MediaPlayer.create(getBaseContext(),R.raw.g3); break;
            case 6: mp = MediaPlayer.create(getBaseContext(),R.raw.a3); break;
            case 7: mp = MediaPlayer.create(getBaseContext(),R.raw.b3); break;
            case 8: mp = MediaPlayer.create(getBaseContext(),R.raw.c4); break;
            case 9: mp = MediaPlayer.create(getBaseContext(),R.raw.d4); break;
            default: mp = MediaPlayer.create(getBaseContext(),R.raw.c3); break;
        }
////        MediaPlayer mp1 =
        mp.start();

    }


    @Override
    public void onRelease(int primaryCode) {
        kv.setPreviewEnabled(false);
//        mp.stop();
//        sp.release();
    }

    @Override
    public void onText(CharSequence text) {
    }

    @Override
    public void swipeDown() {
    }

    @Override
    public void swipeLeft() {
    }

    @Override
    public void swipeRight() {
    }

    @Override
    public void swipeUp() {
    }

    @Override
    public View onCreateInputView() {
        kv = (CustomKeyboardView)getLayoutInflater().inflate(R.layout.keyboard_view, null);
//        kv.setBackgroundResource(R.drawable.piano2);
        keyboard = new Keyboard(this, R.xml.number_pad);
        kv.setKeyboard(keyboard);
        kv.setOnKeyboardActionListener(this);
        return kv;
    }

//    private void onTouchListener(int keyCode){
//        AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
//        float vol = (float)0.5; //This will be half of the default system sound
//        am.playSoundEffect(AudioManager.FX_KEY_CLICK, vol);
////        switch(keyCode){
////            case 1:
////                am.playSoundEffect(AudioManager.FX_KEYPRESS_SPACEBAR);
////                break;
////            case Keyboard.KEYCODE_DONE:
////            case 2:
////                am.playSoundEffect(AudioManager.FX_KEYPRESS_RETURN);
////                break;
////            case Keyboard.KEYCODE_DELETE:
////                am.playSoundEffect(AudioManager.FX_KEYPRESS_DELETE);
////                break;
////            default: am.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD);
////        }
//    }
}

//public class MyInputMethodService extends InputMethodService implements KeyboardView.OnKeyboardActionListener {
//
//    @Override
//    public View onCreateInputView() {
//        // get the KeyboardView and add our Keyboard layout to it
//        KeyboardView keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
//        Keyboard keyboard = new Keyboard(this, R.xml.number_pad);
//        keyboardView.setKeyboard(keyboard);
//        keyboardView.setOnKeyboardActionListener(this);
//        return keyboardView;
//    }
//
//    @Override
//    public void onKey(int primaryCode, int[] keyCodes) {
//
//        InputConnection ic = getCurrentInputConnection();
//        if (ic == null) return;
//        switch (primaryCode) {
//            case Keyboard.KEYCODE_DELETE:
//                CharSequence selectedText = ic.getSelectedText(0);
//                if (TextUtils.isEmpty(selectedText)) {
//                    // no selection, so delete previous character
//                    ic.deleteSurroundingText(1, 0);
//                } else {
//                    // delete the selection
//                    ic.commitText("", 1);
//                }
//                break;
//            default:
//                char code = (char) primaryCode;
//                ic.commitText(String.valueOf(code), 1);
//        }
//    }
//
//    @Override
//    public void onPress(int primaryCode) { }
//
//    @Override
//    public void onRelease(int primaryCode) { }
//
//    @Override
//    public void onText(CharSequence text) { }
//
//    @Override
//    public void swipeLeft() { }
//
//    @Override
//    public void swipeRight() { }
//
//    @Override
//    public void swipeDown() { }
//
//    @Override
//    public void swipeUp() { }
//}