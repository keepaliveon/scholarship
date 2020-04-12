package cn.edu.haue.scholarship.controller;

import cn.edu.haue.scholarship.entity.Student;
import cn.edu.haue.scholarship.payload.JwtAuthenticationResponse;
import cn.edu.haue.scholarship.security.JwtTokenProvider;
import cn.edu.haue.scholarship.service.IStudentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IStudentService studentService;

    @ApiOperation("学生注册")
    @PostMapping("/signup")
    public ResponseEntity<?> create(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        if (studentService.save(student)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
