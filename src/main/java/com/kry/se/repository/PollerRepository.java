package com.kry.se.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kry.se.entity.PollerData;

@Repository
public interface PollerRepository extends JpaRepository<PollerData, Integer> {
	
	 @Async
	 List<PollerData> findAll();
	 
	 @Transactional
	 @Query("update PollerData poller set poller.name=?1, poller.url=?2 where poller.pollerId=?3")
	 @Modifying	
	 public int updatePollerData(String name, String url, Integer pollerId);
}
