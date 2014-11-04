package com.github.snowdream.android.apps.dimensionconverter;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DimensionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DimensionFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class DimensionFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dimension, container, false);
    }
}
