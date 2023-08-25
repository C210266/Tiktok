package ra.projectmodule4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.projectmodule4.dao.impl.UserDao;
import ra.projectmodule4.dto.request.FormLoginDTO;
import ra.projectmodule4.dto.request.FormRegisterDTO;
import ra.projectmodule4.model.User;
import ra.projectmodule4.service.IGenericService;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;


    public List<User> findAll() {
        return userDao.findAll();
    }


    public void saveLogin(FormLoginDTO formLoginDTO) {
        User user = new User();
        user.setUsername(formLoginDTO.getUsername());
        user.setEmail(formLoginDTO.getEmail());
        user.setPassword(formLoginDTO.getPassword());
        userDao.save(user);
    }

    public void saveRegister(FormRegisterDTO formRegisterDTO) {
        User user = new User();
        user.setUsername(formRegisterDTO.getUsername());
        user.setEmail(formRegisterDTO.getEmail());
        user.setPassword(formRegisterDTO.getPassword());
        user.setFullname(formRegisterDTO.getFullname());

        userDao.save(user);
    }

    public User findById(Long aLong) {
        return null;
    }

    public void delete(Long aLong) {

    }

    public User login(FormLoginDTO formLoginDTO) {
        return userDao.login(formLoginDTO);

    }

    public boolean register(FormRegisterDTO formRegisterDTO) {
        return userDao.register(formRegisterDTO);
    }
}
