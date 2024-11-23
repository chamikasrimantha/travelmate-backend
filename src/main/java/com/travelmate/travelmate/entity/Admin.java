package com.travelmate.travelmate.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Admin extends UserEntity{
    
    private String name;

    // relationships

    // one-to-many with admin announcement entity
    // @JsonIgnore
    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "admin", cascade = CascadeType.ALL)
    // private List<AdminAnnouncementEntity> adminAnnouncements;
    
}
