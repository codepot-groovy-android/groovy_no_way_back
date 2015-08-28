package pl.codepot.groovy_no_way_back.adapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<ItemAdapter> items = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        for (ItemAdapter itemAdapter : items) {
            if (itemAdapter.getLayoutId() == viewType) {
                return itemAdapter.onCreateViewHolder(view);
            }
        }
        throw new RuntimeException("Item adapter corresponding to viewType not found");
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getLayoutId();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        items.get(position).onBindViewHolder(holder);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
