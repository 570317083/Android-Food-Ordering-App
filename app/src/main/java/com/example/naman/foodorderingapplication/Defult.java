package com.example.naman.foodorderingapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.naman.foodorderingapplication.R;


public class Defult extends Fragment {
    GridView grid_view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.defult, container, false);

// set a StaggeredGridLayoutManager with 3 number of columns and vertical orientation
        // StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        // grid_view.setAdapter((ListAdapter) staggeredGridLayoutManager); // set LayoutManager to RecyclerView


        GridView gridView = (GridView)view. findViewById(R.id.grid_view);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Intent intent;
                switch (position) {
                    case 0:
                        intent =  new Intent(getActivity(),ccd.class);////in fragment we use get activity in place of mainactivity.this
                        break;
                    case 1:
                        intent= new Intent(getActivity(),mitticafe.class);
                        break;
                    case 2:
                        intent= new Intent(getActivity(),mochacafe.class);
                        break;
                    case 3:
                        intent= new Intent(getActivity(),cafeo2.class) ;
                        break;
                    case 4:
                        intent=new Intent(getActivity(),yolocafe.class);
                        break;
                    case 5:
                        intent=new Intent(getActivity(),buddyscafe.class);
                        break;
                    case 6:
                        intent=new Intent(getActivity(),ChaiKaapi.class);
                        break;
                    case 7:
                        intent=new Intent(getActivity(),BeansCafe.class);
                        break;


                    default:
                        intent=new Intent(getActivity(),Defult.class);
                        break;






                }
                startActivity(intent);




            }
        });


        // Instance of ImageAdapter Class
        gridView.setAdapter((ListAdapter) new DefultImageAdapter(getActivity()));

        return view;



    }
}



