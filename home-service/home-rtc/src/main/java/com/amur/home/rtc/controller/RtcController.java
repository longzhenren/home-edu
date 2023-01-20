package com.amur.home.rtc.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "实时音视频模块", description = "rtc")
@RestController
@RequestMapping("/rtc")
@Slf4j
public class RtcController {
}
