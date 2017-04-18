package com.kunlun.api.web.sysrole;

import com.kunlun.api.common.annotations.AccessAnnotation;
import com.kunlun.api.common.result.BaseResult;
import com.kunlun.api.common.result.PageResult;
import com.kunlun.api.domain.SysRole;
import com.kunlun.api.service.sysrole.SysRoleService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kunlun on 2017/4/18.
 */
@RestController
@RequestMapping("role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 角色列表
     *
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @AccessAnnotation
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult list(Integer pageNo, Integer pageSize, String key) {
        return sysRoleService.list(pageNo, pageSize, key);
    }

    /**
     * 新增角色
     *
     * @param sysRole
     * @param validResult
     * @return
     */
    @AccessAnnotation
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@Validated SysRole sysRole, BindingResult validResult) {
        if (validResult.hasErrors()) {
            return BaseResult.error("param_error", validResult.getAllErrors().get(0).getDefaultMessage());
        }
        return sysRoleService.add(sysRole);
    }

    /**
     * 删除角色
     *
     * @return
     */
    @AccessAnnotation
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public BaseResult delete(String roleId) {
        if (StringUtils.isNullOrEmpty(roleId)) {
            return BaseResult.error("param_error", "请选择要删除的角色");
        }
        return sysRoleService.delete(roleId);
    }

    /**
     * 更新角色
     *
     * @return
     */
    @AccessAnnotation
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResult update(SysRole sysRole) {
        return sysRoleService.update(sysRole);
    }
}
