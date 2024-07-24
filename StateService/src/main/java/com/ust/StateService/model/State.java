package com.ust.StateService.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class State {

    @Id
    private String stateCode;
    private String stateName;
    private String capital;
    private String population;


}
