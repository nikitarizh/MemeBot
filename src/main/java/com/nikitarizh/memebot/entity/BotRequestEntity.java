package com.nikitarizh.memebot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bot_requests")
public class BotRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "request", columnDefinition = "VARCHAR(100)", nullable = false)
    private String request;

    @OneToOne(mappedBy = "request")
    private BotResponseEntity response;

    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;
}
