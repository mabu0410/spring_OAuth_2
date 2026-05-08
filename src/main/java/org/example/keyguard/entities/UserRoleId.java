package org.example.keyguard.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRoleId implements Serializable {
    @Column(name = "user_id")
    Long userId;

    @Column(name = "role_id")
    Long roleId;
}
