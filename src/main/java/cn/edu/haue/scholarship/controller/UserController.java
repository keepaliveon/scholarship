package cn.edu.haue.scholarship.controller;

import cn.edu.haue.scholarship.common.JwtAuthenticationResponse;
import cn.edu.haue.scholarship.security.CurrentUser;
import cn.edu.haue.scholarship.security.JwtTokenProvider;
import cn.edu.haue.scholarship.security.UserPrincipal;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private JwtTokenProvider tokenProvider;

    @PostMapping("/auth")
    @ApiOperation(value = "认证")
    public ResponseEntity<?> authenticateUser(String username, String password) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @GetMapping("/info")
    @ApiOperation(value = "授权信息")
    public ResponseEntity<?> info(@ApiIgnore @CurrentUser UserPrincipal userPrincipal) {
        String username = userPrincipal.getUsername();
        String role = userPrincipal.getAuthorities().iterator().next().getAuthority();
        Map<String, String> result = new HashMap<>();
        result.put("username", username);
        result.put("role", role);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
