package com.abdul.mirza.mvcapp2_sqllite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Access;
import com.abdul.mirza.mvcapp2_sqllite.SQLLite.entity.Profile;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AccessRecyclerViewAdapter extends RecyclerView.Adapter<AccessRecyclerViewAdapter.ViewHolder> {

    private final List<Access> items;

    public AccessRecyclerViewAdapter(List<Access> items) {
        this.items = items;
    }

    @Override
    public AccessRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_access, parent, false);
        return new AccessRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AccessRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.tv.setText(items.get(position).getTimeStamp() + " " + items.get(position).getType().getAction());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView tv;

        public ViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv);
        }

    }
}
