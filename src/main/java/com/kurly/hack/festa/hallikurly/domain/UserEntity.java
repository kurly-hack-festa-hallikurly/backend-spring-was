package com.kurly.hack.festa.hallikurly.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Table(name="tb_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "user_pw")
    private long userPw;

    @Column(name = "user_alias")
    private long userAlias;
}
