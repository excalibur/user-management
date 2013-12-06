package org.faith.management.core.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 高度抽象实体类
 *
 * 定义了系统欲行中实体的主要属性
 * 继承了Serializable接口方便序列化对象
 *
 * @author faith
 * @since 0.0.1
 */
public abstract class AbstractEntity<ID> implements Serializable {

    // 创建日期
    private Date createDate = new Date();
    // 更新日期
    private Date updateDate = new Date();


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


}
