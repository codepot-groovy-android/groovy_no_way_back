package pl.codepot.groovy_no_way_back.adapter;

import java.util.List;

import pl.codepot.groovy_no_way_back.dto.GitHubUser;

public final class GitHubAdapter extends BaseAdapter {

    public void add(List<GitHubUser> users) {
        items.clear();
        for (GitHubUser gitHubUser : users) {
            items.add(new UserItemAdapter(gitHubUser));
        }
        notifyDataSetChanged();
    }
}
