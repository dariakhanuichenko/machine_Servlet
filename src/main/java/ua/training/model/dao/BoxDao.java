package ua.training.model.dao;

import ua.training.model.entity.Box;

import java.util.Optional;

public interface BoxDao extends GenericDao<Box> {

    Optional<Box> findByProduct(Long id);
    void updateSetCurrentLoad(Integer currentLoad, Long id);

}
