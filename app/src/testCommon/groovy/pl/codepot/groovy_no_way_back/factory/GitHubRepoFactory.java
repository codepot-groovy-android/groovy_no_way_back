package pl.codepot.groovy_no_way_back.factory;

import pl.codepot.groovy_no_way_back.dto.GitHubRepo;

public final class GitHubRepoFactory {
    public static GitHubRepo newAndroidMaze() {
        GitHubRepo androidMaze = new GitHubRepo();
        androidMaze.setId(24003843L);
        androidMaze.setName("AndroidMaze");
        androidMaze.setStargazersCount(2);
        androidMaze.setWatchersCount(2);
        androidMaze.setLanguage("Groovy");
        androidMaze.setForksCount(0);
        return androidMaze;
    }

    public static GitHubRepo newRepo(int stargazers, int watchers, int forks) {
        GitHubRepo androidMaze = new GitHubRepo();
        androidMaze.setId(-1L);
        androidMaze.setName("NewRepo");
        androidMaze.setStargazersCount(stargazers);
        androidMaze.setWatchersCount(watchers);
        androidMaze.setLanguage("Dummy");
        androidMaze.setForksCount(forks);
        return androidMaze;
    }
}
