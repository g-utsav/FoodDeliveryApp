package com.foodDelivery.dataAcessLayer;

import java.util.Optional;

import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodDelivery.entity.CurrentUserSession;


@Repository
public interface SessionDAO extends JpaRepository<CurrentUserSession, Integer>{
	
	public Optional<CurrentUserSession> findByCustomerId(Integer customerId);
	
	public Optional<CurrentUserSession> findByUuid(String uuid);

}
