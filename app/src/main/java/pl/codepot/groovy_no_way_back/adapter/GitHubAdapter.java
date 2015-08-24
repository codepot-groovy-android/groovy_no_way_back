package pl.codepot.groovy_no_way_back.adapter;

import pl.codepot.groovy_no_way_back.dto.GitHubUser;

public final class GitHubAdapter extends BaseAdapter {

    public void add(GitHubUser gitHubUser) {
        items.add(new UserItemAdapter(gitHubUser));
        notifyItemInserted(items.size() - 1);
    }
}
