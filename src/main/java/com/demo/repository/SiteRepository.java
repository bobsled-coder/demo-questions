package com.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.Site;

public interface SiteRepository extends JpaRepository<Site, Long> {

	@Query(value = "SELECT s.* FROM Sites s WHERE s.site_uuid = ?1", nativeQuery = true)
	public Site findByUuid(UUID siteUUID);
}
