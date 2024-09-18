package com.example.controller;

import com.example.model.CreateOrderDTO;
import com.example.model.Order;
import com.example.model.OrderAndPaymentDTO;
import com.example.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    OrderService orderService;

    @MockBean
    OrderAndPaymentDTO orderAndPaymentDTO;

    @Test
    void createOrder_returnsOrderAndStatusOk() throws Exception {
        Mockito.when(this.orderService.createOrder(new CreateOrderDTO())).thenReturn(Order.builder().build());

        mvc.perform(MockMvcRequestBuilders
                .post("/api/v1/orders/createOrder")
                .content("{\n" +
                        "  \"deadLineOfOrder\": \"2024-09-18\",\n" +
                        "  \"sumToPay\": 300,\n" +
                        "  \"clientType\": \"PRIVATE_PERSON\"\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void pay_returnsOrderAndStatusOk() throws Exception {
        Mockito.when(this.orderService.pay(orderAndPaymentDTO.getOrder(), orderAndPaymentDTO.getPayments()))
                .thenReturn(Order.builder().build());

        mvc.perform(MockMvcRequestBuilders
                .post("/api/v1/orders/pay")
                .content("{\n" +
                        "  \"order\": {\n" +
                        "    \"companyName\": \"string\",\n" +
                        "    \"createTime\": \"2024-09-18T19:40:39.254Z\",\n" +
                        "    \"deadLineOfOrder\": \"2024-09-18\",\n" +
                        "    \"sum\": 0,\n" +
                        "    \"sumToPay\": 0,\n" +
                        "    \"change\": 0,\n" +
                        "    \"numberOfPayments\": 0,\n" +
                        "    \"clientType\": \"PRIVATE_PERSON\"\n" +
                        "  },\n" +
                        "  \"payments\": [\n" +
                        "    {\n" +
                        "      \"creationTime\": \"2024-09-18T19:40:39.254Z\",\n" +
                        "      \"sum\": 0\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}