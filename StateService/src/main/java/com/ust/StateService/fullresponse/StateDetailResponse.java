package com.ust.StateService.fullresponse;

import com.ust.StateService.model.State;

import java.util.List;

public class StateDetailResponse {
    private State state;
    private List<District> districts;

    public StateDetailResponse(State state, List<District> districts) {
        this.state = state;
        this.districts = districts;
    }


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }
}
