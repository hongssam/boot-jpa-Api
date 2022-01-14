package com.intellius.classmate.user.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    private String id;

    @NotNull
    @NotBlank
    private String name;

    private String token;
}
