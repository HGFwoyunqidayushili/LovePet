package jiyun.com.lovepet.ui.order.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jiyun.com.lovepet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllorderFragment extends Fragment {


    public AllorderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_allorder, container, false);
    }

}
