package com.t1one.popupwindowdemo.popupwindow60persist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SelectCityPop mPop;
    private Button mShowPopupWindow;
    private long firstTime;
    private Button mOpenFragment;
    private ContentTabFr contentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowPopupWindow = (Button) findViewById(R.id.show_popup_window);
        mShowPopupWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopWindow();
            }
        });
        mOpenFragment = (Button) findViewById(R.id.open_fragment);
        mOpenFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFragment();
            }
        });
    }

    public void openFragment() {
        contentFragment = new ContentTabFr();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main, contentFragment, "CONTENT")
                .commit();
    }

    public void showPopWindow() {
        if (mPop == null) {
            mPop = new SelectCityPop(this, mShowPopupWindow);
            mPop.showPopwindow();
        } else {
            mPop.getWindow().showAsDropDown(mShowPopupWindow);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPop != null) {
            mPop.getWindow().dismiss();
        }
        if (contentFragment.mPop != null) {
            contentFragment.mPop.getWindow().dismiss();
        }
    }
    //这个是关键，让pop显示的时候其他都不可点击
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (mPop != null && mPop.getWindow().isShowing()) {
            return false;
        }
        if (contentFragment != null && contentFragment.mPop != null && contentFragment.mPop.getWindow().isShowing()) {
            return false;
        }
        return super.dispatchTouchEvent(event);
    }

    /**
     * 退出程序
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {// 如果两次按键时间间隔大于2000毫秒，则不退出
                Toast.makeText(this, "再按一次可退出程序",
                        Toast.LENGTH_SHORT).show();
                firstTime = secondTime;// 更新firstTime
                return true;
            } else {
                finish();
            }
        }
        return super.onKeyUp(keyCode, event);
    }
}
