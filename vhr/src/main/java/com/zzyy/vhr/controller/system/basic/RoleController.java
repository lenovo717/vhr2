package com.zzyy.vhr.controller.system.basic;

import com.zzyy.vhr.model.Menu;
import com.zzyy.vhr.model.RespBean;
import com.zzyy.vhr.model.Role;
import com.zzyy.vhr.service.MenuService;
import com.zzyy.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/permiss")
public class RoleController {

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    @GetMapping("/")
    public List<Role> getAllRoles()
    {
      return   roleService.getAllRoles();
    }
    @GetMapping("/menus")
    public List<Menu> getAllMenus()
    {
        return menuService.getAllMenus();
    }

    @GetMapping("/mid/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid)
    {
        return menuService.getMidsByRid(rid);
    }

    @PutMapping("/role")
    public RespBean updateMenuRole(Integer rid, Integer[] mids)
    {
        if(menuService.updateMenuRole(rid,mids))
            return RespBean.ok("修改成功");
        return RespBean.error("修改失败");
    }

    @PostMapping("/role")
    public RespBean addMenuRole(@RequestBody Role role)
    {
        if(roleService.addMenuRole(role)==1)
            return RespBean.ok("添加成功");
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/role/{rid}")
    public RespBean deleteMenuRole(@PathVariable Integer rid)
    {
        if(roleService.deleteMenuRole(rid)==1)
            return RespBean.ok("删除成功");
        return RespBean.error("删除失败");
    }
}
