package com.travelmate.travelmate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "admin_announcement")
public class AdminAnnouncementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admannId")
    private Long id;

    private String title;

    private String message;

    // relationships

    // many-to-one with admin entity
    // @ManyToOne
    // @JoinColumn(name = "userId")
    // private Admin admin;

}
