package com.ehss.springresth2template;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface  SampleEntityRepository extends JpaRepository<SampleEntity,Long> {

    // select * from sampleentity where value = :val
    Collection<SampleEntity> findByValue(@Param("val") String val);
}
