package ua.training.model.service;

import ua.training.model.dao.BoxDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dto.BoxWithProductNameDTO;
import ua.training.model.entity.Box;

import java.util.List;
import java.util.Optional;

public class BoxService {

    private DaoFactory daoFactory;
    private BoxDao boxDao;

    public BoxService() {
        this.daoFactory = DaoFactory.getInstance();
        this.boxDao = daoFactory.createBoxDao();
    }

    public List<Box> findAll(){return boxDao.findAll(1,1);}

    public Optional<Box> findByProduct(Long id){return boxDao.findByProduct(id);}

    public void updateCurrentLoadById(Integer currentLoad, Long id){
        boxDao.updateSetCurrentLoad(currentLoad, id);
    }

    public List<BoxWithProductNameDTO> findBoxByCurrentLoad(Integer currentLoad){
        return boxDao.findBoxDTOByCurrentLoad(currentLoad);
    }

    public Optional<Box> findById(Long id){return boxDao.findById(id);}

    public void updateBoxSetCurrentLoad(int currentLoad, Long id){
        boxDao.updateSetCurrentLoad(currentLoad, id);
    }
}
