package com.Angle.ruiji5.controller;

import com.Angle.ruiji5.common.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author: 启文
 * @date: 2023年09月04日 14:13
 */
@RestController
@RequestMapping("/page")
public class PageController {
    public R<Page> page(){
        return null;
    }
}
