package jiyun.com.lovepet.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jiyun.com.lovepet.R;

/**
 * A simple {@link Fragment} subclass.
 * 待评价
 */
public class WaitConfirmFragment extends Fragment {
    public WaitConfirmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wait_confirm, container, false);
    }

}
