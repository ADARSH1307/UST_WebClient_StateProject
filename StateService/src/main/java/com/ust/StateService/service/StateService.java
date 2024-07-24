package com.ust.StateService.service;

import com.ust.StateService.model.State;
import com.ust.StateService.repo.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public Optional<State> getStateByCode(String code) {
        return stateRepository.findById(code);
    }

    public State saveState(State state) {
        return stateRepository.save(state);
    }
}
