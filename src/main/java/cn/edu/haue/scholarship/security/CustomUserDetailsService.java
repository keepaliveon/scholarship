package cn.edu.haue.scholarship.security;

import cn.edu.haue.scholarship.entity.Admin;
import cn.edu.haue.scholarship.entity.Counsellor;
import cn.edu.haue.scholarship.entity.Student;
import cn.edu.haue.scholarship.mapper.AdminMapper;
import cn.edu.haue.scholarship.mapper.CounsellorMapper;
import cn.edu.haue.scholarship.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private CounsellorMapper counsellorMapper;

    @Resource
    private StudentMapper studentMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Student student = studentMapper.selectById(s);
        if (student != null) {
            return UserPrincipal.create(student);
        }
        Counsellor counsellor = counsellorMapper.selectById(s);
        if (counsellor != null) {
            return UserPrincipal.create(counsellor);
        }
        Admin admin = adminMapper.selectById(s);
        if (admin != null) {
            return UserPrincipal.create(admin);
        }
        throw new UsernameNotFoundException("not found student counsellor or admin : " + s);
    }

}
