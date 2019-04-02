package pl.ls.zaj_26;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate premiereDate;
    private Long budget;
    @Enumerated(EnumType.STRING)
    private  TargetAudience targetAudience;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(LocalDate premiereDate) {
        this.premiereDate = premiereDate;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public TargetAudience getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(TargetAudience targetAudience) {
        this.targetAudience = targetAudience;
    }
}
