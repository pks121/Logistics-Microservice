package com.example.Feedback.Service.dto;

import java.time.LocalDateTime;

public class FeedbackDto {

    private String email;

    private int rating;

    private String comments;

    private LocalDateTime submittedAt;

    public FeedbackDto() {
    }

    @Override
    public String toString() {
        return "FeedbackDto{" +
                "email='" + email + '\'' +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                ", submittedAt=" + submittedAt +
                '}';
    }

    public FeedbackDto(String email, int rating, String comments) {
        this.email = email;
        this.rating = rating;
        this.comments = comments;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}
