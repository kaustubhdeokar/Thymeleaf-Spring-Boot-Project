package com.example.tamingthymeleaf3.team;

public class Team {
    private String name;
    private int id;

    /**
     * Default constructor for JPA
     */
    protected Team() {
    }

    public Team(int id,
                String name
    ) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
