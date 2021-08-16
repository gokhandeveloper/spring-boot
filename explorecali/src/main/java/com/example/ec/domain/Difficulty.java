package com.example.ec.domain;

/**
 * Created by maryellenbowman on 7/3/16.
 */

/**
 * Enumeration of the level of effort.
 *
 * Created by Mary Ellen Bowman
 */
public enum Difficulty {
    Easy("Easy"), Medium("Medium"), Difficult("Difficult"), Varies("Varies");

    private String difficulty;

    private Difficulty(String difficulty){this.difficulty= difficulty;}
    public static Difficulty findByDifficulty(String s) {
        for(Difficulty r:Difficulty.values()) {
            if (r.difficulty.equalsIgnoreCase(s))
                return r;
        }
        return null;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
