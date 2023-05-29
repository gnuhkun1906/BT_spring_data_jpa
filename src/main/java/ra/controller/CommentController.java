package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.Comment;
import ra.service.comment.ICommentService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping("/findAll")
    public ModelAndView list() {
        ModelAndView mav= new ModelAndView("/comment/list");
        List<Comment> listCmm= commentService.listComment();
        LocalDate date= LocalDate.now();
        mav.addObject("listCmm", listCmm);
        mav.addObject("date",date);
        return mav;
    }
    @GetMapping("/showFormComment")
    public String form(Model model) {
       Comment comment= new Comment();
       model.addAttribute("newComment", comment);
       return "/comment/doComment";
    }

    @PostMapping("/createCmm")
    public String create(@ModelAttribute("newComment") Comment comment) {
        commentService.save(comment);
        return "redirect:/findAll";
    }
    @GetMapping("/like/{id}")
    public String likes(@PathVariable("id") Long id) {
        Comment c= commentService.findById(id);
        commentService.save(c);
        return "redirect:/findAll";
    }

}
