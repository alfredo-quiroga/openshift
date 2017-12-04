package com.redhat.openshift.spring.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.redhat.openshift.spring.models.User;

public interface UserRepo extends PagingAndSortingRepository<User, Long> {

}
