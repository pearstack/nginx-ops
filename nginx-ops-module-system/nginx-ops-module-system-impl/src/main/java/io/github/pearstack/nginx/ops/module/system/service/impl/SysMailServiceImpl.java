package io.github.pearstack.nginx.ops.module.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.pearstack.nginx.ops.module.system.pojo.SysMailDO;
import io.github.pearstack.nginx.ops.module.system.service.SysMailService;
import io.github.pearstack.nginx.ops.module.system.mapper.SysMailMapper;
import org.springframework.stereotype.Service;

/**
* @author lihao3
* @description 针对表【sys_mail】的数据库操作Service实现
* @createDate 2022-04-25 15:05:15
*/
@Service
public class SysMailServiceImpl extends ServiceImpl<SysMailMapper, SysMailDO>
    implements SysMailService{

}




