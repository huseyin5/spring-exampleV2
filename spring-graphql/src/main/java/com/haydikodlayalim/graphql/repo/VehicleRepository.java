package com.haydikodlayalim.graphql.repo;


import com.haydikodlayalim.graphql.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> getByTypeLike(String type);
}
