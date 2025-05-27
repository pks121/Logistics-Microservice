package com.example.Feedback.Service.dto;

public class Response {

    private String mssg;

    private FeedbackDto feedbackDto;

    public Response() {
    }

    public Response(String mssg, FeedbackDto feedbackDto) {
        this.mssg = mssg;
        this.feedbackDto = feedbackDto;
    }

    public String getMssg() {
        return mssg;
    }

    public void setMssg(String mssg) {
        this.mssg = mssg;
    }

    public FeedbackDto getFeedbackDto() {
        return feedbackDto;
    }

    public void setFeedbackDto(FeedbackDto feedbackDto) {
        this.feedbackDto = feedbackDto;
    }

    @Override
    public String toString() {
        return "Response{" +
                "mssg='" + mssg + '\'' +
                ", feedbackDto=" + feedbackDto +
                '}';
    }
}
