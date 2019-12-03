package ua.training.model.dao;

import ua.training.model.dto.BoxWithProductNameDTO;
import ua.training.model.entity.Box;

import java.util.List;
import java.util.Optional;

public interface BoxDao extends GenericDao<Box> {

    Optional<Box> findByProduct(Long id);
    void updateSetCurrentLoad(Integer currentLoad, Long id);

    List<BoxWithProductNameDTO> findBoxDTOByCurrentLoad(Integer currentLoad);

    Optional<Box> findById(Long id);

    void updateBoxSetCurrentLoad(int currentLoad,  Long id);

    Optional<Integer>  findCurrentLoadByProductId(Long productId);

    Optional<Integer> findCurrentLoadById(Long id);
}
