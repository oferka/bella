package org.ok.bella.ui.employees;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@Slf4j
public class ClientEmployeesDataProvider implements EmployeesDataProvider {

    @Override
    public int count() {
        return 31;
    }
}
