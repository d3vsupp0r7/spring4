package org.lba.spring4.controller.file.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/multiple-file")
public class ProductController 
{
    @RequestMapping("/save-product")
    public String uploadResources( HttpServletRequest servletRequest, 
                                 @ModelAttribute Product product,
                                 Model model) 
    {// http://localhost:8080/spring4_db_war_all/multiple-file/save-product
        //Get the uploaded files and store them
        List<MultipartFile> files = product.getImages();
        List<String> fileNames = new ArrayList<String>();
        if (null != files && files.size() > 0) 
        {
            for (MultipartFile multipartFile : files) {
 
                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);
 
                File imageFile = new File(servletRequest.getServletContext().getRealPath("/image"), fileName);
                try
                {//C:\dev\applicationServer\tomcat\apache-tomcat-9.0.38_github\wtpwebapps\spring4_db_war_all\image
                    multipartFile.transferTo(imageFile);
                } catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        }
 
        // Here, you can save the product details in database
         
        model.addAttribute("product", product);
        return "multipleFileUpload/viewProductDetail";
    }
     
    @RequestMapping(value = "/product-input-form")
    public String inputProduct(Model model) {
    	// http://localhost:8080/spring4_db_war_all/multiple-file/product-input-form
        model.addAttribute("product", new Product());
        return "multipleFileUpload/productForm";
    }
}
