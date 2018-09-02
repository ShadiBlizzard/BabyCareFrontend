package model;

public class Review {

    private float rating = 0;
    private String title, text;
    private String reviewed_bs;

    public Review (float rating, String title, String reviewed_bs, String text) {
        this.rating=rating;
        this.title=title;
        this.reviewed_bs=reviewed_bs;
        this.text=text;
    }

    public float getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getReviewed_bs() {
        return reviewed_bs;
    }
}
