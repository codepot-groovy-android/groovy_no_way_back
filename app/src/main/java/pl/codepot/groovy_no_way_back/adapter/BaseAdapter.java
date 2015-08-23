package pl.codepot.groovy_no_way_back.adapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter extends RecyclerView.Adapter {

    protected List<ItemAdapter<? extends RecyclerView.ViewHolder>> items = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, @LayoutRes int layoutId) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        for (ItemAdapter<? extends RecyclerView.ViewHolder> itemAdapter : items) {
            if (itemAdapter.getLayoutId() == layoutId) {
                return itemAdapter.onCreateViewHolder(view);
            }
        }
        throw new RuntimeException("Item adapter corresponding to layouId not found");
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
