package com.sadeqtest.demo.securityDomain;

import javax.persistence.Entity;

@Entity
public class IllegalUserDomain extends UserTestDomain {
    private Long credit;
    private Long paymentMonthPeriod;

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
    }

    public Long getPaymentMonthPeriod() {
        return paymentMonthPeriod;
    }

    public void setPaymentMonthPeriod(Long paymentMonthPeriod) {
        this.paymentMonthPeriod = paymentMonthPeriod;
    }
}
