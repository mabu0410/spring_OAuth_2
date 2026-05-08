package org.example.keyguard.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RolePermissionId implements Serializable {

    @Column(name = "role_id")
    Long roleId;

    @Column(name = "permission_id")
    Long permissionId;
}
