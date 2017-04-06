package com.t1one.popupwindowdemo.popupwindow60persist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;


/**
 * 城市选择Pop
 *
 */
public class SelectCityPop implements OnClickListener {

    private Context mContext;
    private TextView mTextView;
    private PopupWindow window;
    private TextView tv_sh;
    private TextView tv_bj;
    private TextView tv_sz;
    private TextView tv_hz;
    private String text;

    public PopupWindow getWindow() {
        return window;
    }


    public SelectCityPop(Context context, TextView textView) {
        mContext = context;
        mTextView = textView;

    }

    public void showPopwindow() {
        if (window != null && window.isShowing()) {
            return;
        }
        // 利用layoutInflater获得View
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.new_dialog_select_city, null);
        initView(view);
        window = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        window.setFocusable(false);
        // 在参照的View控件下方显示
        window.showAsDropDown(mTextView);
        // popWindow消失监听方法
        window.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
            }
        });
//        window.setTouchInterceptor(new View.OnTouchListener() {
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
//                    window.dismiss();
//                    return true;
//                }
//                return false;
//            }
//        });
    }

    /**
     * 设置view
     *
     * @param view
     */
    private void initView(View view) {
        tv_sh = (TextView) view.findViewById(R.id.tv_sh);
        tv_bj = (TextView) view.findViewById(R.id.tv_bj);
        tv_sz = (TextView) view.findViewById(R.id.tv_sz);
        tv_hz = (TextView) view.findViewById(R.id.tv_hz);
        tv_bj.setOnClickListener(this);
        tv_sh.setOnClickListener(this);
        tv_sz.setOnClickListener(this);
        tv_hz.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_sh:
                text = "上海";
                setViewstate(text);
                break;
            case R.id.tv_bj:
                text = "北京";
                setViewstate(text);
                break;
            case R.id.tv_sz:
                text = "深圳";
                setViewstate(text);
                break;
            case R.id.tv_hz:
                text = "杭州";
                setViewstate(text);
                break;
            default:
                break;
        }
        if (mTextView != null) {
            mTextView.setText(text);
        }
        dismiss();

    }

    private void setViewstate(String city) {
        if (city.equals("北京")) {
            tv_bj.setTextColor(mContext.getResources().getColor(R.color.action_bar_tittle_color
            ));
            tv_sh.setTextColor(mContext.getResources().getColor(R.color.textcolor
            ));
            tv_sz.setTextColor(mContext.getResources().getColor(R.color.textcolor
            ));
            tv_hz.setTextColor(mContext.getResources().getColor(R.color.textcolor
            ));
        } else if (city.equals("深圳")) {
            tv_bj.setTextColor(mContext.getResources().getColor(R.color.textcolor
            ));
            tv_sh.setTextColor(mContext.getResources().getColor(R.color.textcolor
            ));
            tv_sz.setTextColor(mContext.getResources().getColor(R.color.action_bar_tittle_color
            ));
            tv_hz.setTextColor(mContext.getResources().getColor(R.color.textcolor
            ));
        } else if (city.equals("上海")) {
            tv_bj.setTextColor(mContext.getResources().getColor(R.color.textcolor
            ));
            tv_sh.setTextColor(mContext.getResources().getColor(R.color.action_bar_tittle_color
            ));
            tv_sz.setTextColor(mContext.getResources().getColor(R.color.textcolor
            ));
            tv_hz.setTextColor(mContext.getResources().getColor(R.color.textcolor
            ));
        } else if (city.equals("杭州")) {
            tv_bj.setTextColor(mContext.getResources().getColor(R.color.textcolor
            ));
            tv_sh.setTextColor(mContext.getResources().getColor(R.color.textcolor
            ));
            tv_sz.setTextColor(mContext.getResources().getColor(R.color.textcolor
            ));
            tv_hz.setTextColor(mContext.getResources().getColor(R.color.action_bar_tittle_color
            ));
        }
    }

    public void dismiss() {

        if (window != null && window.isShowing()) {
            window.dismiss();
        }

    }


}





