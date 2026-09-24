package com.example._14.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(
            message = "Please select how frequently you use our product."
    )
    @Column(nullable = false)
    private String frequency;

    @NotNull(message = "Please rate the ease of use.")
    @Min(value = 0, message = "Rating must be between 0 and 10.")
    @Max(value = 10, message = "Rating must be between 0 and 10.")
    @Column(nullable = false)
    private Integer easeOfUse;

    @NotNull(message = "Please rate the quality.")
    @Min(value = 0, message = "Rating must be between 0 and 10.")
    @Max(value = 10, message = "Rating must be between 0 and 10.")
    @Column(nullable = false)
    private Integer quality;

    @NotNull(message = "Please rate the performance.")
    @Min(value = 0, message = "Rating must be between 0 and 10.")
    @Max(value = 10, message = "Rating must be between 0 and 10.")
    @Column(nullable = false)
    private Integer performance;

    @NotNull(message = "Please rate the value for money.")
    @Min(value = 0, message = "Rating must be between 0 and 10.")
    @Max(value = 10, message = "Rating must be between 0 and 10.")
    @Column(nullable = false)
    private Integer valueForMoney;

    @Size(max = 2000, message = "Comment must not exceed 2000 characters.")
    @Column(length = 2000)
    private String comment;

    public Feedback() {
    }

    public Long getId() {
        return id;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Integer getEaseOfUse() {
        return easeOfUse;
    }

    public void setEaseOfUse(Integer easeOfUse) {
        this.easeOfUse = easeOfUse;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    public Integer getValueForMoney() {
        return valueForMoney;
    }

    public void setValueForMoney(Integer valueForMoney) {
        this.valueForMoney = valueForMoney;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
