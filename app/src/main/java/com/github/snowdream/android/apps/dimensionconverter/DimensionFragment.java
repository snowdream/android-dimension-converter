package com.github.snowdream.android.apps.dimensionconverter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.github.snowdream.android.util.Log;


public class DimensionFragment extends Fragment {
    private EditText editText_dp = null;
    private CustomTextWatcher textWatcher_dp = null;
    private EditText editText_dip = null;
    private CustomTextWatcher textWatcher_dip = null;
    private EditText editText_sp = null;
    private CustomTextWatcher textWatcher_sp = null;
    private EditText editText_pt = null;
    private CustomTextWatcher textWatcher_pt = null;
    private EditText editText_px = null;
    private CustomTextWatcher textWatcher_px = null;
    private EditText editText_mm = null;
    private CustomTextWatcher textWatcher_mm = null;
    private EditText editText_in = null;
    private CustomTextWatcher textWatcher_in = null;


    public DimensionFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dimension, container, false);

        editText_dp = (EditText) view.findViewById(R.id.editText_dp);
        textWatcher_dp = new CustomTextWatcher(editText_dp, TypedValue.COMPLEX_UNIT_DIP);

        editText_dip = (EditText) view.findViewById(R.id.editText_dip);
        textWatcher_dip = new CustomTextWatcher(editText_dip, TypedValue.COMPLEX_UNIT_DIP);

        editText_sp = (EditText) view.findViewById(R.id.editText_sp);
        textWatcher_sp = new CustomTextWatcher(editText_sp, TypedValue.COMPLEX_UNIT_SP);

        editText_pt = (EditText) view.findViewById(R.id.editText_pt);
        textWatcher_pt =new CustomTextWatcher(editText_pt, TypedValue.COMPLEX_UNIT_PT);

        editText_px = (EditText) view.findViewById(R.id.editText_px);
        textWatcher_px= new CustomTextWatcher(editText_px, TypedValue.COMPLEX_UNIT_PX);

        editText_mm = (EditText) view.findViewById(R.id.editText_mm);
        textWatcher_mm = new CustomTextWatcher(editText_mm, TypedValue.COMPLEX_UNIT_MM);

        editText_in = (EditText) view.findViewById(R.id.editText_in);
        textWatcher_in =new CustomTextWatcher(editText_in, TypedValue.COMPLEX_UNIT_IN);

        getActivity().setTitle(R.string.title_dimension);

        initUI();
        return view;
    }

    private void registerTextChangedListeners(){
        editText_dp.addTextChangedListener(textWatcher_dp);
        editText_dip.addTextChangedListener(textWatcher_dip);
        editText_sp.addTextChangedListener(textWatcher_sp);
        editText_pt.addTextChangedListener(textWatcher_pt);
        editText_px.addTextChangedListener(textWatcher_px);
        editText_mm.addTextChangedListener(textWatcher_mm);
        editText_in.addTextChangedListener(textWatcher_in);
    }

    private void unregisterTextChangedListeners(){
        editText_dp.removeTextChangedListener(textWatcher_dp);
        editText_dip.removeTextChangedListener(textWatcher_dip);
        editText_sp.removeTextChangedListener(textWatcher_sp);
        editText_pt.removeTextChangedListener(textWatcher_pt);
        editText_px.removeTextChangedListener(textWatcher_px);
        editText_mm.removeTextChangedListener(textWatcher_mm);
        editText_in.removeTextChangedListener(textWatcher_in);
    }

    private void initUI(){
        unregisterTextChangedListeners();;

        editText_dp.setText("");
        editText_dip.setText("");
        editText_sp.setText("");
        editText_pt.setText("");
        editText_px.setText("");
        editText_mm.setText("");
        editText_in.setText("");

        registerTextChangedListeners();
    }

    private class CustomTextWatcher implements TextWatcher {
        private int unit;
        private EditText editText;

        private CustomTextWatcher() {
        }

        public CustomTextWatcher(EditText editText, int unit) {
            this.unit = unit;
            this.editText = editText;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (TextUtils.isEmpty(s)) {
                initUI();
                return;
            }

            caculateDimension(editText, s.toString(), unit);
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s != null){
                caculateDimension(editText, s.toString(), unit);
            }
        }
    }


    private void caculateDimension(EditText editText, String str, int unit) {
        if (TextUtils.isEmpty(str) || editText == null) {
            return;
        }
        unregisterTextChangedListeners();;
        Float value = 0f;
        try {
            value = Float.parseFloat(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);

        Log.i("DisplayMetrics: "+ metrics);
        Float pxvalue = TypedValue.applyDimension(unit,value,metrics);

        if (editText !=editText_dp ) {
            editText_dp.setText(pxvalue/metrics.density + "");
        }

        if (editText !=editText_dip ) {
            editText_dip.setText(pxvalue/metrics.density + "");
        }

        if (editText !=editText_sp ) {
            editText_sp.setText(pxvalue/metrics.scaledDensity+"");
        }

        if (editText !=editText_pt ) {
            editText_pt.setText((pxvalue * 72)/metrics.xdpi  + "");
        }

        if (editText !=editText_px ) {
            editText_px.setText(pxvalue  + "");
        }

        if (editText !=editText_mm ) {
            editText_mm.setText((pxvalue * 25.4f)/metrics.xdpi+"");
        }

        if (editText !=editText_in ) {
            editText_in.setText(pxvalue/metrics.xdpi  + "");
        }

        registerTextChangedListeners();
    }

}
