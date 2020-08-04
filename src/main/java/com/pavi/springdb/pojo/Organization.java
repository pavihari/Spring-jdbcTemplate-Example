package com.pavi.springdb.pojo;

public class Organization {
    private int id;
    private String companyName;
    private int yearsOfIncorporation;
    private String postalCode;
    private int employeeCount;
    private String slogan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getYearsOfIncorporation() {
        return yearsOfIncorporation;
    }

    public void setYearsOfIncorporation(int yearsOfIncorporation) {
        this.yearsOfIncorporation = yearsOfIncorporation;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", yearsOfIncorporation=" + yearsOfIncorporation +
                ", postalCode='" + postalCode + '\'' +
                ", employeeCount=" + employeeCount +
                ", slogan='" + slogan + '\'' +
                '}';
    }

    public Organization() {
    }

    public Organization(String companyName, int yearsOfIncorporation, String postalCode, int employeeCount, String slogan) {
        this.companyName = companyName;
        this.yearsOfIncorporation = yearsOfIncorporation;
        this.postalCode = postalCode;
        this.employeeCount = employeeCount;
        this.slogan = slogan;
    }
}
