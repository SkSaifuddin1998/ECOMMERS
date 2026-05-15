package com.nt.ecom.tenat;

import com.nt.ecom.common.BaseEntity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tenant extends BaseEntity {

    private String companyName;

    private String subscriptionPlan;

    private String status;
}