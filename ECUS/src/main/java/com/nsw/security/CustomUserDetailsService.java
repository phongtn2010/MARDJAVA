package com.nsw.security;

import com.nsw.common.model.json.AspnetUserJson;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nsw.user.model.User;
import java.util.HashMap;
import java.util.Map;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private Environment environment;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String ssoId)
            throws UsernameNotFoundException {
        //User user = userService.findBySSO(ssoId);
        User user = getUser(ssoId);
        logger.info("User : {}", user);
        if (user == null) {
            logger.info("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new UserCustom(user.getSsoId(), user.getPasswordAndSalt(),
                true, true, true, true, getGrantedAuthorities(user),
                user.getTabs(), user.getCompanyEmail(), user.getCompanyAddress(),
                user.getCompanyFax(), user.getCompanyPhoneNumber(), user.getCompanyName(),
                user.getRepresenterEmail(), user.getRepresenterName(), user.getRepresenterPhone(),
                user.getRepresenterMobile(), user.getCompanyType(), user.getRegistrationNo(), user.getDepartmentManage(),
                user.getEngName(), user.getShortName(), user.getConstitutionYear());
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        authorities.add(new SimpleGrantedAuthority("ROLE_DBA"));
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }

    private User getUser(String ssoId) {
        User user = null;
        try {
            RestTemplate restTemplate = new RestTemplate();
            Map<String, String> map = new HashMap<String, String>();
            map.put("userName", ssoId);
            String USER_API_URL = environment.getRequiredProperty("login.rest.url");
            AspnetUserJson userNew = restTemplate.getForObject(USER_API_URL, AspnetUserJson.class, map);

            if (userNew != null) {
                user = new User();
                user.setSsoId(ssoId);
                user.setPassword(userNew.getPassword());
                user.setPasswordAndSalt(userNew.getPasswordSalt() + ":" + userNew.getPassword());
                user.setTabs(userNew.getTabs());
                user.setCompanyEmail(userNew.getCompanyEmail());
                user.setCompanyName(userNew.getCompanyName());
                user.setCompanyAddress(userNew.getCompanyAddress());
                user.setCompanyFax(userNew.getCompanyFax());
                user.setCompanyPhoneNumber(userNew.getCompanyPhoneNumber());

                user.setRepresenterEmail(userNew.getRepresenterEmail());
                user.setRepresenterMobile(userNew.getRepresenterMobile());
                user.setRepresenterName(userNew.getRepresenterName());
                user.setRepresenterPhone(userNew.getRepresenterPhone());
                
                user.setCompanyType(userNew.getCompanyType());
                user.setRegistrationNo(userNew.getRegistrationNo());
                user.setDepartmentManage(userNew.getDepartmentManage());
                user.setEngName(userNew.getEngName());
                user.setShortName(userNew.getShortName());
                user.setConstitutionYear(userNew.getConstitutionYear());
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return user;
    }

}
