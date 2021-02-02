package com.lcj.servicebase.config.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author：LCJ
 * @Description：
 * @Date：Create in 21:28 2021/2/2 0002
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //属性名称
        this.setFieldValByName("gntCreate",new Date(),metaObject);
        this.setFieldValByName("gntModified",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gntModified",new Date(),metaObject);

    }
}
