package gx.controller;

import gx.domain.Account;
import gx.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class DemoControl {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/demo/findAll")
    public String findAll(Model model){
        System.out.println("demoController.....");
        List<Account> list = demoService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping("/demo/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        demoService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/demo/findAll");
    }
}
