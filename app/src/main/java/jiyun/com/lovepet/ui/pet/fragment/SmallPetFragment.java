package jiyun.com.lovepet.ui.pet.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jiyun.com.lovepet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SmallPetFragment extends Fragment {


    public SmallPetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_small_pet, container, false);
    }

}
