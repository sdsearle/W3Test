package com.example.admin.w3test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.w3test.CarFragment.OnListFragmentInteractionListener;
import com.example.admin.w3test.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyCarRecyclerViewAdapter extends RecyclerView.Adapter<MyCarRecyclerViewAdapter.ViewHolder> {

    private final List<Car> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyCarRecyclerViewAdapter(Context context, List<Car> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_car, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvCarModel.setText(mValues.get(position).getModel());
        holder.tvCarType.setText(mValues.get(position).getType());
        holder.tvCarYear.setText(mValues.get(position).getYear());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvCarModel;
        public final TextView tvCarYear;
        public final TextView tvCarType;
        public Car mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvCarModel = (TextView) view.findViewById(R.id.tvCarModel);
            tvCarType = (TextView) view.findViewById(R.id.tvCarType);
            tvCarYear = (TextView) view.findViewById(R.id.tvCarYear);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvCarModel.getText() + "'";
        }
    }
}
