package com.example.admin.w3test;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.w3test.dummy.DummyContent;
import com.example.admin.w3test.dummy.DummyContent.DummyItem;

import java.io.Serializable;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class CarFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    private static final String CAR_LIST = "car_list";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private List<Car> mCars;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CarFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CarFragment newInstance(int columnCount, List<Car> cars) {
        CarFragment fragment = new CarFragment();
        Log.d("TAG", "MyCarRecyclerViewAdapter: " + cars.size());
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        args.putSerializable(CAR_LIST, (Serializable) cars);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG", "MyCarRecyclerViewAdapter: ");
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            mCars = (List<Car>) getArguments().getSerializable(CAR_LIST);
            Log.d("TAG", "MyCarRecyclerViewAdapter: " + mCars.size() + "  " + mColumnCount);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car_list, container, false);
        RecyclerView rvList;


        // Set the adapter
            Context context = view.getContext();
            rvList = (RecyclerView) view.findViewById(R.id.list);
            if (mColumnCount <= 1) {
                rvList.setLayoutManager(new LinearLayoutManager(context));
            } else {
                rvList.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
        rvList.setAdapter(new MyCarRecyclerViewAdapter(context, mCars, mListener));
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Car item);
    }
}
