package com.ccbedoya.BlogBackend.repository;

import com.ccbedoya.BlogBackend.model.Author;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

public interface AuthorRepository extends DatastoreRepository<Author, String> {
}
