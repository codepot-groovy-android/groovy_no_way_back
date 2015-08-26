package pl.codepot.groovy_no_way_back.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.greenrobot.event.EventBus;
import pl.codepot.groovy_no_way_back.R;
import pl.codepot.groovy_no_way_back.dto.GitHubUser;
import pl.codepot.groovy_no_way_back.event.UserChosenEvent;

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
        if (gitHubUser.avatarUrl != null) {
            Glide.with(userHolder.avatarView.getContext()).load(gitHubUser.avatarUrl).into(userHolder.avatarView);
        } else {
            userHolder.avatarView.setImageResource(R.drawable.octocat);
        }
        userHolder.usernameView.setText(gitHubUser.login);
        userHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onUserClicked();
            }
        });
    }

    private void onUserClicked() {
        EventBus.getDefault().post(new UserChosenEvent(gitHubUser));
    }

    public static final class UserHolder extends RecyclerView.ViewHolder {

        final View itemView;
        final ImageView avatarView;
        final TextView usernameView;

        public UserHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            avatarView = (ImageView) itemView.findViewById(R.id.avatar_view);
            usernameView = (TextView) itemView.findViewById(R.id.username_view);
        }
    }
}
