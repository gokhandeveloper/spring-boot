package com.gokhand.roomwebapp.models;

public enum Position {

    CONCIERGE, FRONT_DESK, SECURITY, HOUSEKEEPING;

    public String toString(){
        switch(this) {
            case CONCIERGE:
                return "Concierge";
            case  FRONT_DESK:
                return "Front desk";
            case SECURITY:
                return "Security";
            case  HOUSEKEEPING:
                return "Housekeeping";
        }
        return  "";
    }
}
