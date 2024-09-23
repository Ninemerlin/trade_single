package com.dlut.tradesys.service.impl;

import com.dlut.tradesys.common.pojo.Shop;
import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.mapper.ShopMapper;
import com.dlut.tradesys.mapper.UserMapper;
import com.dlut.tradesys.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopMapper shopMapper;
    private final UserMapper userMapper;

    @Override
    public Result getShop(Long userId) {
        Integer userType = userMapper.getUserTypeById(userId);
        if(userType == 1) {
            return Result.fail().addMsg("买家无查询商店功能.");
        } else if(userType == 2) {
            List<Shop> s = shopMapper.getShopsById(userId);
            if(s != null) {
                return Result.success().addMsg("卖家商店查询成功.").addData("shopList",s);
            }
        } else if(userType == 3) {
            List<Shop> s = shopMapper.getAllShops();
            if(s != null) {
                return Result.success().addMsg("管理员商店查询成功.").addData("shopList",s);
            }
        }
        return Result.fail().addMsg("商店查询失败.");
    }

    @Override
    public Result addShop(Long userId, String name) {
        if(shopMapper.addShop(userId, name)) {
            return Result.success().addMsg("商店新建成功.");
        }
        return Result.fail().addMsg("商店新建失败.");
    }

    @Override
    public Result modifyShop(Long shopId, String name) {
        if(shopMapper.modifyShop(shopId, name)) {
            return Result.success().addMsg("商店修改成功.");
        }
        return Result.fail().addMsg("商店修改失败.");
    }

    @Override
    public Result deleteShop(Integer shopId) {
        if(shopMapper.deleteShop(shopId)) {
            // 商店相关商品删除逻辑 暂空

            return Result.success().addMsg("商店删除成功.");
        }
        return Result.fail().addMsg("商店删除失败.");
    }
}
