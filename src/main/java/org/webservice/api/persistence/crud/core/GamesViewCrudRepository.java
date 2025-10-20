package org.webservice.api.persistence.crud.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.webservice.api.persistence.entity.core.GamesView;

import java.util.List;
import java.util.Optional;

public interface GamesViewCrudRepository extends CrudRepository<GamesView,Long>, PagingAndSortingRepository<GamesView,Long> {
    @Query("SELECT g " +
           "FROM GamesView g " +
           "LEFT JOIN GamesInventory i " +
           "ON g.id = i.gameId " +
           "WHERE i.gameId IS NULL")
    Optional<List<GamesView>> findWithoutInventory();

    @Query("SELECT g FROM GamesView g " +
            "WHERE LOWER(g.title) LIKE LOWER(CONCAT('%', :value, '%')) " +
            "OR LOWER(g.description) LIKE LOWER(CONCAT('%', :value, '%')) " +
            "OR LOWER(g.genre) LIKE LOWER(CONCAT('%', :value, '%')) " +
            "OR LOWER(g.platform) LIKE LOWER(CONCAT('%', :value, '%')) " +
            "OR LOWER(g.developer) LIKE LOWER(CONCAT('%', :value, '%')) " +
            "OR LOWER(g.classification) LIKE LOWER(CONCAT('%', :value, '%')) " +
            "OR CONCAT(g.releaseDate, '') LIKE CONCAT('%', :value, '%') " +
            "OR CONCAT(g.price, '') LIKE CONCAT('%', :value, '%')")
    Page<GamesView> searchGames(@Param("value") String value, Pageable pageable);
}
