package com.amur.home.tinyid.factory;

import com.amur.home.tinyid.generator.IdGenerator;

/**
 * @author du_imba
 */
public interface IdGeneratorFactory {
    /**
     * 根据bizType创建id生成器
     *
     * @param bizType
     * @return
     */
    IdGenerator getIdGenerator(String bizType);
}
