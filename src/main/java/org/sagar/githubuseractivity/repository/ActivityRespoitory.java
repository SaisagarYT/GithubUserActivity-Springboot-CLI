package org.sagar.githubuseractivity.repository;

import org.sagar.githubuseractivity.model.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRespoitory extends CrudRepository<Activity, Long> {

}
