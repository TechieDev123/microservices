package com.rest.resource.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ROLE")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    private String roleName;
}
