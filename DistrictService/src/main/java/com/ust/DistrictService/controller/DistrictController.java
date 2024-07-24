package com.ust.DistrictService.controller;

import com.ust.DistrictService.model.District;
import com.ust.DistrictService.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/districts")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping("/by-state/{stateCode}")
    public List<District> getDistrictsByState(@PathVariable String stateCode) {
        return districtService.getDistrictsByStateCode(stateCode);
    }

    @PostMapping
    public District addDistrict(@RequestBody District district) {
        return districtService.saveDistrict(district);
    }
}
