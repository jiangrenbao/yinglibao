package com.bjpowernode.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class FinanceAccount implements Serializable {
    private static final long serialVersionUID = 8936025573259573194L;
    private Integer id;

    private Integer uId;

    private BigDecimal availableMoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public BigDecimal getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(BigDecimal availableMoney) {
        this.availableMoney = availableMoney;
    }
}