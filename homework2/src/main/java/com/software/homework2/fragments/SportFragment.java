package com.software.homework2.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.software.homework2.R;
import com.software.homework2.adapters.SportAdapter;
import com.software.homework2.entity.Sport;

import java.util.List;

public class SportFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sport,null);

        GridView gv_sport = view.findViewById(R.id.gv_sport);

        List<Sport>sportList = Sport.getSportList();

        SportAdapter adapter = new SportAdapter(
                this.getContext(),
                R.layout.item_sport,
                sportList
        );

        gv_sport.setAdapter(adapter);

        return view;
    }
}
