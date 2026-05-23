/**
 * UserController的单元测试类
 */
package com.amur.home.user.controller;

import com.amur.home.user.entity.UserInfo;
import com.amur.home.user.service.UserService;
import com.amur.home.util.ServiceResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest {
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    /**
     * 在每个测试方法运行之前创建一个MockMvc实例，并初始化userService的mock对象
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController(userService)).build();
    }

    /**
     * 测试获取用户信息的方法
     *
     * @throws Exception 异常
     */
    @Test
    public void testGetUserInfo() throws Exception {
        Long userId = 123L;
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userId);
        userInfo.setName("test");
        ServiceResult<UserInfo> serviceResult = ServiceResult.success(userInfo);
        when(userService.getUserInfo(userId)).thenReturn(serviceResult);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/info")
                        .param("userId", String.valueOf(userId)))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    /**
     * 测试更新用户信息的方法
     *
     * @throws Exception 异常
     */
    @Test
    public void testUpdateUser() throws Exception {
        when(userService.updateUser(anyLong(), anyString(), anyString(), anyString(), anyString(), anyString(), any(), any()))
                .thenReturn(ServiceResult.success());

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/update")
                        .param("userId", "123")
                        .param("description", "test desc")
                        .param("phone", "13800000000")
                        .param("email", "test@example.com")
                        .param("avatarUrl", "http://example.com/avatar.png")
                        .param("sex", "男")
                        .param("age", "25"))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    /**
     * 测试删除用户的方法
     *
     * @throws Exception 异常
     */
    @Test
    public void testDeleteUser() throws Exception {
        Long userId = 123L;

        when(userService.deleteUser(userId)).thenReturn(ServiceResult.success());

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/user/delete")
                        .param("userId", String.valueOf(userId)))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}
