package ra.repository.blog;

import org.springframework.transaction.annotation.Transactional;
import ra.model.Blog;
import ra.repository.blog.IBlogRep;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Transactional
public class BlogRep implements IBlogRep {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Blog> listBlog() {
        TypedQuery<Blog> query= entityManager.createQuery("select b from Blog as b", Blog.class);
        return query.getResultList();
    }

    @Override
    public void createBlog(Blog blog) {
        if (blog.getId() != null){
            entityManager.merge(blog);
        }else {
            entityManager.persist(blog);
        }
    }

    @Override
    public void updateBlog(Blog blog) {
    }

    @Override
    public Blog findById(Long id) {
        TypedQuery<Blog> query= entityManager.createQuery("select b from Blog as b where b.id=:id", Blog.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void remove(Long id) {
        entityManager.remove(findById(id));
    }
}
