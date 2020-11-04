package com.zzyy.vhr.controller.system.basic;

import com.zzyy.vhr.model.Position;
import com.zzyy.vhr.model.RespBean;
import com.zzyy.vhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {

    @Autowired
    PositionService positionService;
    @GetMapping("/")
    public List<Position> getAllPositions(){
        return positionService.getAllPositions();
    }

    @PostMapping("/")
    public RespBean addPosition(@RequestBody Position position){
        if(positionService.addPosition(position)==1)
            return RespBean.ok("添加成功!");
        else
            return RespBean.error("添加失败");

    }
    //更新
    @PutMapping("/")
    public RespBean updatePosition(@RequestBody Position position){
        if(positionService.updatePosition(position)==1)
            return RespBean.ok("更新成功!");
        else
            return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deletePositionById(@PathVariable  Integer id){
        if(positionService.deletePositionById(id)==1)
            return RespBean.ok("删除成功!");
        else
            return RespBean.error("删除失败");
    }

    @DeleteMapping("/")
    public RespBean deletePositionsByIds(Integer[] ids)
    {
        if(positionService.deletePositionsByIds(ids)==ids.length)
            return RespBean.ok("删除成功!");
        else
            return RespBean.error("删除失败");
    }
}
