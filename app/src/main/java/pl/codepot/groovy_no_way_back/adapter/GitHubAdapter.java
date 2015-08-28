package pl.codepot.groovy_no_way_back.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import pl.codepot.groovy_no_way_back.R;
import pl.codepot.groovy_no_way_back.dto.GitHubUser;

public final class GitHubAdapter extends RecyclerView.Adapter<GitHubAdapter.Holder> {

    public interface UserClickListener {

        void onUserClick(GitHubUser gitHubUser);
    }

    private final List<GitHubUser> items = new ArrayList<>();
    private final UserClickListener listener;

    public GitHubAdapter(UserClickListener listener) {
        this.listener = listener;
    }

    public void add(List<GitHubUser> users) {
        items.clear();
        items.addAll(users);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        final GitHubUser gitHubUser = items.get(position);
        if (gitHubUser.avatarUrl != null) {
            Glide.with(holder.avatarView.getContext()).load(gitHubUser.avatarUrl).into(holder.avatarView);
        } else {
            holder.avatarView.setImageResource(R.drawable.octocat);
        }
        holder.usernameView.setText(gitHubUser.login);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onUserClick(gitHubUser);
            }
        });
    }

    public static final class Holder extends RecyclerView.ViewHolder {

        final ImageView avatarView;
        final TextView usernameView;

        public Holder(View itemView) {
            super(itemView);
            avatarView = (ImageView) itemView.findViewById(R.id.avatar_view);
            usernameView = (TextView) itemView.findViewById(R.id.username_view);
        }
    }
}
