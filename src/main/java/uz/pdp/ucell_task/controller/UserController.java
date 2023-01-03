package uz.pdp.ucell_task.controller;

import org.springframework.web.bind.annotation.*;
import uz.pdp.ucell_task.payload.ApiResult;
import uz.pdp.ucell_task.payload.UserDTO;

import java.util.List;

@RequestMapping("/user")
public interface UserController {
    @PostMapping("/sign-in")
    UserDTO signIn(@RequestBody UserDTO userDTO);

    @PostMapping
    ApiResult add(@RequestBody UserDTO userDTO);

    @GetMapping
    List<UserDTO> getAll();

    @GetMapping("/{id}")
    UserDTO get(@PathVariable Integer id);

    @PutMapping("/{id}")
    ApiResult edit(@PathVariable Integer id,
                   @RequestBody UserDTO userDTO);

    @DeleteMapping("/{id}")
    ApiResult delete(@PathVariable Integer id);
}
