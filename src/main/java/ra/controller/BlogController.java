package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.Blog;
import ra.service.blog.IBlogService;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public ModelAndView showListBlog() {
        ModelAndView mav = new ModelAndView("/blog/listBlog");
        List<Blog> listBlog = blogService.listBlog();
        mav.addObject("blog", listBlog);
        return mav;
    }

    @GetMapping("/showFormCreate")
    public String showFormCreate(Model model) {
        Blog newBlog = new Blog();
        model.addAttribute("newBlog", newBlog);
        return "/blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("newBlog") Blog newBlog) {
        blogService.createBlog(newBlog);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        blogService.remove(id);
        return "redirect:/";
    }
    @GetMapping("/showFormEdit/{id}")
    public String showFormEdit(@PathVariable("id") Long id,Model model) {
        Blog newBlog = blogService.findById(id);
        model.addAttribute("newBlog", newBlog);
        return "/blog/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("newBlog") Blog blog) {
        blogService.createBlog(blog);
        return "redirect:/";
    }

}
