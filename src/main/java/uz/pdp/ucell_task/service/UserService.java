package uz.pdp.ucell_task.service;

import uz.pdp.ucell_task.payload.ApiResult;
import uz.pdp.ucell_task.payload.UserDTO;

import java.util.List;

public interface UserService {
    public ApiResult add(UserDTO userDTO);

    public List<UserDTO> getAll();

    public UserDTO get(Integer id);

    public ApiResult edit(Integer id, UserDTO userDTO);

    public ApiResult delete(Integer id);

    UserDTO signIn(UserDTO userDTO);
}
