package com.example.fragmenthw;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class Fragment1 extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, null);
        return view;
    }

    @Override
    public void onResume() {
        recyclerView = requireView().findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setAdapter(new RecyclerAdapater(this.getActivity()));
        super.onResume();
    }

}
