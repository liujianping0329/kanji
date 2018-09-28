package com.goldhako.kanji.po;

import java.io.Serializable;
import java.util.Date;

/**
 * yys_kami_skill
 * @author 
 */
public class YysKamiSkill implements Serializable {
    private Integer id;

    private Integer value;

    /**
     * 等级 1D 2C 3B 4A 5S
     */
    private Integer level;

    private Integer type;

    private Integer kamiId;

    /**
     * 备注
     */
    private String remark;

    private Date createAt;

    private Date updateAt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getKamiId() {
        return kamiId;
    }

    public void setKamiId(Integer kamiId) {
        this.kamiId = kamiId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        YysKamiSkill other = (YysKamiSkill) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getKamiId() == null ? other.getKamiId() == null : this.getKamiId().equals(other.getKamiId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateAt() == null ? other.getCreateAt() == null : this.getCreateAt().equals(other.getCreateAt()))
            && (this.getUpdateAt() == null ? other.getUpdateAt() == null : this.getUpdateAt().equals(other.getUpdateAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getKamiId() == null) ? 0 : getKamiId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateAt() == null) ? 0 : getCreateAt().hashCode());
        result = prime * result + ((getUpdateAt() == null) ? 0 : getUpdateAt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", value=").append(value);
        sb.append(", level=").append(level);
        sb.append(", type=").append(type);
        sb.append(", kamiId=").append(kamiId);
        sb.append(", remark=").append(remark);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}