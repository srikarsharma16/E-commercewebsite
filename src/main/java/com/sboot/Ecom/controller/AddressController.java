package com.sboot.Ecom.controller;

import com.sboot.Ecom.global.Globaldata;
import com.sboot.Ecom.model.Address;
import com.sboot.Ecom.model.CartProduct;
import com.sboot.Ecom.model.Customer;
import com.sboot.Ecom.service.AddressService;
import com.sboot.Ecom.service.CartService;
import com.sboot.Ecom.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;
    
    @Autowired
    private CartService cartService;

    @GetMapping("/deliveryAddress")
    public ModelAndView routToAddressPage() {

        ModelAndView modelAndView =new ModelAndView("deliveryAddress");

        return modelAndView;
    }

    /*
    @PostMapping("/address/{customerId}")
    public ModelAndView addAddress(Address address,@PathVariable int customerId){
        Globaldata.address=address;
        Address add=Globaldata.address;
        int i=0;
        if(Globaldata.i==1){
            for (CartProduct c : Globaldata.cartProducts) {
                

                address.setCountry(add.getCountry());
                address.setFullName(add.getFullName());
                address.setMobileNumber(add.getMobileNumber());
                address.setPinCode(add.getPinCode());
                address.setLandmark(add.getLandmark());
                address.setHouseNumber(add.getHouseNumber());
                address.setCity(add.getCity());
                address.setState(add.getState());
                address.setAddressType(add.getAddressType());


                address.setProdId(c.getProdId());
                address.setPrice(c.getProdPrice());
                address.setCustomerId(customerId);
                address.setQuantity(c.getProdQuantity());
                addressService.saveCustomerAddress(address);
                address=new Address();
                
                
                
                i++;
                System.out.println(i);
            }
            cartService.deleteByCustId(customerId);

        }else{
            address.setProdId(Globaldata.prod_id);
            address.setPrice(Globaldata.total);
            address.setQuantity(Globaldata.quantity);
            address.setCustomerId(customerId);
            addressService.saveCustomerAddress(address);

        }
        
        ModelAndView modelAndView =new ModelAndView("checkout");
        return modelAndView;
    }
    */
}
