package com.example.simpleborad.reply.db;

import ch.qos.logback.core.status.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {

    List<ReplyEntity> findAllByPostIdAndStatusOrderByIdDesc(Long postId, String status);
}
