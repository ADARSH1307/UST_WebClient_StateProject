package com.ust.StateService.controller;

import com.ust.StateService.fullresponse.District;
import com.ust.StateService.fullresponse.StateDetailResponse;
import com.ust.StateService.model.State;
import com.ust.StateService.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/states")
public class StateController {
    @Autowired
    private StateService stateService;
//    @Autowired
//    private RestTemplate restTemplate;
//    @GetMapping("/{code}")
//    public ResponseEntity<?> getStateDetails(@PathVariable String code) {
//        Optional<State> stateOpt = stateService.getStateByCode(code);
//        if (!stateOpt.isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//        State state = stateOpt.get();
//
//        District[] districtsArray = restTemplate.getForObject(
//                "http://localhost:8082/districts/by-state/" + code, District[].class);
//
//        List<District> districts = List.of(districtsArray);
//
//        return ResponseEntity.ok(new StateDetailResponse(state, districts));
//    }
    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/{code}")
    public ResponseEntity<?> getStateDetails(@PathVariable String code) {
        Optional<State> stateOpt = stateService.getStateByCode(code);
        if (!stateOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        State state = stateOpt.get();

        List<District> districts = webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/districts/by-state/" + code)  // DistrictService URL
                .retrieve()
                .bodyToFlux(District.class)
                .collectList()
                .block();

        return ResponseEntity.ok(new StateDetailResponse(state, districts));
    }

    @PostMapping
    public ResponseEntity<State> addState(@RequestBody State state) {
        State savedState = stateService.saveState(state);
        return ResponseEntity.ok(savedState);
    }

}
