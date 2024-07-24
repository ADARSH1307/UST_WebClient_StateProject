package com.ust.DistrictService.repo;

import com.ust.DistrictService.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepo extends JpaRepository<District, Long> {
    List<District> findByStateCode(String stateCode);
}
