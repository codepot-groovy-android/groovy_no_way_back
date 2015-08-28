package pl.codepot.groovy_no_way_back.factory;

import pl.codepot.groovy_no_way_back.dto.GitHubRepo;

public final class GitHubRepoFactory {
    public static GitHubRepo newAndroidMaze() {
        GitHubRepo androidMaze = new GitHubRepo();
        androidMaze.id = 24003843L;
        androidMaze.name = "AndroidMaze";
        androidMaze.stargazersCount = 2;
        androidMaze.watchersCount = 2;
        androidMaze.language = "Groovy";
        androidMaze.forksCount = 0;
        return androidMaze;
    }
}
