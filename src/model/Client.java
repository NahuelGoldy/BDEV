package model;

public class Client {

    private String personId, name, lastName, currentRole, country, industry;
    private int numberOfRecommendations, numberOfConnections;
    private boolean isPotentialTarget;

    public static class Builder {

        private String personId, name, lastName, currentRole, country, industry;
        private int numberOfRecommendations, numberOfConnections;

        public Builder(String personId) {
            this.personId = personId;
        }

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder withRole(String role){
            this.currentRole = role;
            return this;
        }

        public Builder atCountry(String country){
            this.country = country;
            return this;
        }

        public Builder inIndustry(String industry){
            this.industry = industry;
            return this;
        }

        public Builder withNumberOfRecommendations(int recomms){
            this.numberOfRecommendations = recomms;
            return this;
        }

        public Builder withNumberOfConnections(int conns){
            this.numberOfConnections = conns;
            return this;
        }

        public Client build() {
            Client client = new Client();
            client.personId = this.personId;
            client.name = this.name;
            client.lastName = this.lastName;
            client.currentRole = this.currentRole;
            client.country = this.country;
            client.industry = this.industry;
            client.numberOfConnections = this.numberOfConnections;
            client.numberOfRecommendations = this.numberOfRecommendations;
            client.isPotentialTarget = (this.currentRole.toLowerCase().contains("manager")
                                        || this.currentRole.toLowerCase().contains("founder")
                                        || this.currentRole.toLowerCase().contains("manager")
                                        || this.currentRole.toLowerCase().contains("chief")
                                        || this.currentRole.toLowerCase().contains("president")
                                        || this.currentRole.toLowerCase().contains("information technology")
                                        ) ? true : false;
            return client;
        }

    }

    private Client() { }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCurrentRole() {
        return currentRole;
    }

    public void setCurrentRole(String currentRole) {
        this.currentRole = currentRole;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getNumberOfRecommendations() {
        return numberOfRecommendations;
    }

    public void setNumberOfRecommendations(int numberOfRecommendations) {
        this.numberOfRecommendations = numberOfRecommendations;
    }

    public int getNumberOfConnections() {
        return numberOfConnections;
    }

    public void setNumberOfConnections(int numberOfConnections) {
        this.numberOfConnections = numberOfConnections;
    }

    public boolean isPotentialTarget() {
        return isPotentialTarget;
    }

    public void setPotentialTarget(boolean potentialTarget) {
        isPotentialTarget = potentialTarget;
    }
}
