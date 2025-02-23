package model;

import java.io.File;
import java.time.LocalDate;

import javax.servlet.http.Part;

import util.StringUtils;

public class UserModel {
	private String firstName;
	private String lastName;
	private String username;
	private LocalDate dob;
	private String gender;
	private String phoneNumber;
	private String email;
	private String address;
	private String password;
	private String imageUrlFromPart;	

    // Default constructor
	public UserModel() {}

	// Constructor with parameter
	public UserModel(String firstName, String lastName, String username, LocalDate dob, String gender, 
			String phoneNumber, String email, String address, String password, Part imagePart) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.dob = dob;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.password = password;
		this.setImageUrlFromPart(getImageUrl(imagePart)); // Set image URL from Part
	}

    // Getters and setters for user attributes

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getImageUrlFromPart() {
		return imageUrlFromPart;
	}

	public void setImageUrlFromPart(String imageUrlFromPart) {
		this.imageUrlFromPart = imageUrlFromPart;
	}
	
    // Method to get image URL from Part
	private String getImageUrl(Part part) {
		// Directory to save images
        String savePath = StringUtils.IMAGE_DIR_SAVE_PATH_USER;
        File fileSaveDir = new File(savePath);
        String imageUrlFromPart = null;
        // Create directory if it doesn't exist
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        // Extract image file name from Part
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                imageUrlFromPart = s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        // If image file name is not found, use default name
        if (imageUrlFromPart == null || imageUrlFromPart.isEmpty()) {
            imageUrlFromPart = "download.jpg";
        }
        return imageUrlFromPart;
    }	
	
}