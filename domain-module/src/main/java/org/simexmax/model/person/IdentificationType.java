package org.simexmax.model.person;

/**
 * Represents a type of identification (e.g., "Cédula," "Pasaporte").
 *
 * @author Hardy Ryan Chingal Martinez <ryan.chingal@gmail.com>
 */
public class IdentificationType {

    /**
     * The name of the identification type.
     */
    private String name;
    /**
     * A description of the identification type.
     */
    private String description;
    /**
     * The initials or abbreviation of the identification type.
     */
    private String initials;

    public IdentificationType(String name, String initials) {
        this.name = name;
        this.initials = initials;
    }

    public IdentificationType(String name, String description, String initials) {
        this.name = name;
        this.description = description;
        this.initials = initials;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String description;
        private String initials;
        public Builder() {}

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder initials(String initials) {
            this.initials = initials;
            return this;
        }

        public IdentificationType build() {
            return new IdentificationType(name, description, initials);
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }
}
