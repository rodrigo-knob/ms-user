package br.com.fiap.msusuario.domain.mapper;

import br.com.fiap.msusuario.application.controller.response.UserReponse;
import br.com.fiap.msusuario.domain.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public UserReponse userToUserReponse(User user) {
        return new UserReponse(user.getLogin(), user.getPassword());
    }
}
