package pl.codepot.groovy_no_way_back.adapter;

public final class GitHubAdapter extends BaseAdapter {

    public GitHubAdapter() {
        for (int i = 0; i < 200; i++) {
            items.add(new UserItemAdapter());
        }
    }
}
