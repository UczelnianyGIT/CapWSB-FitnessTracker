package pl.wsb.fitnesstracker.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    // Relacja 1:1 z HealthMetrics
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private HealthMetrics healthMetrics;

    // Relacja 1:N z Statistics
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Statistics> statistics;

    // Gettery i settery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public HealthMetrics getHealthMetrics() { return healthMetrics; }
    public void setHealthMetrics(HealthMetrics healthMetrics) { this.healthMetrics = healthMetrics; }

    public List<Statistics> getStatistics() { return statistics; }
    public void setStatistics(List<Statistics> statistics) { this.statistics = statistics; }
}
