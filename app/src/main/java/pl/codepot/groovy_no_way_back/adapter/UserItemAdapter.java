package pl.codepot.groovy_no_way_back.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import pl.codepot.groovy_no_way_back.R;
import pl.codepot.groovy_no_way_back.dto.GitHubUser;

public final class UserItemAdapter implements ItemAdapter<UserItemAdapter.UserHolder> {

    private final GitHubUser gitHubUser;

    public UserItemAdapter(GitHubUser gitHubUser) {
        this.gitHubUser = gitHubUser;
    }

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
        UserHolder userHolder = (UserHolder) holder;
        userHolder.usernameView.setText(gitHubUser.login);
    }

    public static final class UserHolder extends RecyclerView.ViewHolder {

        final TextView usernameView;

        public UserHolder(View itemView) {
            super(itemView);
            usernameView = (TextView) itemView.findViewById(R.id.username_view);
        }
    }
}
