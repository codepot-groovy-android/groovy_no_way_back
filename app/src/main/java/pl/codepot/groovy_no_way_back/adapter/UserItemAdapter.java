package pl.codepot.groovy_no_way_back.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import pl.codepot.groovy_no_way_back.R;

public final class UserItemAdapter implements ItemAdapter<UserItemAdapter.UserHolder> {

    @Override
    public int getLayoutId() {
        return R.layout.user_item;
    }

    @Override
    public UserHolder onCreateViewHolder(View itemView) {
        return new UserHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder) {

    }

    public static final class UserHolder extends RecyclerView.ViewHolder {

        public UserHolder(View itemView) {
            super(itemView);
        }
    }
}
