package org.ok.bella.data.sample;

import org.ok.bella.model.Employee;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

@Service
public class MockSampleEmployeeProvider implements SampleEmployeeProvider {

    @Override
    public @NotNull Employee getItem() {
        return getItem(1);
    }

    @Override
    public @NotNull List<Employee> getItems(int numberOfItems) {
        List<Employee> result = new ArrayList<>();
        for(int i=0; i<numberOfItems; i++) {
            result.add(getItem(i+1));
        }
        return result;
    }

    private @NotNull Employee getItem(int itemNumber) {
        String id = UUID.randomUUID().toString();
        String name = format("employee %s", itemNumber);
        return new Employee(id, name);
    }
}
