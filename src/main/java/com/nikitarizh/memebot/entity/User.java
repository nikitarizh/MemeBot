package com.nikitarizh.memebot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "telegram_id", nullable = false)
    private long telegramId;

    @Column(name = "telegram_username", columnDefinition = "VARCHAR(100)", nullable = false)
    private String telegramUsername;

    @Column(name = "first_name", columnDefinition = "VARCHAR(100)")
    private String firstName;

    @Column(name = "last_name", columnDefinition = "VARCHAR(100)")
    private String lastName;

    @OneToMany(mappedBy = "user")
    private List<BotRequestEntity> botRequests;

    @OneToMany(mappedBy = "user")
    private List<BotResponseEntity> botResponses;

    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;
}
