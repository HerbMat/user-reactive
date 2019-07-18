package com.reactive.user.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode(of = {"id"})
@Document
public class User {

    @Id
    String id;

    @NotEmpty
    String name;

    @NotEmpty
    String surname;
}
