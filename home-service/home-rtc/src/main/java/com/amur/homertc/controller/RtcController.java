package com.amur.homertc.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "实时音视频模块", tags = "rtc")
@RestController
@RequestMapping("/rtc")
@Slf4j
public class RtcController {
}
