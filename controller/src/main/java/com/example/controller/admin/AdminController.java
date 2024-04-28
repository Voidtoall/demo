package com.example.controller.admin;

import com.example.common.response.Message;
import com.example.common.response.ResponseWrapper;
import com.example.controller.BaseController;
import com.example.domain.AdminUser;
import com.example.provider.AdminProvider;
import com.example.service.admin.IAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController extends BaseController {

    @Autowired
    IAdminUserService adminService;
    @Autowired
    AdminProvider adminProvider;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> getAdminUser(@RequestParam(value = "pageIndex", defaultValue = "0") int pageIndex,
                                      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

        return new ResponseEntity<>(new ResponseWrapper<>(Message.SUCCESS, null),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ResponseEntity<?> save(@RequestParam(value = "pageIndex", defaultValue = "0") int pageIndex,
                                      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        AdminUser adminUser = adminProvider.buildEntity();
        adminUser.setId(null);
        adminService.save(adminUser);
        return new ResponseEntity<>(new ResponseWrapper<>(Message.SUCCESS, null),
                HttpStatus.OK);
    }

}

