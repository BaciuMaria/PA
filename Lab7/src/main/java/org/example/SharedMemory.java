package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SharedMemory {
    private final List<Token> tokens = new ArrayList<>();
    public SharedMemory(int n) {
        for (int i = 1; i <= n*n*n; i++) {
            tokens.add(new Token(i));
        }
        Collections.shuffle(tokens);
    }
    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        Iterator<Token> iterator = tokens.iterator();
        int count = 0;
        while (iterator.hasNext() && count < howMany) {
            extracted.add(iterator.next());
            iterator.remove();
            count++;
        }
        return extracted;
    }
}