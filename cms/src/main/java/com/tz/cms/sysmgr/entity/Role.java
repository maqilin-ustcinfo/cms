package com.tz.cms.sysmgr.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Demo class
 *
 * @author keriezhang
 * @date 2016/10/31
 */
public class Role implements Serializable {
    private Long id;

    private String name;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}