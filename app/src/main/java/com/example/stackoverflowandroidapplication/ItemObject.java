package com.example.stackoverflowandroidapplication;

class ItemObject{

    private String qutionTitle;
    private String qutionLink;
    private Boolean isAnswered;
    private String answerCount;
    private String typesActivit;

    public ItemObject(String qutionTitle, String qutionLink, Boolean isAnswered, String answerCount, String typesActivit) {
        this.qutionTitle = qutionTitle;
        this.qutionLink = qutionLink;
        this.isAnswered = isAnswered;
        this.answerCount = answerCount;
        this.typesActivit = typesActivit;
    }

    public String getQutionTitle() {
        return qutionTitle;
    }

    public void setQutionTitle(String qutionTitle) {
        this.qutionTitle = qutionTitle;
    }

    public String getQutionLink() {
        return qutionLink;
    }

    public void setQutionLink(String qutionLink) {
        this.qutionLink = qutionLink;
    }

    public Boolean getAnswered() {
        return isAnswered;
    }

    public void setAnswered(Boolean answered) {
        isAnswered = answered;
    }

    public String getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(String answerCount) {
        this.answerCount = answerCount;
    }

    public String getTypesActivit() {
        return typesActivit;
    }

    public void setTypesActivit(String typesActivit) {
        this.typesActivit = typesActivit;
    }
}