package ra.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.Comment;
import ra.repository.comment.ICommentRep;

import javax.xml.ws.Action;
import java.util.List;
@Service
public class CommentService implements ICommentService{
    @Autowired
    private ICommentRep commentRep;
    @Override
    public List<Comment> listComment() {
        return commentRep.listComment();
    }

    @Override
    public Comment findById(Long id) {
        return commentRep.findById(id);
    }

    @Override
    public void save(Comment comment) {
        commentRep.save(comment);
    }

    @Override
    public void remove(Long id) {
    commentRep.remove(id);
    }
}
