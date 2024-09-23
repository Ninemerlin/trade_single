package com.dlut.tradesys.service.impl;

import com.dlut.tradesys.common.pojo.Address;
import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.mapper.AddressMapper;
import com.dlut.tradesys.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{
    private final AddressMapper addressMapper;

    @Override
    public Result getAddress(Long userId) {
        List<Address> u = addressMapper.getAddressesById(userId);
        if(u != null) {
            return Result.success().addMsg("地址查询成功.").addData("addressList",u);
        }
        return Result.fail().addMsg("地址查询失败.");
    }

    @Override
    public Result addAddress(Long userId, Address address) {
        if(addressMapper.getAddressesById(userId).isEmpty()) {
            address.setIsDefault(1);
        } else {
            address.setIsDefault(0);
        }
        address.setUserId(userId);
        if(addressMapper.addAddress(address)) {
            return Result.success().addMsg("地址添加成功.");
        }
        return Result.fail().addMsg("地址添加失败.");
    }

    @Override
    public Result modifyAddress(Address address) {
        if(addressMapper.modifyAddress(address)) {
            return Result.success().addMsg("地址修改成功.");
        }
        return Result.fail().addMsg("地址修改失败.");
    }

    @Override
    public Result deleteAddress(Integer addressId) {
        if(addressMapper.deleteAddress(addressId)) {
            return Result.success().addMsg("地址删除成功.");
        }
        return Result.fail().addMsg("地址删除失败.");
    }

    @Override
    public Result setDefaultAddress(Long userId, Integer addressId) {
        if(addressMapper.checkOwnership(userId, addressId) != null && addressMapper.removeDefaultAddress(userId) && addressMapper.setDefaultAddress(addressId)) {
            return Result.success().addMsg("修改默认地址成功.");
        }
        return Result.fail().addMsg("修改默认地址失败.");
    }
}
