package org.ok.bella.ui.employees;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClientEmployeesDataProvider implements EmployeesDataProvider {

    @Override
    public long count() {
        return 31;
    }
}
