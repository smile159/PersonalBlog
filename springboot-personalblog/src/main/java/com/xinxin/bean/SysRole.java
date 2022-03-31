package com.xinxin.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author smile
 * @ClassName SysRole.java
 * @Description 用户角色
 * @createTime 2022年03月31日 15:58:00
 */
@Data
public class SysRole implements GrantedAuthority {

    private Integer id;
    private String roleName;
    private String roleDesc;

    /**
     * 如果授予的权限可以当作一个String的话，就可以返回一个String
     * @return
     */
    @JsonIgnore
    @Override
    public String getAuthority() {
        return roleName;
    }
}
