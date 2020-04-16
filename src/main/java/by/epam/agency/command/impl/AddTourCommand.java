package by.epam.agency.command.impl;

import by.epam.agency.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

public class AddTourCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Part part = request.getPart("image");
            if (part!=null){
                try {
                    //prepared st
                    InputStream inputStream = part.getInputStream();
                    //setBlob(1,inputStream);
                }catch (IOException e){

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return null;
    }
}
