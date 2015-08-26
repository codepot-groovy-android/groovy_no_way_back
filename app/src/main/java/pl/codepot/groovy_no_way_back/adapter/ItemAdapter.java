package pl.codepot.groovy_no_way_back.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public interface ItemAdapter {

    int getLayoutId();

    RecyclerView.ViewHolder onCreateViewHolder(View itemView);

    void onBindViewHolder(RecyclerView.ViewHolder holder);
}
