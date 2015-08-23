package pl.codepot.groovy_no_way_back.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public interface ItemAdapter<VH extends RecyclerView.ViewHolder> {

    int getLayoutId();

    VH onCreateViewHolder(View itemView);

    void onBindViewHolder(RecyclerView.ViewHolder holder);
}
