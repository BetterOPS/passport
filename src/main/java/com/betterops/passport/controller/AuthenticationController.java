package com.betterops.passport.controller;

import com.betterops.passport.types.JwtAuthenticationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthenticationController {


    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<?> createToken(@RequestBody JwtAuthenticationRequest request,
                                         Device device) {
        return ResponseEntity.ok(null);
    }
}
