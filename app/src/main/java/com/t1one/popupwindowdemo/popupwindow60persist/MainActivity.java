package com.t1one.popupwindowdemo.popupwindow60persist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SelectCityPop mPop;
    private TextView mShowPopupWindow;
    private long firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowPopupWindow = (TextView)findViewById(R.id.show_popup_window);
        mShowPopupWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopWindow();
            }
        });
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
