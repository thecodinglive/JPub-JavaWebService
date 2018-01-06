package info.thecodinglive.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private Integer zipCode;
    private String detail;

    public Address() {
    }

    public Address(Integer zipCode, String detail) {
        this.zipCode = zipCode;
        this.detail = detail;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public String getDetail() {
        return detail;
    }
}
