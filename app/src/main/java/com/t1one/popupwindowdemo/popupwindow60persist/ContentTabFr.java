package com.t1one.popupwindowdemo.popupwindow60persist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Administrator on 2017/4/6.
 */

public class ContentTabFr extends Fragment {
    public SelectCityPop mPop;
    private Button mShowPopupWindow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, null);
        mShowPopupWindow = (Button) view.findViewById(R.id.show_popup_window);
        mShowPopupWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopWindow();
            }
        });
        return view;
    }

    public void showPopWindow() {
        if (mPop == null) {
            mPop = new SelectCityPop(getActivity(), mShowPopupWindow);
            mPop.showPopwindow();
        } else {
            mPop.getWindow().showAsDropDown(mShowPopupWindow);
        }
    }
}
