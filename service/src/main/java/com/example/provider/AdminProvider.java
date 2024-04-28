package com.example.provider;

import com.example.common.kit.RandomDataGeneratorKit;
import com.example.domain.AdminUser;
import org.springframework.stereotype.Component;

@Component
public class AdminProvider extends BaseProvider{

    public AdminUser buildEntity() {
        return RandomDataGeneratorKit.generateRandomData(new AdminUser());
    }
}
