package org.ok.bella.data.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.ok.bella.data.repository.es.EmployeeElasticsearchRepository;
import org.ok.bella.data.sample.SampleEmployeeProvider;
import org.ok.bella.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static java.lang.String.format;
import static org.hamcrest.Matchers.containsString;
import static org.ok.bella.data.controller.Paths.COUNT_PATH;
import static org.ok.bella.data.controller.Paths.EMPLOYEE_PATH;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private EmployeeElasticsearchRepository employeeElasticsearchRepository;

    @Autowired
    private SampleEmployeeProvider sampleEmployeeProvider;

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
                .andReturn();
        assertNotNull(mvcResult);
        employeeElasticsearchRepository.deleteAll(savedItems);
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
        MvcResult mvcResult = mvc.perform(get(format("/%s/%s", EMPLOYEE_PATH, id))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(log())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(id)))
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
                .andReturn();
        assertNotNull(mvcResult);
        employeeElasticsearchRepository.delete(item);
    }
}