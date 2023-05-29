package ra.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int Evaluate;
    private LocalDate date;
    private String author;
    private String feedback;
    private int likes;

    public Comment() {
    }

    public Comment(Long id, int evaluate, String author, String feedback, int likes,LocalDate date) {
        this.id = id;
        Evaluate = evaluate;
        this.author = author;
        this.feedback = feedback;
        this.likes = likes;
        this.date=LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEvaluate() {
        return Evaluate;
    }

    public void setEvaluate(int evaluate) {
        Evaluate = evaluate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
