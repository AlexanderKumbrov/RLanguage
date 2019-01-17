package com.example.user.rlanguage;

import java.util.UUID;

public class Lesson {
    private UUID idLess;
    private String titleLess;


    public UUID getIdLess()
    {
        return idLess;
    }

    public String getTitleLess() {
        return titleLess;
    }

    public void setIdLess(UUID idLess) {
        this.idLess = idLess;
    }

    public void setTitleLess(String titleLess) {
        this.titleLess = titleLess;


    }
}
