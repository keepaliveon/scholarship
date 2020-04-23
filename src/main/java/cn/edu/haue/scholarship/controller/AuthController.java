package cn.edu.haue.scholarship.controller;

import cn.edu.haue.scholarship.common.JwtAuthenticationResponse;
import cn.edu.haue.scholarship.security.CurrentUser;
import cn.edu.haue.scholarship.security.JwtTokenProvider;
import cn.edu.haue.scholarship.security.UserPrincipal;
import cn.edu.haue.scholarship.service.IStudentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private JwtTokenProvider tokenProvider;

    @Resource
    private IStudentService studentService;

    @ApiOperation(value = "统一登陆")
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(String username, String password) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @GetMapping("/role")
    public ResponseEntity<?> role(@ApiIgnore @CurrentUser UserPrincipal userPrincipal) {
        GrantedAuthority authority = userPrincipal.getAuthorities().iterator().next();
        return new ResponseEntity<>(authority.getAuthority(), HttpStatus.OK);
    }
}
