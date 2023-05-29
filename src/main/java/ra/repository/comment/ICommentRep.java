package ra.repository.comment;

import ra.model.Comment;

import java.util.List;

public interface ICommentRep {
    List<Comment> listComment();
    Comment findById(Long id);
    void save(Comment comment);
    void remove(Long id);

}
