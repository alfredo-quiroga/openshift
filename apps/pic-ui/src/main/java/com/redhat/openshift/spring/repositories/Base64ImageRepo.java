package com.redhat.openshift.spring.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.redhat.openshift.spring.models.Base64Image;

public interface Base64ImageRepo extends PagingAndSortingRepository<Base64Image, Long>{

}
