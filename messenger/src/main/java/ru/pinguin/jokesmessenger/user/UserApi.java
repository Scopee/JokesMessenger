package ru.pinguin.jokesmessenger.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.pinguin.jokesmessenger.data.User;
import ru.pinguin.jokesmessenger.security.UserPrincipal;

import java.util.UUID;


@RequestMapping(UserApi.USER_API)
@Tag(name = "User Api")
public interface UserApi {
    String USER_API = "/api/v1/user";

    @Operation(summary = "Get all users")
    @GetMapping("/")
    Iterable<User> getUsers(@AuthenticationPrincipal UserPrincipal principal);

    @Operation(summary = "Get a user by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user"),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @GetMapping("/{id}")
    User getUser(@AuthenticationPrincipal UserPrincipal principal, @PathVariable UUID id) throws Exception;

}