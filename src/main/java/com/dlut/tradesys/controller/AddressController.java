package com.dlut.tradesys.controller;

import com.dlut.tradesys.common.pojo.Address;
import com.dlut.tradesys.common.pojo.result.Result;
import com.dlut.tradesys.service.AddressService;
import com.dlut.tradesys.utils.UserContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/address")
@RestController
@Slf4j
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/getAddress")
    public Result getAddress(){
        Long userId = UserContext.getUser();
        System.out.println("[AddressService] GetAddress : userId " + userId);
        Result result = addressService.getAddress(userId);
        if(result.getCode() == 200){
            System.out.println("[AddressService] GetAddress Succeeded.");
            return result;
        }
        System.out.println("[AddressService] GetAddress Failed.");
        return result;
    }

    @PostMapping("/addAddress")
    public Result addAddress(@RequestBody Address address){
        Long userId = UserContext.getUser();
        System.out.println("[AddressService] AddAddress : userId " + userId);
        Result result = addressService.addAddress(userId, address);
        if(result.getCode() == 200){
            System.out.println("[AddressService] AddAddress Succeeded.");
            return result;
        }
        System.out.println("[AddressService] AddAddress Failed.");
        return result;
    }

    @PutMapping("/modifyAddress")
    public Result modifyAddress(@RequestBody Address address){
        Long userId = UserContext.getUser();
        System.out.println("[AddressService] ModifyAddress : userId " + userId);
        Result result = addressService.modifyAddress(address);
        if(result.getCode() == 200){
            System.out.println("[AddressService] Address Modification Succeeded.");
            return result;
        }
        System.out.println("[AddressService] Address Modification Failed.");
        return result;
    }

    @DeleteMapping("/deleteAddress/{addressId}")
    public Result deleteAddress(@PathVariable Integer addressId){
        Long userId = UserContext.getUser();
        System.out.println("[AddressService] DeleteAddress : userId " + userId);
        Result result = addressService.deleteAddress(addressId);
        if(result.getCode() == 200){
            System.out.println("[AddressService] DeleteAddress Succeeded.");
            return result;
        }
        System.out.println("[AddressService] DeleteAddress Failed.");
        return result;
    }

    @PutMapping("/setDefaultAddress/{addressId}")
    public Result setDefaultAddress(@PathVariable Integer addressId){
        Long userId = UserContext.getUser();
        System.out.println("[AddressService] SetDefaultAddress : userId " + userId);
        Result result = addressService.setDefaultAddress(userId, addressId);
        if(result.getCode() == 200){
            System.out.println("[AddressService] SetDefaultAddress Succeeded.");
            return result;
        }
        System.out.println("[AddressService] SetDefaultAddress Failed.");
        return result;
    }
}
