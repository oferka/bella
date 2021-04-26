package org.ok.bella.ui.employees;

import com.vaadin.flow.component.dependency.CssImport;
import org.ok.bella.model.Employee;
import org.ok.bella.ui.entities.EntitiesDataProvider;
import org.ok.bella.ui.entities.EntitiesViewBody;

import static org.ok.bella.ui.EntityType.EMPLOYEE;
import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.employees.EmployeesView.EMPLOYEES_ID_PREFIX;
import static org.ok.bella.ui.entities.EntitiesView.VIEW_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + EMPLOYEES_ID_PREFIX + "/" + EMPLOYEES_ID_PREFIX + VIEW_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EmployeesViewBody extends EntitiesViewBody<Employee> {

    public EmployeesViewBody(EntitiesDataProvider<Employee> entitiesDataProvider) {
        super(EMPLOYEE, entitiesDataProvider);
    }
}
