package com.dlut.tradesys.service;

import com.dlut.tradesys.common.pojo.Address;
import com.dlut.tradesys.common.pojo.result.Result;

public interface AddressService {
    Result getAddress(Long userId);

    Result addAddress(Long userId, Address address);

    Result modifyAddress(Address address);

    Result deleteAddress(Integer addressId);

    Result setDefaultAddress(Long userId, Integer addressId);
}
