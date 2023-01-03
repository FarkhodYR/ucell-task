package uz.pdp.ucell_task.service;

import org.springframework.stereotype.Service;
import uz.pdp.ucell_task.entity.User;
import uz.pdp.ucell_task.payload.ApiResult;
import uz.pdp.ucell_task.payload.UserDTO;
import uz.pdp.ucell_task.repository.UserRepository;

import java.util.List;
import java.util.function.Function;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ApiResult add(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            return new ApiResult(false,"This email exists !");
        }
        User user=new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);

        return new ApiResult(true,"saved");
    }

    @Override
    public List<UserDTO> getAll() {
        Function<User,UserDTO> function=(user -> new UserDTO(user.getId(), user.getEmail(), user.getPassword()));
        return userRepository.findAll()
                .stream()
                .map(function)
                .toList();

    }

    @Override
    public UserDTO get(Integer id) {

        User user = userRepository.findById(id).orElseThrow(IllegalStateException::new);
        return new UserDTO(user.getId(), user.getEmail(), user.getPassword());

    }

    @Override
    public ApiResult edit(Integer id, UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            return new ApiResult(false,"This email exists !");
        }
        userRepository.save(userDTOToUser(userRepository.findById(id).orElseThrow(IllegalStateException::new), userDTO));
        return new ApiResult(true,"success");
    }

    @Override
    public ApiResult delete(Integer id) {
        userRepository.delete(userRepository.findById(id).orElseThrow(IllegalStateException::new));
        return null;
    }

    @Override
    public UserDTO signIn(UserDTO userDTO) {
        User userCheck=new User();
        userCheck=userRepository.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());

        return null;
    }

    private User userDTOToUser(User user, UserDTO userDTO) {
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
