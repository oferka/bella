package org.ok.bella.info;

import org.ok.bella.data.repository.es.EmployeeElasticsearchRepository;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EmployeeInfoContributor implements InfoContributor {

    EmployeeElasticsearchRepository employeeElasticsearchRepository;

    public EmployeeInfoContributor(EmployeeElasticsearchRepository employeeElasticsearchRepository) {
        this.employeeElasticsearchRepository = employeeElasticsearchRepository;
    }

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Long> employeeDetails = new HashMap<>();
        employeeDetails.put("count", employeeElasticsearchRepository.count());
        builder.withDetail("employee", employeeDetails);
    }
}
