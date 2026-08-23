package org.webservice.api.persistencedb2.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.coredb2.CommentsDto;
import org.webservice.api.persistencedb2.entity.Comments;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentsMapper {
    CommentsDto toCommentsDto(Comments comments);
    List<CommentsDto> toCommentsDto(List<Comments> commentsList);

    @InheritInverseConfiguration
    Comments toComments(CommentsDto commentsDto);
}
