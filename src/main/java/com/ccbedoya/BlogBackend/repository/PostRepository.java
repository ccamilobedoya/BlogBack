package com.ccbedoya.BlogBackend.repository;

import com.ccbedoya.BlogBackend.model.Post;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

public interface PostRepository extends DatastoreRepository<Post, Long> {

}
