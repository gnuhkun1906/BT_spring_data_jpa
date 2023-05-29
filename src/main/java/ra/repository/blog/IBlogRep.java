package ra.repository.blog;

import ra.model.Blog;

import java.util.List;

public interface IBlogRep {
    List<Blog> listBlog();
    void createBlog(Blog blog);
    void updateBlog(Blog blog);
    Blog findById(Long id);
    void remove(Long id);
}
