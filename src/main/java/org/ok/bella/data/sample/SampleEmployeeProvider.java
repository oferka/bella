package org.ok.bella.data.sample;

import org.ok.bella.model.Employee;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface SampleEmployeeProvider {

    @NotNull Employee getItem();

    @NotNull List<Employee> getItems(int numberOfItems);
}
