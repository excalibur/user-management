package org.faith.management.core.entity;

import org.bson.types.ObjectId;

import java.util.Date;

/**
 * 高度抽象实体类
 *
 * 定义了系统欲行中实体的主要属性
 *
 * @author faith
 * @since 0.0.1
 */
public abstract class AbstractEntity<ID> {
    // id
    private ID id;
    // 创建日期
    private Date createDate = new Date();
    // 更新日期
    private Date updateDate = new Date();

    // 因为返回有String情况
    public Object getId() {
        if (id instanceof ObjectId)
            return id.toString();
        else if (id instanceof String)
            return id.toString();
        else
            return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;

        AbstractEntity that = (AbstractEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
