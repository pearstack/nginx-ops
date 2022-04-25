package io.github.pearstack.nginx.ops.module.system.pojo.vo;

import cn.hutool.system.HostInfo;
import cn.hutool.system.JavaRuntimeInfo;
import cn.hutool.system.RuntimeInfo;
import cn.hutool.system.SystemUtil;
import cn.hutool.system.oshi.CpuInfo;
import cn.hutool.system.oshi.OshiUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import oshi.hardware.GlobalMemory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@Getter
@Builder
@ToString
@ApiModel("系统监控实体类")
public class Server {

  /** CPU相关信息 */
  @ApiModelProperty("CPU相关信息")
  private Cpu cpu;

  /** 內存相关信息 */
  @ApiModelProperty("內存相关信息")
  private Mem mem;

  /** JVM相关信息 */
  @ApiModelProperty("JVM相关信息")
  private Jvm jvm;

  /** 服务器相关信息 */
  @ApiModelProperty("服务器相关信息")
  private Sys sys;

  /** 磁盘相关信息 */
  @ApiModelProperty("磁盘相关信息")
  private List<SysFile> sysFiles;

  public static Server init() {
    // 获取CPU信息
    CpuInfo cpuInfo = OshiUtil.getCpuInfo();
    // 获取内存信息
    GlobalMemory memory = OshiUtil.getMemory();
    // 获取JVM信息
    RuntimeInfo runtimeInfo = SystemUtil.getRuntimeInfo();
    JavaRuntimeInfo javaRuntimeInfo = SystemUtil.getJavaRuntimeInfo();
    // 获取网卡信息
    HostInfo hostInfo = SystemUtil.getHostInfo();

    List<SysFile> sysFiles = new ArrayList<>();
    OshiUtil.getOs()
        .getFileSystem()
        .getFileStores()
        .forEach(
            item ->
                sysFiles.add(
                    SysFile.builder()
                        .dirName(item.getMount())
                        .typeName(item.getType())
                        .total(item.getTotalSpace())
                        .free(item.getFreeSpace())
                        .used(item.getUsableSpace())
                        .usage(item.getUsableSpace() / item.getTotalSpace())
                        .build()));
    return Server.builder()
        .cpu(
            Cpu.builder()
                .cpuNum(cpuInfo.getCpuNum())
                .total(cpuInfo.getToTal())
                .sys(cpuInfo.getSys())
                .user(cpuInfo.getUser())
                .wait(cpuInfo.getWait())
                .free(cpuInfo.getFree())
                .build())
        .mem(
            Mem.builder()
                .total(memory.getTotal())
                .used(memory.getTotal() - memory.getAvailable())
                .free(memory.getAvailable())
                .build())
        .jvm(
            Jvm.builder()
                .total(runtimeInfo.getTotalMemory())
                .max(runtimeInfo.getMaxMemory())
                .free(runtimeInfo.getFreeMemory())
                .version(javaRuntimeInfo.getVersion())
                .home(javaRuntimeInfo.getHomeDir())
                .build())
        .sys(
            Sys.builder()
                .computerName(hostInfo.getName())
                .computerIp(hostInfo.getAddress())
                .osName(SystemUtil.OS_NAME)
                .osArch(SystemUtil.OS_ARCH)
                .userDir(SystemUtil.USER_DIR)
                .build())
        .sysFiles(sysFiles)
        .build();
  }
}
