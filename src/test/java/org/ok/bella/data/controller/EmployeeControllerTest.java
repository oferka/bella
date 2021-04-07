package org.ok.bella.data.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ok.bella.Application;
import org.ok.bella.data.repository.es.EmployeeElasticsearchRepository;
import org.ok.bella.data.sample.SampleEmployeeProvider;
import org.ok.bella.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.ok.bella.data.controller.Paths.COUNT_PATH;
import static org.ok.bella.data.controller.Paths.EMPLOYEE_PATH;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.util.StringUtils.collectionToDelimitedString;

@ExtendWith({ RestDocumentationExtension.class, SpringExtension.class })
@SpringBootTest(classes = Application.class)
class EmployeeControllerTest {

    private MockMvc mvc;

    @Autowired
    private EmployeeElasticsearchRepository employeeElasticsearchRepository;

    @Autowired
    private SampleEmployeeProvider sampleEmployeeProvider;

    @BeforeEach
    public void setup(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .build();
    }

    @Test
    public void shouldFindAll() throws Exception {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeElasticsearchRepository.saveAll(items);
        MvcResult mvcResult = mvc.perform(get(format("/%s", EMPLOYEE_PATH))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(log())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(String.valueOf(numberOfItems))))
                .andDo(document("findAll"))
                .andReturn();
        assertNotNull(mvcResult);
        employeeElasticsearchRepository.deleteAll(savedItems);
    }

    @Test
    public void shouldFindById() throws Exception {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeElasticsearchRepository.saveAll(items);
        String id = items.get(0).getId();
        ConstraintDescriptions constraintDescriptions = new ConstraintDescriptions(Employee.class);
        MvcResult mvcResult = mvc.perform(get(format("/%s/{id}", EMPLOYEE_PATH), id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(log())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(id)))
                .andDo(
                        document(
                                "findById",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                pathParameters(parameterWithName("id").description("id of employee to be found")),
                                responseFields(
                                    fieldWithPath("id").description("The id of the employee" + collectionToDelimitedString(constraintDescriptions.descriptionsForProperty("id"), ". ")),
                                    fieldWithPath("name").description("The name of the employee")
                                )
                        )
                )
                .andReturn();
        assertNotNull(mvcResult);
        employeeElasticsearchRepository.deleteAll(savedItems);
    }

    @Test
    public void shouldSave() throws Exception {
        Employee item = sampleEmployeeProvider.getItem();
        MvcResult mvcResult = mvc.perform(post(format("/%s", EMPLOYEE_PATH))
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(item))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(log())
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString(item.getId())))
                .andDo(
                        document("save",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                requestFields(fieldWithPath("id").description("The id of the employee"),
                                        fieldWithPath("name").description("The name of the employee")
                                )
                        )
                )
                .andReturn();
        assertNotNull(mvcResult);
        employeeElasticsearchRepository.delete(item);
    }

    @Test
    public void shouldDeleteById() throws Exception {
        Employee item = sampleEmployeeProvider.getItem();
        Employee saved = employeeElasticsearchRepository.save(item);
        String id = saved.getId();
        MvcResult mvcResult = mvc.perform(delete(format("/%s/{id}", EMPLOYEE_PATH), id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(log())
                .andExpect(status().isNoContent())
                .andDo(document("deleteById", pathParameters(parameterWithName("id").description("The id of the employee to delete"))))
                .andReturn();
        assertNotNull(mvcResult);
        boolean exists = employeeElasticsearchRepository.existsById(id);
        assertFalse(exists);
    }

    @Test
    public void shouldUpdate() throws Exception {
        Employee item = sampleEmployeeProvider.getItem();
        Employee saved = employeeElasticsearchRepository.save(item);
        String id = saved.getId();
        MvcResult mvcResult = mvc.perform(put(format("/%s/%s", EMPLOYEE_PATH, id))
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(item))
                .accept(MediaType.APPLICATION_JSON))
                .andDo(log())
                .andExpect(status().isOk())
                .andDo(document("update"))
                .andReturn();
        assertNotNull(mvcResult);
        Optional<Employee> updated = employeeElasticsearchRepository.findById(id);
        assertTrue(updated.isPresent());
        employeeElasticsearchRepository.deleteById(id);
    }

    @Test
    public void shouldCount() throws Exception {
        int numberOfItems = 10;
        List<Employee> items = sampleEmployeeProvider.getItems(numberOfItems);
        Iterable<Employee> savedItems = employeeElasticsearchRepository.saveAll(items);
        MvcResult mvcResult = mvc.perform(get(format("/%s/%s", EMPLOYEE_PATH, COUNT_PATH))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(log())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(String.valueOf(numberOfItems))))
                .andDo(document("count"))
                .andReturn();
        assertNotNull(mvcResult);
        employeeElasticsearchRepository.deleteAll(savedItems);
    }
}