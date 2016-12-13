package com.fun.d2fun.util;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.fun.d2fun.R;

import butterknife.Bind;

/**
 * Created by ZX on 2016/12/13 0013.
 */

public class DialogUtil {
    @Bind(R.id.dialog_view)
    LinearLayout mLinearLayout;
    private Context mContext;



    public static Dialog createLoadingDialog(Context mContext) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.dialog_loading, null);
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);
        Dialog loadingDialog = new Dialog(mContext, R.style.AppLadingDailog);
        loadingDialog.setCancelable(false);
        loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        return loadingDialog;
    }
}
