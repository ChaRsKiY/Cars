package com.example.testpostgre.reps.truckrepair;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.testpostgre.model.TruckRepair;

@Repository
@Transactional
public interface TruckRepairRepository extends JpaRepository<TruckRepair,Long> {


}
