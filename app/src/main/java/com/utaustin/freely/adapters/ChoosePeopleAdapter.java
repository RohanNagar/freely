package com.utaustin.freely.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.utaustin.freely.R;
import com.utaustin.freely.data.EmailContact;

import java.util.ArrayList;

public class ChoosePeopleAdapter extends RecyclerView.Adapter<ChoosePeopleAdapter.ViewHolder> {
    private ArrayList<EmailContact> mDataset;
    private ArrayList<Boolean> checks;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public CheckBox cb;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.row_choose_people_name_textview);
            cb  = (CheckBox) v.findViewById(R.id.cb_people);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ChoosePeopleAdapter(ArrayList<EmailContact> myDataset) {
        mDataset = myDataset;
        checks = new ArrayList<Boolean>();
        for(int i = 0;i<mDataset.size();i++){
            checks.add(false);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ChoosePeopleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_choose_people, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position).getName());

        holder.cb.setChecked(checks.get(position));

        holder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checks.set(position, holder.cb.isChecked());
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public boolean isChecked(int pos){
        return checks.get(pos);
    }
}
