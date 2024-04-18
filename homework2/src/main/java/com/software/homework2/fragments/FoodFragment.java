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
import com.software.homework2.adapters.FoodAdapter;
import com.software.homework2.entity.Food;

import java.util.List;

public class FoodFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food,null);

        GridView gv_food = view.findViewById(R.id.gv_food);

        List<Food>foodList = Food.getFoodList();

        FoodAdapter adapter = new FoodAdapter(
                this.getContext(),
                R.layout.item_food,
                foodList
        );

        gv_food.setAdapter(adapter);

        return view;
    }
}
