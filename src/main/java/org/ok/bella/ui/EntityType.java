package org.ok.bella.ui;

import com.vaadin.flow.component.icon.VaadinIcon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.ok.bella.ui.employees.EmployeeView;
import org.ok.bella.ui.employees.EmployeesView;
import org.ok.bella.ui.entities.EntitiesView;
import org.ok.bella.ui.entity.EntityView;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.vaadin.flow.component.icon.VaadinIcon.HANDS_UP;
import static org.ok.bella.ui.employees.EmployeeView.EMPLOYEE_ID_PREFIX;
import static org.ok.bella.ui.employees.EmployeeView.EMPLOYEE_VIEW_NAME;
import static org.ok.bella.ui.employees.EmployeesView.*;

@ToString
@AllArgsConstructor
public enum EntityType {

    EMPLOYEE (
            "Employee",
            "Employees",
            EMPLOYEES_ROUTE,
            EMPLOYEES_ID_PREFIX,
            EMPLOYEE_ID_PREFIX,
            EMPLOYEES_VIEW_NAME,
            EMPLOYEE_VIEW_NAME,
            "Employees view description",
            "Employee view description",
            HANDS_UP,
            EmployeesView.class,
            EmployeeView.class
    );

    @Getter
    @NotNull
    @Size(min = 2, max = 16)
    @NotBlank
    private final String entityName;

    @Getter
    @NotNull
    @Size(min = 2, max = 16)
    @NotBlank
    private final String entitiesName;

    @Getter
    @NotNull
    @Size(min = 2, max = 16)
    @NotBlank
    private final String route;

    @Getter
    @NotNull
    @Size(min = 2, max = 16)
    @NotBlank
    private final String entitiesIdPrefix;

    @Getter
    @NotNull
    @Size(min = 2, max = 16)
    @NotBlank
    private final String entityIdPrefix;

    @Getter
    @NotNull
    @Size(min = 2, max = 16)
    @NotBlank
    private final String entitiesViewName;

    @Getter
    @NotNull
    @Size(min = 2, max = 16)
    @NotBlank
    private final String entityViewName;

    @Getter
    @NotNull
    @Size(min = 2, max = 128)
    @NotBlank
    private final String entitiesViewDescription;

    @Getter
    @NotNull
    @Size(min = 2, max = 128)
    @NotBlank
    private final String entityViewDescription;

    @Getter
    @NotNull
    private final VaadinIcon entitiesViewIcon;

    @Getter
    @NotNull
    private final Class<? extends EntitiesView> entitiesViewClass;

    @Getter
    @NotNull
    private final Class<? extends EntityView> entityViewClass;
}
