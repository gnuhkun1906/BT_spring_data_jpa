package ra.service.comment;

import ra.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> listComment();
    Comment findById(Long id);
    void save(Comment comment);
    void remove(Long id);
}
