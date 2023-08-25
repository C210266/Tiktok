package ra.projectmodule4.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ra.projectmodule4.dao.IGenericDao;
import ra.projectmodule4.dto.request.VideoDTO;
import ra.projectmodule4.model.Video;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class VideoDao implements IGenericDao<Video, Integer> {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDao userDao;

    @Override
    public List<Video> findAll() {
        return null;
    }

    @Override
    public void save(Video video) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            if (video.getId() == 0) {
                // thêm moi
                CallableStatement callSt = conn.prepareCall("{call insertVideo(?,?,?,?)}");
                callSt.setLong(1, video.getUserId());
                callSt.setString(2, video.getTitle());
                callSt.setString(3, video.getDescription());
                callSt.setString(4, video.getVideoUrl());

                callSt.execute();
            } else {
                // cap nhat
                CallableStatement callSt = conn.prepareCall("{call updateProduct(?,?,?,?,?)}");
                callSt.setInt(1, video.getId());
                callSt.setLong(2, video.getUserId());
                callSt.setString(3, video.getTitle());
                callSt.setString(4, video.getDescription());
                callSt.setString(5, video.getVideoUrl());
//
                callSt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    @Override
    public Video findById(Integer integer) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    public List<Video> findAllByUserId(Long aLong) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<Video> videos = new ArrayList<>();
        try {
            CallableStatement callSt = conn.prepareCall("{call findAllByUserId(?)}");
            callSt.setLong(1, aLong);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Video v = new Video();
                v.setId(rs.getInt("id"));
                v.setDescription(rs.getString("description"));
                v.setTitle(rs.getString("title"));
                v.setVideoUrl(rs.getString("videoUrl"));

                videos.add(v);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return videos;
    }

    public List<VideoDTO> findAllVideoDTOByUserId(Long aLong) {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        List<VideoDTO> videos = new ArrayList<>();
        try {
            CallableStatement callSt = conn.prepareCall("{call findAllByUserId(?)}");
            callSt.setLong(1, aLong);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                VideoDTO v = new VideoDTO();
                v.setUser(userDao.findById(rs.getLong("userId")));
                v.setVideoUrlNotFile(rs.getString("videoUrl"));
                v.setTitle(rs.getString("title"));
                v.setDescription(rs.getString("description"));
                videos.add(v);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return videos;
    }
}
