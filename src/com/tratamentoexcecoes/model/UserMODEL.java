package com.tratamentoexcecoes.model;

import lombok.*;

import java.time.OffsetDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserMODEL {

    private long id;
    private String name;
    private String email;
    private OffsetDateTime birthDay;
}