package com.github.snowdream.android.apps.dimensionconverter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class DPIFragment extends Fragment {
    private EditText editText_ldpi = null;
    private CustomTextWatcher textWatcher_ldpi = null;
    private EditText editText_mdpi = null;
    private CustomTextWatcher textWatcher_mdpi = null;
    private EditText editText_tvdpi = null;
    private CustomTextWatcher textWatcher_tvdpi = null;
    private EditText editText_hdpi = null;
    private CustomTextWatcher textWatcher_hdpi = null;
    private EditText editText_xhdpi = null;
    private CustomTextWatcher textWatcher_xhdpi = null;
    private EditText editText_xxhdpi = null;
    private CustomTextWatcher textWatcher_xxhdpi = null;
    private EditText editText_xxxhdpi = null;
    private CustomTextWatcher textWatcher_xxxhdpi = null;


    public DPIFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dpi, container, false);

        editText_ldpi = (EditText) view.findViewById(R.id.editText_ldpi);
        textWatcher_ldpi = new CustomTextWatcher(editText_ldpi, DPI.LDPI);

        editText_mdpi = (EditText) view.findViewById(R.id.editText_mdpi);
        textWatcher_mdpi = new CustomTextWatcher(editText_mdpi, DPI.MDPI);

        editText_tvdpi = (EditText) view.findViewById(R.id.editText_tvdpi);
        textWatcher_tvdpi = new CustomTextWatcher(editText_tvdpi, DPI.TVDPI);

        editText_hdpi = (EditText) view.findViewById(R.id.editText_hdpi);
        textWatcher_hdpi =new CustomTextWatcher(editText_hdpi, DPI.HDPI);

        editText_xhdpi = (EditText) view.findViewById(R.id.editText_xhdpi);
        textWatcher_xhdpi= new CustomTextWatcher(editText_xhdpi, DPI.XHDPI);

        editText_xxhdpi = (EditText) view.findViewById(R.id.editText_xxhdpi);
        textWatcher_xxhdpi = new CustomTextWatcher(editText_xxhdpi, DPI.XXHDPI);

        editText_xxxhdpi = (EditText) view.findViewById(R.id.editText_xxxhdpi);
        textWatcher_xxxhdpi =new CustomTextWatcher(editText_xxxhdpi, DPI.XXXHDPI);

        initUI();
        return view;
    }

    private void registerTextChangedListeners(){
        editText_ldpi.addTextChangedListener(textWatcher_ldpi);
        editText_mdpi.addTextChangedListener(textWatcher_mdpi);
        editText_tvdpi.addTextChangedListener(textWatcher_tvdpi);
        editText_hdpi.addTextChangedListener(textWatcher_hdpi);
        editText_xhdpi.addTextChangedListener(textWatcher_xhdpi);
        editText_xxhdpi.addTextChangedListener(textWatcher_xxhdpi);
        editText_xxxhdpi.addTextChangedListener(textWatcher_xxxhdpi);
    }

    private void unregisterTextChangedListeners(){
        editText_ldpi.removeTextChangedListener(textWatcher_ldpi);
        editText_mdpi.removeTextChangedListener(textWatcher_mdpi);
        editText_tvdpi.removeTextChangedListener(textWatcher_tvdpi);
        editText_hdpi.removeTextChangedListener(textWatcher_hdpi);
        editText_xhdpi.removeTextChangedListener(textWatcher_xhdpi);
        editText_xxhdpi.removeTextChangedListener(textWatcher_xxhdpi);
        editText_xxxhdpi.removeTextChangedListener(textWatcher_xxxhdpi);
    }

    private void initUI(){
        unregisterTextChangedListeners();;

        editText_ldpi.setText("");
        editText_mdpi.setText("");
        editText_tvdpi.setText("");
        editText_hdpi.setText("");
        editText_xhdpi.setText("");
        editText_xxhdpi.setText("");
        editText_xxxhdpi.setText("");

        registerTextChangedListeners();
    }

    private class CustomTextWatcher implements TextWatcher {
        private DPI dpi;
        private EditText editText;

        private CustomTextWatcher() {
        }

        public CustomTextWatcher(EditText editText, DPI dpi) {
            this.dpi = dpi;
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

            caculateDPI(editText, s.toString(), dpi);
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s != null){
                caculateDPI(editText,s.toString(),dpi);
            }
        }
    }


    private void caculateDPI(EditText editText, String str, DPI dpi) {
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

        Float mdpi = value / dpi.getRatio();

        if (editText !=editText_ldpi ) {
            editText_ldpi.setText(mdpi * DPI.LDPI.getRatio() + "");
        }

        if (editText !=editText_mdpi ) {
            editText_mdpi.setText(mdpi * DPI.MDPI.getRatio() + "");
        }

        if (editText !=editText_tvdpi ) {
            editText_tvdpi.setText(mdpi*DPI.TVDPI.getRatio()+"");
        }

        if (editText !=editText_hdpi ) {
            editText_hdpi.setText(mdpi * DPI.HDPI.getRatio() + "");
        }

        if (editText !=editText_xhdpi ) {
            editText_xhdpi.setText(mdpi * DPI.XHDPI.getRatio() + "");
        }

        if (editText !=editText_xxhdpi ) {
            editText_xxhdpi.setText(mdpi*DPI.XXHDPI.getRatio()+"");
        }

        if (editText !=editText_xxxhdpi ) {
            editText_xxxhdpi.setText(mdpi * DPI.XXXHDPI.getRatio() + "");
        }

        registerTextChangedListeners();
    }

}
