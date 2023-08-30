package com.tkgroupbd.pusti.api.services.user;
import com.tkgroupbd.pusti.api.data.payloads.requests.users.UserRegisterRequest;
import com.tkgroupbd.pusti.api.data.payloads.requests.users.UserRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.UserResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface UserService {

    public UserResponse UserRegister(UserRegisterRequest request);
    public UserResponse UserLogin(UserRequest request);
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
