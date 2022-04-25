package io.github.pearstack.nginx.ops.module.auth.server.impl;

import cn.hutool.core.util.IdUtil;
import com.wf.captcha.SpecCaptcha;
import io.github.pearstack.nginx.ops.module.auth.pojo.vo.CaptchaVO;
import io.github.pearstack.nginx.ops.module.auth.server.CaptchaServer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CaptchaServerImpl implements CaptchaServer {

  private final StringRedisTemplate stringRedisTemplate;

  @Override
  public CaptchaVO generateCaptcha() {
    // 生成验证码
    SpecCaptcha specCaptcha = new SpecCaptcha();
    String verCode = specCaptcha.text().toLowerCase();
    // 生成唯一ID
    String key = IdUtil.getSnowflake().nextIdStr();
    // 存入redis并设置过期时间为30分钟
    stringRedisTemplate.opsForValue().set(key, verCode, 30, TimeUnit.MINUTES);
    return CaptchaVO.builder().key(key).image(specCaptcha.toBase64()).build();
  }

  @Override
  public boolean isCheck(CaptchaVO captchaVO) {
    // 判断是否存在
    if (Boolean.TRUE.equals(
        stringRedisTemplate.opsForValue().getOperations().hasKey(captchaVO.getKey()))) {
      // 存在则判断内容是否一致
      return captchaVO
          .getImage()
          .trim()
          .toLowerCase()
          .equals(stringRedisTemplate.opsForValue().get(captchaVO.getKey()));
    }
    return false;
  }
}
