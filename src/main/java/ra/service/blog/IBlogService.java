package ra.service.blog;

import ra.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> listBlog();
    void createBlog(Blog blog);
    void updateBlog(Blog blog);
    Blog findById(Long id);
    void remove(Long id);
}
