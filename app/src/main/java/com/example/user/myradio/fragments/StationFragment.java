package com.example.user.myradio.fragments;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.myradio.R;
import com.example.user.myradio.adapters.StationAdapter;
import com.example.user.myradio.services.DataService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StationFragment extends Fragment {
    private static final String ARG_STATION_TYPE = "STATION TYPE";

    private int stationType;

    public static final int STATION_TYPE_FEATURED = 0;
    public static final int STATION_TYPE_RECENT = 1;
    public static final int STATION_TYPE_PARTY = 2;

    public StationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param stationType Staion type
     * @return A new instance of fragment StationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StationFragment newInstance(int stationType) {
        StationFragment fragment = new StationFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STATION_TYPE, stationType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stationType = getArguments().getInt(ARG_STATION_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_station, container, false);

        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recyclerinstation);
        recyclerView.setHasFixedSize(true);

        StationAdapter adapter;

        if(stationType == STATION_TYPE_FEATURED)
        {
            adapter = new StationAdapter(DataService.getInstance().getFeaturedStations());
        }
        else if(stationType == STATION_TYPE_RECENT)
        {
            adapter = new StationAdapter(DataService.getInstance().getRecentStations());
        }
        else
        {
            adapter = new StationAdapter(DataService.getInstance().getPartyStations());
        }
        recyclerView.addItemDecoration(new HorizontalSpaceDecorator(30));
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        return v;
    }

    class HorizontalSpaceDecorator extends RecyclerView.ItemDecoration
    {
        private final int spacer;

        public HorizontalSpaceDecorator(int spacer) {
            this.spacer = spacer;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.right=spacer;
        }
    }
}
