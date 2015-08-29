package pl.codepot.groovy_no_way_back.random

import groovy.transform.CompileStatic

@CompileStatic
final class RandomQueryGenerator {

    private final Random random = new Random();
    private final List<String> alphabet = [
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
    ]

    String getRandomQuery() {
        return alphabet[random.nextInt(alphabet.size())] \
                 + alphabet[random.nextInt(alphabet.size())]
    }
}
