package com.intellius.classmate.user.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Builder
public class User {

    @Id
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String name;

    @Size(max = 100)
    private String token;
}
