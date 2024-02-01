package com.dj.codingdog.student.service.impl;

import com.dj.codingdog.student.model.Students;
import com.dj.codingdog.student.mapper.StudentsMapper;
import com.dj.codingdog.student.service.StudentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dj
 * @since 2024-01-29
 */
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students> implements StudentsService {

}
