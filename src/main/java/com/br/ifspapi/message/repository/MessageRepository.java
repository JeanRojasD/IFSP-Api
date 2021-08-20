package com.br.ifspapi.message.repository;

import com.br.ifspapi.message.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
