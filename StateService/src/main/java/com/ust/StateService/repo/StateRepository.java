package com.ust.StateService.repo;


import com.ust.StateService.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, String> {
}
