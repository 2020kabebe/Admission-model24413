package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.Student;
import dao.StudentDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String firstName = request.getParameter("firstName");
        
        String lastName = request.getParameter("lastName");
        
        String dateOfBirthStr = request.getParameter("dateOfBirth");
        
        String gender = request.getParameter("gender");
        
        String email = request.getParameter("email");
        
        String phoneNumber = request.getParameter("phoneNumber");
        
        String address = request.getParameter("address");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth = null;
        try {
            dateOfBirth = (Date) dateFormat.parse(dateOfBirthStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Student studentToSave = new Student();
        
        studentToSave.setFirstName(firstName);
        
        studentToSave.setLastName(lastName);
        
        studentToSave.setDateOfBirth(dateOfBirth);
        
        studentToSave.setGender(gender);
        
        studentToSave.setEmail(email);
        
        studentToSave.setPhoneNumber(phoneNumber);
        
        studentToSave.setAddress(address);

        StudentDAO studentDao = new StudentDAO();
        studentDao.register(studentToSave);

        response.sendRedirect("response.html");
    }
}
