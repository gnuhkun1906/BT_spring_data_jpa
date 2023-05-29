package ra.repository.comment;

import org.springframework.transaction.annotation.Transactional;
import ra.model.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Transactional
public class CommentRep implements ICommentRep{
@PersistenceContext
private EntityManager entityManager;

    @Override
    public List<Comment> listComment() {
        TypedQuery<Comment> query= entityManager.createQuery("select c from Comment as c", Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment findById(Long id) {
        TypedQuery<Comment> query= entityManager.createQuery("select c from Comment as c where c.id=:id",Comment.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(Comment comment) {
        if (comment.getId()!=null){
            entityManager.merge(comment);
        }else {
            entityManager.persist(comment);
        }
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(findById(id));
    }
}
