package com.killian.mowItNow.runner;

import java.util.ArrayList;
import java.util.List;

import com.killian.mowItNow.entities.Lawn;
import com.killian.mowItNow.entities.LawnMower;

public class LawnMowerRunner {
    private List<LawnMower> lawnMowers;
    private Lawn lawn;

    public LawnMowerRunner() {}

    public LawnMowerRunner(List<LawnMower> lawnMowers, Lawn lawn) {
        this.lawnMowers = lawnMowers;
        this.lawn = lawn;
    }

    public List<String> run() {
        List<String> results = new ArrayList<>();

        for (LawnMower lawnMower : lawnMowers) {
            lawnMower.move(lawn.getWidth(), lawn.getHeight());
            results.add(lawnMower.toString());
        }

        return results;
    }

    public void setLawnMowers(List<LawnMower> lawnMowers) {
        this.lawnMowers = lawnMowers;
    }

    public void setLawn(Lawn lawn) {
        this.lawn = lawn;
    }

    public List<LawnMower> getLawnMowers() {
        return lawnMowers;
    }

    public Lawn getLawn() {
        return (lawn);
    }
}
