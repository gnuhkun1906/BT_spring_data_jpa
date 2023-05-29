package ra.service.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.Blog;
import ra.repository.blog.IBlogRep;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRep blogRep;
    @Override
    public List<Blog> listBlog() {
        return blogRep.listBlog();
    }

    @Override
    public void createBlog(Blog blog) {
        blogRep.createBlog(blog);
    }

    @Override
    public void updateBlog(Blog blog) {

    }

    @Override
    public Blog findById(Long id) {
        return blogRep.findById(id);
    }

    @Override
    public void remove(Long id) {
            blogRep.remove(id);
    }
}
