package com.redsparksystems.flametrain.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "responder")
public interface ResponderRepository  extends PagingAndSortingRepository<Responder, Long> {
}
