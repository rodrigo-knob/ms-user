package br.com.fiap.msusuario.application.documentation;

import br.com.fiap.msusuario.application.controller.request.LoginRequest;
import br.com.fiap.msusuario.application.controller.request.UserRequest;
import br.com.fiap.msusuario.application.controller.response.LoginResponse;
import br.com.fiap.msusuario.application.controller.response.UserReponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "User", description = "User API")
public interface UserControllerDoc {

    @Operation(summary = "Login user in the system", method = "POST")
    @ApiResponse(useReturnTypeSchema = true)
    ResponseEntity<LoginResponse> login(@RequestBody(description = "User login data") LoginRequest loginRequest);

    @Operation(summary = "Register an user", method = "POST")
//    @ApiResponse(useReturnTypeSchema = true)
    ResponseEntity<UserReponse> register(@RequestBody(description = "User register data") UserRequest userRequest);
}
