package com.example.ansar.carpark;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ansar on 12/23/2017.
 */

public class LocationListAdapter extends RecyclerView.Adapter<LocationListAdapter.ViewHolder> {

    private Context context;
    private List<String> items;
    private ItemClickListener itemClickListener;

    public LocationListAdapter(Context context, List<String> items, ItemClickListener itemClickListener) {
        this.context = context;
        this.items = items;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_list_item_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.locationName.setText(items.get(position));

        if (itemClickListener != null) {
            holder.locationName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(items.get(position));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView locationName;

        public ViewHolder(View itemView) {
            super(itemView);
            locationName = (TextView) itemView.findViewById(R.id.location_name);

        }
    }

    public interface ItemClickListener {
        void onItemClick(String location);
    }

}
