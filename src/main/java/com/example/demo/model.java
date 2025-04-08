package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) // GEEN IDEE ?? ZAT IN VOORBEELD
public class model {
    @JsonProperty("id")
    private long id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("billingCity")
    private String billingCity;

    @JsonProperty("language")
    private String language;

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override // NIET PERSEE NODIG ? WAS VOOR PRINTING TEST..
    public String toString() {
        return "UserSummary{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", billingCity='" + billingCity + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
