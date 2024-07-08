package com.example.testpostgre.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "truck_repair")
public class TruckRepair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="day")
    private int day;

    @ManyToOne
    @JoinColumn(name = "truckid", nullable=false)
    private Truck truckId;

    @Override
    public String toString() {
        return "TruckRepair{" +
                "id=" + id +
                ", day=" + day +
                ", truckId=" + truckId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TruckRepair that = (TruckRepair) o;
        return day == that.day && Objects.equals(id, that.id) && Objects.equals(truckId, that.truckId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, day, truckId);
    }
}
