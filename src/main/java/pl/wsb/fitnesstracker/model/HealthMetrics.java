package pl.wsb.fitnesstracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "health_metrics")
public class HealthMetrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double height; // wzrost w cm

    @Column(nullable = false)
    private Double weight; // waga w kg

    @Column(nullable = true)
    private Double bmi; 

    // Relacja 1:1 z User
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    // Gettery i settery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }

    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }

    public Double getBmi() { return bmi; }
    public void setBmi(Double bmi) { this.bmi = bmi; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
