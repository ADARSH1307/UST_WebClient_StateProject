package com.ust.DistrictService.service;

import com.ust.DistrictService.model.District;
import com.ust.DistrictService.repo.DistrictRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepo districtRepository;

    public List<District> getDistrictsByStateCode(String stateCode) {
        return districtRepository.findByStateCode(stateCode);
    }

    public District saveDistrict(District district) {
        return districtRepository.save(district);
    }

}
