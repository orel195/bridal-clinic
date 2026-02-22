package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.persistence.*;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/appointments")
public class BridalClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(BridalClinicApplication.class, args);
    }


    @Autowired
    private AppointmentRepository repo;

    @GetMapping
    public List<Appointment> getAppointments() {
        return repo.findAll();
    }

    @PostMapping
    public Appointment addAppointment(@RequestBody Appointment appt) {
        return repo.save(appt);
    }
}

@Entity
class Appointment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientName;
    private String treatmentType;
    // Getters and Setters
}

interface AppointmentRepository extends JpaRepository<Appointment, Long> {}