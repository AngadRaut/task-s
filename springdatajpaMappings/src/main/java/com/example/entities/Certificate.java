package com.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class Certificate {

    @NotEmpty(message = "Please enter the coarse name!")
    @NotNull
    private String coarseName;
    private String duration;

    public @NotEmpty(message = "Please enter the coarse name!") @NotNull String getCoarseName() {
        return coarseName;
    }

    public void setCoarseName(@NotEmpty(message = "Please enter the coarse name!") @NotNull String coarseName) {
        this.coarseName = coarseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }


}
