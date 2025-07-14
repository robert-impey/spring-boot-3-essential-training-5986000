package com.frankmoley.lil.roomwebapp.data.entity;

public enum Position {
    CONCIERGE,
    FRONT_DESK,
    HOUSEKEEPING,
    RECEPTIONIST,
    SECURITY;

    @Override
    public String toString() {
        return name();
    }
}
