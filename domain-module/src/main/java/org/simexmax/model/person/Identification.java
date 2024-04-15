package org.simexmax.model.person;

/**
 * Represents an identification document.
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public class Identification {

    /**
     * Type of identification
     */
    private final IdentificationType type;
    /**
     * Identification number.
     */
    private final String number;
    /**
     * Date when this identification was issued.
     */
    private final Long issueDate;
    /**
     * Date when this identification became valid (optional).
     */
    private final Long validFromDate;
    /**
     * Date when this identification expired (optional).
     */
    private final Long expirationDate;
    /**
     * Indicates if it's currently active
     */
    private final Boolean isActive;

    public Identification(IdentificationType type, String number, Long issueDate, Long validFromDate,
                          Long expirationDate, Boolean isActive) {
        this.type = type;
        this.number = number;
        this.issueDate = issueDate;
        this.validFromDate = validFromDate;
        this.expirationDate = expirationDate;
        this.isActive = isActive;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private IdentificationType type;
        private String number;
        private Long issueDate;
        private Long validFromDate;
        private Long expirationDate;
        private Boolean isActive;

        public Builder() {
        }

        public Builder number(String number) {
            this.number = number;
            return this;
        }

        public Builder issueDate(Long issueDate) {
            this.issueDate = issueDate;
            return this;
        }

        public Builder validFromDate(Long validFromDate) {
            this.validFromDate = validFromDate;
            return this;
        }

        public Builder expirationDate(Long expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Builder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder type(IdentificationType type) {
            this.type = type;
            return this;
        }

        public Identification build() {
            return new Identification(type, number, issueDate, validFromDate, expirationDate, isActive);
        }
    }

    public IdentificationType getType() {
        return type;
    }


    public String getNumber() {
        return number;
    }


    public Long getIssueDate() {
        return issueDate;
    }


    public Long getValidFromDate() {
        return validFromDate;
    }


    public Long getExpirationDate() {
        return expirationDate;
    }


    public Boolean isActive() {
        return isActive;
    }

}
