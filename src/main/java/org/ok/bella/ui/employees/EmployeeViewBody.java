package org.ok.bella.ui.employees;

import com.vaadin.flow.component.dependency.CssImport;
import org.ok.bella.ui.entity.EntityViewBody;

import static org.ok.bella.ui.EntityType.EMPLOYEE;
import static org.ok.bella.ui.Styles.CSS_FILE_EXTENSION;
import static org.ok.bella.ui.Styles.VIEWS_FOLDER;
import static org.ok.bella.ui.employees.EmployeeView.EMPLOYEE_ID_PREFIX;
import static org.ok.bella.ui.employees.EmployeesView.EMPLOYEES_ID_PREFIX;
import static org.ok.bella.ui.entity.EntityViewBody.VIEW_BODY_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + EMPLOYEES_ID_PREFIX + "/" + EMPLOYEE_ID_PREFIX + VIEW_BODY_ID_SUFFIX + CSS_FILE_EXTENSION)
public class EmployeeViewBody extends EntityViewBody {

    public EmployeeViewBody() {
        super(EMPLOYEE);
    }
}
