// // // // package com.dj.codingdog.student.test;
//
// import com.alibaba.cola.dto.Response;
// import com.dj.codingdog.student.api.CustomerServiceI;
// import com.dj.codingdog.student.dto.CustomerAddCmd;
// import com.dj.codingdog.student.dto.data.CustomerDTO;
// import com.dj.codingdog.student.dto.data.ErrorCode;
// import com.dj.codingdog.student.Application;
// import org.junit.Assert;
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringRunner;
//
// /**
//  * This is for integration test.
//  *
//  * Created by fulan.zjf on 2017/11/29.
//  */
// @RunWith(SpringRunner.class)
// @SpringBootTest(classes = Application.class)
// public class CustomerServiceTest {
//
//     @Autowired
//     private CustomerServiceI customerService;
//
//
//     @Before
//     public void setUp() {
//
//     }
//
//     @Test
//     public void testCustomerAddSuccess(){
//         //1.prepare
//         CustomerAddCmd customerAddCmd = new CustomerAddCmd();
//         CustomerDTO customerDTO = new CustomerDTO();
//         customerDTO.setCompanyName("NormalName");
//         customerAddCmd.setCustomerDTO(customerDTO);
//
//         //2.execute
//         Response response = customerService.addCustomer(customerAddCmd);
//
//         //3.assert
//         Assert.assertTrue(response.isSuccess());
//     }
//
//     @Test
//     public void testCustomerAddCompanyNameConflict(){
//         //1.prepare
//         CustomerAddCmd customerAddCmd = new CustomerAddCmd();
//         CustomerDTO customerDTO = new CustomerDTO();
//         customerDTO.setCompanyName("ConflictCompanyName");
//         customerAddCmd.setCustomerDTO(customerDTO);
//
//         //2.execute
//         Response response = customerService.addCustomer(customerAddCmd);
//
//         //3.Exception
//         Assert.assertEquals(ErrorCode.B_CUSTOMER_companyNameConflict, response.getErrCode());
//
//     }
// }
