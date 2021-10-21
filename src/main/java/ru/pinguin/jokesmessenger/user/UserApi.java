package ru.pinguin.jokesmessenger.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.pinguin.jokesmessenger.data.User;
import java.util.UUID;


@RequestMapping(UserApi.USER_API)
@Tag(name = "User Api")
public interface UserApi {
    String USER_API = "/api/v1/user";

    @Operation(summary = "Get all users")
    @GetMapping("/")
    Iterable<User> getUsers();

    @Operation(summary = "Get a user by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user"),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @GetMapping("/{id}")
    User getUser(@PathVariable UUID id) throws Exception;

    @Operation(summary = "Update user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User updated"),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void  updateUser(@PathVariable final UUID id, @RequestBody final UserRequest user) throws Exception;

    @Operation(summary = "Create user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Create the user"),
            @ApiResponse(responseCode = "404", description = "User already exists",
                    content = @Content) })
    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    UserRequest createUser(@RequestBody final UserRequest user) throws Exception;
}