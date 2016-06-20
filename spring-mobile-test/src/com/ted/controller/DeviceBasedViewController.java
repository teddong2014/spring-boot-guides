package com.ted.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeviceBasedViewController {

    @RequestMapping("/device-based")
    public String deviceBased() {
        return "device_based_view";
    }

}
