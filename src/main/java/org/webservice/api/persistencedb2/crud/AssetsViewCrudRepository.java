package org.webservice.api.persistencedb2.crud;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.webservice.api.persistencedb2.entity.AssetsView;

import java.util.List;
import java.util.Optional;

public interface AssetsViewCrudRepository extends CrudRepository<AssetsView,Long> {
    @Query("SELECT a FROM AssetsView a " +
            "WHERE CONCAT(a.id, '') LIKE CONCAT('%', :value, '%') " +
            "OR LOWER(a.brand) LIKE LOWER(CONCAT('%', :value, '%')) " +
            "OR LOWER(a.model) LIKE LOWER(CONCAT('%', :value, '%')) " +
            "OR LOWER(a.type) LIKE LOWER(CONCAT('%', :value, '%')) " +
            "OR LOWER(a.serialNumber) LIKE LOWER(CONCAT('%', :value, '%')) " +
            "OR LOWER(a.hostName) LIKE LOWER(CONCAT('%', :value, '%')) " +
            "OR LOWER(a.uid) LIKE LOWER(CONCAT('%', :value, '%')) " +
            "OR LOWER(a.assignedUser) LIKE LOWER(CONCAT('%', :value, '%')) " +
            "OR LOWER(a.employeeId) LIKE LOWER(CONCAT('%', :value, '%')) " +
            "OR LOWER(a.state) LIKE LOWER(CONCAT('%', :value, '%')) " +
            "OR LOWER(a.monitor) LIKE LOWER(CONCAT('%', :value, '%')) " +
            "OR LOWER(a.brandMonitor) LIKE LOWER(CONCAT('%', :value, '%'))")
    Optional<List<AssetsView>> searchAssets(@Param("value") String value);
}
