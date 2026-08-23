package org.webservice.api.persistencedb2.crud;

import org.springframework.data.repository.CrudRepository;
import org.webservice.api.persistencedb2.entity.Comments;

import java.util.List;
import java.util.Optional;

public interface CommentsCrudRepository extends CrudRepository<Comments,Long> {
    Optional<List<Comments>> findByAssetId(Long id);
}
