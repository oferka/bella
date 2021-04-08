package org.ok.bella.health;

import org.ok.bella.data.repository.es.EmployeeElasticsearchRepository;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("employee-health")
public class EmployeeHealthIndicator implements HealthIndicator {

    EmployeeElasticsearchRepository employeeElasticsearchRepository;

    public EmployeeHealthIndicator(EmployeeElasticsearchRepository employeeElasticsearchRepository) {
        this.employeeElasticsearchRepository = employeeElasticsearchRepository;
    }

    @Override
    public Health health() {
        Health.Builder status;
        try {
            long count = employeeElasticsearchRepository.count();
            status = Health.up();
            status.withDetail("count", count);
        }
        catch (Exception e) {
            status = Health.down();
        }
        return status.build();
    }
}
