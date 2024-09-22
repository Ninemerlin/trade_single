package com.dlut.tradesys.service.impl;

import com.dlut.tradesys.common.pojo.Address;
import com.dlut.tradesys.common.pojo.Shop;
import com.dlut.tradesys.common.pojo.Spec;
import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.mapper.SpecMapper;
import com.dlut.tradesys.service.SpecService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecServiceImpl implements SpecService {
    private final SpecMapper specMapper;

    @Override
    public Result getSpec(Long itemId) {
        List<Spec> s = specMapper.getSpec(itemId);
        if(s != null) {
            return Result.success().addMsg("规格查询成功.").addData("specList",s);
        }
        return Result.fail().addMsg("规格查询失败.");
    }

    @Override
    public Result addSpec(Long itemId, String name) {
        if(specMapper.addSpec(itemId, name)) {
            return Result.success().addMsg("规格添加成功.");
        }
        return Result.fail().addMsg("规格添加失败.");
    }

    @Override
    public Result deleteSpec(Long specId) {
        if(specMapper.deleteSpec(specId)) {
            return Result.success().addMsg("规格删除成功.");
        }
        return Result.fail().addMsg("规格删除失败.");
    }
}
