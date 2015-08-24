package pl.codepot.groovy_no_way_back.random;

import java.util.Random;

public final class RandomQueryGenerator {

    private final Random random = new Random();
    private final char[] alphabet = new char[]{
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    public String getRandomQuery() {
        return new String(new char[]{
                alphabet[random.nextInt(alphabet.length)],
                alphabet[random.nextInt(alphabet.length)]
        });
    }
}
