package uz.pdp.ucell_task.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.ucell_task.payload.ApiResult;
import uz.pdp.ucell_task.payload.UserDTO;
import uz.pdp.ucell_task.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController{
    private final UserService userService;

    @Override
    public UserDTO signIn(UserDTO userDTO) {
        return userService.signIn(userDTO);
    }

    @Override
    public ApiResult add(UserDTO userDTO) {
        return userService.add(userDTO);
    }

    @Override
    public List<UserDTO> getAll() {
        return userService.getAll();
    }

    @Override
    public UserDTO get(Integer id) {
        return userService.get(id);
    }

    @Override
    public ApiResult edit(Integer id, UserDTO userDTO) {
        return userService.edit(id,userDTO);
    }

    @Override
    public ApiResult delete(Integer id) {
        return userService.delete(id);
    }
}
