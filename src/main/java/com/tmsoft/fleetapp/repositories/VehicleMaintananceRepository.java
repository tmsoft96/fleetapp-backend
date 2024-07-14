package com.tmsoft.fleetapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tmsoft.fleetapp.models.VehicleMaintanance;

@Repository
public interface VehicleMaintananceRepository extends JpaRepository<VehicleMaintanance, Integer> {

}
