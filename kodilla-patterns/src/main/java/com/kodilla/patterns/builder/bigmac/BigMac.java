package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BigMac {
    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private final List<String> ingredients;

    public static class BigMacBuilder {
        private Bun bun;
        private int burgers;
        private Sauce sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigMac.BigMacBuilder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigMac.BigMacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigMac.BigMacBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigMac.BigMacBuilder ingredients(String ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public BigMac.BigMacBuilder ingredients(String... ingredients) {
            this.ingredients.addAll(Arrays.asList(ingredients));
            return this;
        }

        public BigMac build() {
            return new BigMac(bun, burgers, sauce, ingredients);
        }
    }

    private BigMac(Bun bun, int burgers, Sauce sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }
}