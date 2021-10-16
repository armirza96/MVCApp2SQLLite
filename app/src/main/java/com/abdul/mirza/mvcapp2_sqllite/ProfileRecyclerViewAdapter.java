package com.abdul.mirza.mvcapp2_sqllite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Profile;

import java.util.List;

public class ProfileRecyclerViewAdapter extends RecyclerView.Adapter<ProfileRecyclerViewAdapter.ViewHolder> {

    private List<Profile> items;
    private boolean showDataNames = true;
    private final RecyclerViewItemSelectedListener listener;

    public ProfileRecyclerViewAdapter(RecyclerViewItemSelectedListener listener,List<Profile> items, boolean showDataNames) {
        this.items = items;
        this.listener = listener;
        this.showDataNames = showDataNames;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_profile, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String text;
        if(showDataNames)
            text =  (position+1) +". " + items.get(position).getSurName() + ", " + items.get(position).getName();
        else
            text = (position+1) +". ID: # " + items.get(position).getStudentId();

        holder.tv.setText(text);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setShowDataNames (boolean showDataNames) {
        this.showDataNames = showDataNames;
    }
    public void setData (List<Profile> items) {
        this.items = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView tv;

        public ViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            listener.itemSelected(items.get(position));
        }
    }
}
