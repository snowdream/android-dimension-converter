/*
 * Copyright (C) 2014 Snowdream Mobile <yanghui1986527@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.snowdream.android.apps.dimensionconverter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.*;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    private TextView textView_Dimension = null;
    private TextView textView_Dpi = null;
    private DimensionFragment dimensionFragment = null;
    private DPIFragment dpiFragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_Dimension = (TextView)findViewById(R.id.textView_dimension);
        textView_Dpi = (TextView)findViewById(R.id.textView_dpi);

        dimensionFragment = new DimensionFragment();
        dpiFragment = new DPIFragment();

        if (savedInstanceState == null) {
            textView_Dimension.setBackgroundResource(R.drawable.v4_idle_tap_item_bg_hl);
            textView_Dpi.setBackgroundResource(R.drawable.v3_btn_transprent_bg);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, dimensionFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        }
    }

    public void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.textView_dimension:
                textView_Dimension.setBackgroundResource(R.drawable.v4_idle_tap_item_bg_hl);
                textView_Dpi.setBackgroundResource(R.drawable.v3_btn_transprent_bg);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, dimensionFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
                break;
            case R.id.textView_dpi:
                textView_Dimension.setBackgroundResource(R.drawable.v3_btn_transprent_bg);
                textView_Dpi.setBackgroundResource(R.drawable.v4_idle_tap_item_bg_hl);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, dpiFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
                break;
            default:
                break;
        }
    }













    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_dimension, container, false);
            return rootView;
        }
    }

}
