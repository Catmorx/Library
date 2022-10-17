package com.usa.library.repository.crudrepository;

import com.usa.library.model.ScoreModel;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository<ScoreModel, Integer> {
}
