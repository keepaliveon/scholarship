package cn.edu.haue.scholarship.security;

import cn.edu.haue.scholarship.entity.Admin;
import cn.edu.haue.scholarship.entity.Counsellor;
import cn.edu.haue.scholarship.entity.Student;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserPrincipal implements UserDetails {

    private final String username;

    private final String password;

    private final Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }


    public static UserPrincipal create(Admin admin) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(admin.getRole()));
        return new UserPrincipal(admin.getUsername(), admin.getPassword(), authorities);
    }

    public static UserPrincipal create(Counsellor counsellor) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(counsellor.getRole()));
        return new UserPrincipal(counsellor.getStaffId(), counsellor.getPassword(), authorities);
    }

    public static UserPrincipal create(Student student) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(student.getRole()));
        return new UserPrincipal(student.getStudentId(), student.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
