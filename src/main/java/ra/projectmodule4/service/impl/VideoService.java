package ra.projectmodule4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.projectmodule4.dao.impl.VideoDao;
import ra.projectmodule4.dto.request.VideoDTO;
import ra.projectmodule4.model.Video;
import ra.projectmodule4.service.IGenericService;

import java.util.List;

@Service
public class VideoService implements IGenericService<Video, Integer> {
    @Autowired
    private VideoDao videoDao;

    @Override
    public List<Video> findAll() {
        return null;
    }

    @Override
    public void save(Video video) {
        videoDao.save(video);
    }

    @Override
    public Video findById(Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    public List<Video> findAllByUserId(Long aLong) {

        return videoDao.findAllByUserId(aLong);
    }

    public List<VideoDTO> findAllVideoDTOByUserId(Long aLong) {

        return videoDao.findAllVideoDTOByUserId(aLong);
    }
}
